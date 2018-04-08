import java.util.*;
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      int[] map = new int[128];
      int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
      if(l1 + l2 != l3) return false;
      if(l1 == 0 && l2 == 0 && l3 == 0)  return true;
      for(int i = 0 ; i < l1 || i < l2 || i < l3; i ++){
        if(i < l1) map[s1.charAt(i)] ++;
        if(i < l2) map[s2.charAt(i)] ++;
        if(i < l3) map[s3.charAt(i)] --;
      }
      for(int i = 0 ; i < map.length; i ++){
        if(map[i] != 0) return false;
      }
      boolean con1 = false, con2 = false;
      if(l1 > 0 && s1.charAt(0) == s3.charAt(0))  con1 = isInterleave(s1.substring(1), s2, s3.substring(1));
      if(l2 > 0 && s2.charAt(0) == s3.charAt(0))  con2 = isInterleave(s1, s2.substring(1), s3.substring(1));
      return con1 || con2;

    }
}
