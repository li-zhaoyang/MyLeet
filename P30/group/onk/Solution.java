import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> ans = new ArrayList<Integer>();
      if(s == null ||words == null || words.length == 0 || words[0] == null) return ans;
      int wordsNum = words.length, wordLength = words[0].length();
      int substringLength = wordsNum * wordLength;
      if(s.length() == 0) {
        if(substringLength != 0){
          return ans;
        }
        ans.add(0);   //s = "", words = {""}, match at 0
        return ans;
      }

      Map<String, Integer> count = new HashMap<String, Integer>();
      for (String word: words)
        if (count.containsKey(word)) count.put(word, count.get(word) + 1);
        else count.put(word, 1);
      for (int i = 0; i < s.length() - substringLength + 1; i++) {
        String thisWordToCheck = s.substring(i, i + wordLength);
        if (!count.containsKey(thisWordToCheck)) continue;
        int j = i;
        Map<String, Integer> thisCount = new HashMap<String, Integer>(count);
        for (; j < substringLength + i; j += wordLength) {
          String thisWord = s.substring(j, j + wordLength);
          if (thisCount.containsKey(thisWord)) {
            thisCount.put(thisWord, thisCount.get(thisWord) - 1);
            if (thisCount.get(thisWord) < 0) break;
          } else break;
        }
        if (j == substringLength + i) ans.add(i);
      }
      return ans;
    }



}
