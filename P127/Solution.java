import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> haveReachedWords = new HashSet<String>();
      Set<String> wordsToReach = new HashSet<String>(wordList);
      haveReachedWords.add(beginWord);
      int dis = 1;
      int l = beginWord.length();
      while(true){
        if(haveReachedWords.size() == 0)  return 0;
        if(haveReachedWords.contains(endWord))  break;
        Set<String> thisReachedWords = new HashSet<String>();
        for(String reachedWord : haveReachedWords){
          for(int i = 0 ; i < l ; i ++ ){
            char[] wordCharsChangeI = reachedWord.toCharArray();
            for(char c = 'a'; c <= 'z'; c++ ){
              wordCharsChangeI[i] = c;
              String stringChangeI = new String(wordCharsChangeI);
              if(wordsToReach.contains(stringChangeI)){
                thisReachedWords.add(stringChangeI);
                wordsToReach.remove(stringChangeI);
              }
            }
          }
        }
        haveReachedWords = thisReachedWords;
        dis++;
      }
      return dis;

    }
}
