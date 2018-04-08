import java.util.*;
class Solution {
    public List<String> removeInvalidParentheses(String s) {
      List<String> ans = new ArrayList<String>();
      if (s == null)  return ans;
      Queue<String> queue = new LinkedList<String>();
      Set<String> inQueue = new HashSet<String>();
      queue.offer(s);
      inQueue.add(s);
      while (!queue.isEmpty()) {
        int size = queue.size();
        // System.out.println(size + "");
        boolean ansAtThisLevel = false;
        for (int i = 0; i < size; i++) {
          String thisStr = queue.poll();
          int l = thisStr.length();
          if (isValid(thisStr)) {
            ans.add(thisStr);
            ansAtThisLevel = true;
          }
          if (ansAtThisLevel) continue;
          for (int j = 0; j < l; j++) {
            if (thisStr.charAt(j) == '(' || thisStr.charAt(j) == ')') {
              String thisNextLevelStr = thisStr.substring(0, j) + thisStr.substring(j + 1);
              if (!inQueue.contains(thisNextLevelStr)) {
                queue.offer(thisNextLevelStr);
                inQueue.add(thisNextLevelStr);
              }
            }
          }
        }
        if(ansAtThisLevel) return ans;
      }
      return ans;
    }

    boolean isValid(String s) {
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') count++;
        if (c == ')' && count-- == 0) return false;
      }
      return count == 0;
  }

}
