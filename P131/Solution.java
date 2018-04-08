import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
      List<List<String>> ans = new ArrayList<List<String>>();
      List<String> hasS = new ArrayList<String>();
      helper(ans, hasS, s, 0);
      return ans;
    }
    private void helper(List<List<String>> ans, List<String> hasS, String s, int from){
      if(from == s.length())  {
        ans.add(hasS);
        return;
      }
      for(int i = from + 1; i <= s.length(); i ++){
        if(isPalindrome(s, from, i)){
          List<String> thisHasS = new ArrayList<String>(hasS);
          thisHasS.add(s.substring(from, i));
          helper(ans, thisHasS, s, i);
        }
      }
    }

    private boolean isPalindrome(String s, int start, int end){
      for( int i = 0 ; i < (end - start)/2; i++){
        if(s.charAt(start + i) != s.charAt(end- i - 1) ) return false;
      }
      return true;
    }
}
