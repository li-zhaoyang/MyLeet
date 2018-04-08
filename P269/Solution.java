import java.util.*;
class Solution {
    public String alienOrder(String[] words) {
      if (words == null || words.length == 0) return "";

      //make graph: neighbor table
      HashMap<Character, HashSet<Character>> neighborTable = new HashMap<Character, HashSet<Character>>();
      HashMap<Character, Integer> inDegree = new HashMap<Character, Integer>();
      helperConstructGraph(0, words, 0, words.length - 1, neighborTable, inDegree);

      //topological sort
      Queue<Character> nextLevel = new LinkedList<Character>();
      for (Character key: inDegree.keySet()) {
        if (inDegree.get(key) == 0) nextLevel.offer(key);
      }
      List topoSort = new ArrayList<Character>();
      while (!nextLevel.isEmpty()) {
        char thisChar = nextLevel.poll();
        topoSort.add(thisChar);
        for (char nextLevelChar: neighborTable.get(thisChar)) {
          int nextLevelCharInDegree = inDegree.get(nextLevelChar);
          if (nextLevelCharInDegree == 1) nextLevel.offer(nextLevelChar);
          else inDegree.put(nextLevelChar, nextLevelCharInDegree - 1);
        }
      }
      
      //generate answer string
      if (topoSort.size() != neighborTable.size()) return "";
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < topoSort.size(); i++) {
        sb.append(topoSort.get(i));
      }
      return sb.toString();
    }

    private void helperConstructGraph(int startPos, String[] words, int startIndex, int endIndex, HashMap<Character, HashSet<Character>> neighborTable, HashMap<Character, Integer> inDegree) {
      if (startIndex == endIndex) {
        for (int i = startPos; i < words[startIndex].length(); i++) {
          char thisChar = words[startIndex].charAt(i);
          if (!neighborTable.containsKey(thisChar)) neighborTable.put(thisChar, new HashSet<Character>());
          if (!inDegree.containsKey(thisChar)) inDegree.put(thisChar, 0);
        }
        return;
      }
      int thisStartIdx = startIndex;
      char lastChar = ' ';
      for (int i = startIndex; i <= endIndex; i++) {
        if (startPos >= words[i].length())  continue;
        char thisChar  = words[i].charAt(startPos);
        if (!neighborTable.containsKey(thisChar)) neighborTable.put(thisChar, new HashSet<Character>());
        if (!inDegree.containsKey(thisChar)) inDegree.put(thisChar, 0);
        if (thisChar != lastChar && lastChar != ' ') {
          HashSet<Character> thisNeighborSet = neighborTable.getOrDefault(lastChar, new HashSet<Character>());
          if (!thisNeighborSet.contains(thisChar)) {
            thisNeighborSet.add(thisChar);
            neighborTable.put(lastChar, thisNeighborSet);
            inDegree.put(thisChar, inDegree.getOrDefault(thisChar, 0) + 1);
          }
          helperConstructGraph(startPos + 1, words, thisStartIdx, i - 1, neighborTable, inDegree);
          thisStartIdx = i;
        }
        lastChar = words[i].charAt(startPos);
      }
      //only need to recurse last period of words when lastChar is modified
      if (lastChar != ' ')  helperConstructGraph(startPos + 1, words, thisStartIdx, endIndex, neighborTable, inDegree);

    }
}
