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
      //initialize count
      Map<String, Integer> originCount = new HashMap<String, Integer>();
      for (String word: words){
        originCount.put(word, originCount.containsKey(word) ? originCount.get(word) + 1 : 1);
      }
      // wordLength possibilities of window start position
      for (int startFrom = 0; startFrom < wordLength && startFrom <= s.length() - substringLength; startFrom++) {
        Map<String, Integer> count = new HashMap<String, Integer>(originCount);
        int outWordNum = 0, negWordNum = 0;
        //initialize window
        for (int i = startFrom; i < startFrom + substringLength; i += wordLength) {
          String thisWord = s.substring(i, i + wordLength);
          if (!count.containsKey(thisWord)) outWordNum++;
          else {
            count.put(thisWord, count.get(thisWord) - 1);
            if (count.get(thisWord) < 0)  negWordNum++;
          }
        }
        //check and move window
        int i = startFrom;
        boolean justChecked = false;
        for (; i < s.length() - substringLength; i += wordLength) {
          if (outWordNum == 0 && negWordNum == 0) ans.add(i);
          justChecked = true;
          String thisMoveOutWord = s.substring(i, i + wordLength);
          if (!count.containsKey(thisMoveOutWord)) outWordNum--;
          else {
            count.put(thisMoveOutWord, count.get(thisMoveOutWord) + 1);
            if (count.get(thisMoveOutWord) <= 0)  negWordNum--;
          }
          if(i + substringLength + wordLength > s.length()) break;
          String newWord = s.substring(i + substringLength, i + substringLength + wordLength);
          justChecked = false;
          if (!count.containsKey(newWord)) outWordNum++;
          else {
            count.put(newWord, count.get(newWord) - 1);
            if (count.get(newWord) < 0)  negWordNum++;
          }
        }
        if (!justChecked && outWordNum == 0 && negWordNum == 0) ans.add(i); //last check
      }
      return ans;
    }

}
