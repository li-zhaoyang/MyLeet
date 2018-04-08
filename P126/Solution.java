import java.util.*;
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> ans = new ArrayList<List<String>>();
      Set<String> dict = new HashSet<String>(wordList);
      if(! dict.contains(endWord))  return ans;
      Set<String> set1 = new HashSet<String>();
      Set<String> set2 = new HashSet<String>();
      set1.add(beginWord);
      set2.add(endWord);
      Map<String, Set<String>> map = new HashMap<String, Set<String>>();

      if(!helpFind(set1, set2, map, dict, true))  return ans;

      // Iterator it = map.entrySet().iterator();
      // while (it.hasNext()) {
      //     Map.Entry pair = (Map.Entry)it.next();
      //     System.out.println(pair.getKey() + " = " + pair.getValue());
      //     it.remove(); // avoids a ConcurrentModificationException
      // }
      List<String> thisAns = new ArrayList<String>();
      thisAns.add(beginWord);
      Set<String> mappedSet = new HashSet<String>();
      mappedSet.add(beginWord);
      helpConstruct(map, new ArrayList(map.get(beginWord)), thisAns, ans, endWord, mappedSet);
      return ans;

    }

    private boolean helpFind(Set<String> set1, Set<String> set2, Map<String, Set<String>> map, Set<String> wordList, boolean direction){

      if(set1.size() > set2.size()) return helpFind(set2, set1, map, wordList, !direction);

      Set<String> set = new HashSet<String>();

      boolean found = false;
      boolean change = false;
      for(String thisWord : set1){
        char[] charArr = thisWord.toCharArray();
        for(int i = 0 ; i < thisWord.length(); i++){
          char thisChar = charArr[i];
          for(char c = 'a';  c < ('a' + 26); c++){
            charArr[i] = c;
            String newWord = new String(charArr);

            String key = direction? thisWord:newWord;
            String valItem = direction? newWord:thisWord;
            if(!set1.contains(newWord) && wordList.contains(newWord)){
              change = true;
              Set<String> thisKeySet = map.containsKey(key)? map.get(key):new HashSet<String>();
              if(set2.contains(newWord)){
                found = true;
                // System.out.println("found : " + thisWord + " " + newWord);
              }
              set.add(newWord);
              // if(thisKeySet.contains(valItem)) continue;

              thisKeySet.add(valItem);
              // System.out.println(key + " " + valItem +" "+ found);
              map.put(key, thisKeySet);
            }
          }
          charArr[i] = thisChar;
        }
      }
      if(!change) return false;
      return found || helpFind(set2, set, map, wordList, !direction);

    }
    private void helpConstruct(Map<String, Set<String>> map, List<String> valList, List<String> thisAns ,List<List<String>> ans,  String endWord, Set<String> mappedSet ){
      // if(valList == null) return;
      // System.out.println("");
      for(String s: valList){
        // System.out.print(s + " ");
        List<String> thisList = new ArrayList<String>(thisAns);
        thisList.add(s);
        if( s.equals(endWord)){
          // System.out.println("here:" + endWord);
          ans.add(thisList);
          return;
        }
        if(!mappedSet.contains(s)) {
          Set<String> newSet = new HashSet<String>(mappedSet);
          newSet.add(s);
          if(map.get(s) == null) continue;
          helpConstruct(map, new ArrayList<String>(map.get(s)), thisList, ans, endWord, newSet);
        }
      }

    }

}
