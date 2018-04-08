import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      List<String> newWordList = new ArrayList<String>(wordList);
      newWordList.remove(beginWord);
      int ans = helper(0, beginWord, endWord, newWordList);
      return ans + 1;
    }

    private int helper(int moved, String thisWord, String endWord, List<String> wordList){
      if(thisWord.compareTo(endWord) == 0)  return moved;
      if(diffCharNum(thisWord, endWord) > wordList.size())  return -1;
      List<Integer> ansList = new ArrayList<Integer>();
      for(int i = 0 ; i < wordList.size(); i++){
        String thisWordInList = wordList.get(i);
        if(diffCharNum(thisWord, thisWordInList) == 1){
          List<String> thisWordList = new ArrayList<String>(wordList);
          thisWordList.remove(thisWordInList);
          int thisAllMove = helper(moved + 1, thisWordInList, endWord, thisWordList);
          if(thisAllMove != -1) ansList.add(thisAllMove);
        }
      }
      if(ansList.size() == 0) return -1;
      int min = Integer.MAX_VALUE;
      for(int i = 0 ; i < ansList.size(); i++){
        if(ansList.get(i) < min)  min = ansList.get(i);
      }
      return min;
    }

    private int diffCharNum(String s1, String s2){
      int diff = 0;
      for(int i = 0 ; i < s1.length(); i ++){
        if(s1.charAt(i) != s2.charAt(i))  diff++;
      }
      return diff;

    }
}
