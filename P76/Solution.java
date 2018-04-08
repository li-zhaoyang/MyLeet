import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
      int[] map = new int[128];
      int start = 0, end = 0, resCharCount = t.length(), minDis = Integer.MAX_VALUE, bestStart = 0;
      for(int i = 0 ; i < t.length(); i ++){
        map[t.charAt(i)]++;
      }
      while(end < s.length()){
        if(map[s.charAt(end++)]-- > 0){
          resCharCount --;
        }
        while(resCharCount == 0){
          if(map[s.charAt(start++)]++ == 0){
            if(end - start + 1 < minDis) {
              minDis = end - start + 1;
              bestStart = start - 1;
            }
            resCharCount ++;
          }
        }
      }

      return minDis == Integer.MAX_VALUE? "" : s.substring(bestStart, bestStart + minDis);

    }
}
