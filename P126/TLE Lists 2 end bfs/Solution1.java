import java.util.*;
class Solution {
    private static int shortestLength = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      // Set<String> pathSet = new HashSet<String>();
      List<List<String>> ans = new ArrayList<List<String>>();
      if(!wordList.contains(endWord)) return ans;
      List<String> thisPath = new ArrayList<String>();
      List<String> thisPathFromEnd = new ArrayList<String>();
      List<List<String>> tempPathsList = new ArrayList<List<String>>();
      List<List<String>> tempPathsListFromEnd = new ArrayList<List<String>>();
      thisPath.add(beginWord);
      thisPathFromEnd.add(endWord);
      tempPathsList.add(thisPath);
      tempPathsListFromEnd.add(thisPathFromEnd);
      int ansLength = Integer.MAX_VALUE;
      // Set<String> reachedWords = new Set<String> reachedWords;
      for(int k = 0 ; ;k++){
        boolean found = false;

        for(int indexFromEnd = 0; indexFromEnd < tempPathsListFromEnd.size(); indexFromEnd ++){
          String lastWordFromEnd = tempPathsListFromEnd.get(indexFromEnd).get(tempPathsListFromEnd.get(indexFromEnd).size() - 1);
          for(int index = 0; index < tempPathsList.size(); index ++){
            String lastWord = tempPathsList.get(index).get(tempPathsList.get(index).size() - 1);
            if(lastWordFromEnd.equals(lastWord)){
              List<String> thisPathListOfJ0 = new ArrayList<String>(tempPathsList.get(index));
              List<String> thisListFromEndToAdd = new ArrayList<String>(tempPathsListFromEnd.get(indexFromEnd));
              Collections.reverse(thisListFromEndToAdd);
              thisListFromEndToAdd.remove(lastWord);
              thisPathListOfJ0.addAll(thisListFromEndToAdd);
              // if(ansLength == Integer.MAX_VALUE) ansLength = thisPathListOfJ1.size();
              ans.add(thisPathListOfJ0);
              // System.out.println(1);
              found = true;
            }
          }
        }
        if(found) return ans;

        boolean noChange = true;
        List<List<String>> thisTempPathsList = new ArrayList<List<String>>();
        List<List<String>> thisTempPathsListFromEnd = new ArrayList<List<String>>();
        Set<String> firstGet = new HashSet<String>();
        for(int indexFromEnd = 0; indexFromEnd < tempPathsListFromEnd.size(); indexFromEnd ++){
          String lastWordFromEnd = tempPathsListFromEnd.get(indexFromEnd).get(tempPathsListFromEnd.get(indexFromEnd).size() - 1);
          StringBuilder sb = new StringBuilder(lastWordFromEnd);
          for(int iFromEnd = 0 ; iFromEnd < lastWordFromEnd.length() ; iFromEnd ++){
            for(int jFromEnd = 0 ; jFromEnd < 26; jFromEnd++){
              sb.setCharAt(iFromEnd, (char) ('a' + jFromEnd));
              String newWordFromEnd = sb.toString();
              sb.setCharAt(iFromEnd, lastWordFromEnd.charAt(iFromEnd));
              if( !tempPathsListFromEnd.get(indexFromEnd).contains(newWordFromEnd) && wordList.contains(newWordFromEnd)){
                noChange = false;
                List<String> thisPathListOfJFromEnd = new ArrayList<String>(tempPathsListFromEnd.get(indexFromEnd));
                for(int index = 0; index < tempPathsList.size(); index ++){
                  String lastWord = tempPathsList.get(index).get(tempPathsList.get(index).size() - 1);
                  if(newWordFromEnd.equals(lastWord)){
                    firstGet.add(lastWord);
                    List<String> thisPathListOfJ1 = new ArrayList<String>(tempPathsList.get(index));
                    List<String> thisListFromEndToAdd = new ArrayList<String>(thisPathListOfJFromEnd);
                    Collections.reverse(thisListFromEndToAdd);
                    thisPathListOfJ1.addAll(thisListFromEndToAdd);
                    // if(ansLength == Integer.MAX_VALUE) ansLength = thisPathListOfJ1.size();
                    ans.add(thisPathListOfJ1);
                    // System.out.println(2);
                    found = true;
                  }
                }
                thisPathListOfJFromEnd.add(newWordFromEnd);
                thisTempPathsListFromEnd.add(thisPathListOfJFromEnd);
                // if(found) continue;
              }
            }
          }
        }
        for(int index = 0; index < tempPathsList.size(); index ++){
          String lastWord = tempPathsList.get(index).get(tempPathsList.get(index).size() - 1);
          StringBuilder sb = new StringBuilder(lastWord);
          if(firstGet.contains(lastWord)) continue;
          for(int i = 0 ; i < lastWord.length() ; i ++){
            for(int j = 0 ; j < 26; j++){
              sb.setCharAt(i,(char) ('a' + j) );
              String newWord = sb.toString();
              sb.setCharAt(i, lastWord.charAt(i));
              // System.out.println(newWord);
              if( !tempPathsList.get(index).contains(newWord) && wordList.contains(newWord)){
                noChange = false;
                List<String> thisPathListOfJ = new ArrayList<String>(tempPathsList.get(index));

                for(int indexFromEnd = 0; indexFromEnd < tempPathsListFromEnd.size(); indexFromEnd ++){
                  String lastWordFromEnd = tempPathsListFromEnd.get(indexFromEnd).get(tempPathsListFromEnd.get(indexFromEnd).size() - 1);
                  if(newWord.equals(lastWordFromEnd)){
                    List<String> thisPathListOfJ2 = new ArrayList<String>(thisPathListOfJ);
                    List<String> thisListFromEndToAdd = new ArrayList<String>(tempPathsListFromEnd.get(indexFromEnd));
                    Collections.reverse(thisListFromEndToAdd);
                    thisPathListOfJ2.addAll(thisListFromEndToAdd);
                    // if(ansLength == Integer.MAX_VALUE) ansLength = thisPathListOfJ2.size();
                    ans.add(thisPathListOfJ2);
                    // System.out.println(3);
                    found = true;
                  }
                }
                thisPathListOfJ.add(newWord);
                thisTempPathsList.add(thisPathListOfJ);
                // if(found) continue;
              }
            }
          }
        }
        if(found || noChange) break;
        tempPathsListFromEnd = thisTempPathsListFromEnd;
        tempPathsList = thisTempPathsList;

      }
      // helpFind(ans, thisPathList, beginWord, endWord, wordList);
      return ans;
    }

}
