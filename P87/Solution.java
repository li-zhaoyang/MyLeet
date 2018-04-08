import java.util.*;
class Solution {
    public boolean isScramble(String s1, String s2) {
      if(s1 == null && s2 == null )  return true;
      if(s1.length() != s2.length())  return false;
      int l = s1.length();
      if(l == 0)  return true;
      int[] map = new int[128];
      for(int i = 0 ; i < l; i++){
        map[s1.charAt(i)] ++;
      }
      for(int i = 0 ; i < l; i++){
        map[s2.charAt(i)] --;
        if(map[s2.charAt(i)] < 0) return false;
      }
      
      if(l <= 3)  return true;

      for(int i = 1 ; i < l; i ++){
        if( isScramble(s1.substring(0,i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))  return true;
        if( isScramble(s1.substring(0,i), s2.substring(l - i)) && isScramble(s1.substring(i), s2.substring(0, l - i)))  return true;
      }
      return false;
    }
}
