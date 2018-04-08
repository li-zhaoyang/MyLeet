import java.util.*;         //sorted String
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      Map<String, List> theMap= new HashMap<String, List>();
      //int[] count = new int[26];

      for(String s:strs){
        //Arrays.fill(count,0);
        //for(char c:s.toCharArray()) count[c - 'a']++;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String mapKeyS = new String( chars );
        // StringBuffer thisSb = new StringBuffer();
        // for(int n:count){
        //   thisSb.append('#');
        //   thisSb.append(Integer.toString(n));
        // }
        // String mapKeyS = thisSb.toString();
        if(!theMap.containsKey(mapKeyS)) theMap.put(mapKeyS, new LinkedList<String>());
        theMap.get(mapKeyS).add(s);
      }

      return new ArrayList(theMap.values());
    }
}
