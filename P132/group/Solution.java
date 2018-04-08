import java.util.*;
class Solution {
    public int minCut(String s) {
      if(s == null || s.length() < 2) return 0;
      int l = s.length();
      int[] minCut = new int[l];
      boolean[][] isPal = new boolean[l][l];
      for (int i = 0; i < l; i++) {
        int min = i;
        for (int j = 0; j <= i; j++) {
          if (s.charAt(j) == s.charAt(i) && ((j + 2 >= i) || isPal[j + 1][i - 1])) {
            isPal[j][i] = true;
            if (j == 0) min = 0;
            else {
              min = min < minCut[j - 1] + 1? min : minCut[j - 1] + 1;
            }
          }
          minCut[i] = min;
        }
      }
      return minCut[l - 1];
    }

}
