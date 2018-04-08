import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> ans = new ArrayList<Integer>();
      if(s == null ||words == null || words.length == 0 || words[0] == null) return ans;
      int wordsNum = words.length, wordLength = words[0].length();
      int length = wordsNum * wordLength;
      if(s.length() == 0) {
        if(length != 0){
          return ans;
        }
        ans.add(0);
        return ans;
      }

      Map<String, Integer> count = new HashMap<String, Integer>();
      for(String word : words){
        count.put(word, count.containsKey(word) ? count.get(word) + 1 : 1);
      }

      for(int i = 0 ; i < s.length() - length + 1; i ++){
        int j = 0;
        Map<String, Integer> thisCount = new HashMap<String, Integer>(count);
        for( ; j < wordsNum ; j ++ ){
          String thisStringInS = s.substring(j * wordLength + i, j * wordLength + i + wordLength);
          if(thisCount.containsKey(thisStringInS)){
            if(thisCount.get(thisStringInS) > 1) thisCount.put(thisStringInS ,thisCount.get(thisStringInS) - 1);
            else thisCount.remove(thisStringInS);
          }else{
            break;
          }
        }
        if( j == wordsNum ) ans.add(i);
      }
      return ans;

    }



}
