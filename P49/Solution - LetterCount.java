import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      //int groupNum = 0;
      Map<String, List> theMap= new HashMap<String, List>();
      int[] count = new int[26];

      for(String s:strs){
        Arrays.fill(count,0);
        for(char c:s.toCharArray()) count[c - 'a']++;
        StringBuffer thisSb = new StringBuffer();
        for(int n:count){
          thisSb.append('#');
          thisSb.append(Integer.toString(n));
        }
        String mapKeyS = thisSb.toString();
        if(!theMap.containsKey(mapKeyS)) theMap.put(mapKeyS, new LinkedList<String>());
        theMap.get(mapKeyS).add(s);
      }
      //List<List<String>> sameModeStrGroups = new LinkedList<List<String>>();
      return new ArrayList(theMap.values());
    }
}
