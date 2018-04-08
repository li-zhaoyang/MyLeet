import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> ans = new ArrayList<Integer>();
      if(s == null ||words == null || words.length == 0 || words[0] == null) return ans;

      int length = words.length * words[0].length();
      if(s.length() == 0) {
        if(length != 0){
          return ans;
        }
        ans.add(0);
        return ans;
      }

      List<String> thisList = new ArrayList<String>();
      List<String> iDList = new ArrayList<String>();
      addWordID(iDList, thisList, words);

      Set stringCombSet = new HashSet(iDList);

      for(int i = 0 ; i < s.length() - length + 1; i ++){
        if( stringCombSet.contains( s.substring(i, i + length) ) ) ans.add(i);
      }

      return ans;

    }


    private void addWordID(List<String> iDList, List<String> hasList, String[] words){
      int l = words.length;
      int index = hasList.size();
      if(index == l){
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < l ; i ++){
          sb.append(hasList.get(i));
        }
        iDList.add(sb.toString());
        return;
      }
      for(int i = index; i < l ; i ++){
        String tempS = words[index];
        words[index] = words[i];
        words[i] = tempS;
        List<String> thisList = new ArrayList<String>(hasList);
        thisList.add(words[index]);
        addWordID(iDList, thisList, words);
        words[i] = words[index];
        words[index] = tempS;
      }
    }
}
