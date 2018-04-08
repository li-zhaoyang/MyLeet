import java.util.*;

class Solution {
    public int numDistinct(String s, String t) {
      if(s == null || s.length() == 0)  return 0;
      if(t == null || t.length() == 0)  return 0;
      int l1 = s.length();
      int l2 = t.length();
      int[][] ans = new int[l1][l2];
      int count = 0;
      for(int i = 0 ; i < l1 ; i ++){
        if(s.charAt(i) == t.charAt(0)){
          count ++;
        }
        ans[i][0] = count;
      }

      for(int i = 1 ; i < l1; i++){
        for(int j = 1; j < l2 ; j ++){
          if(s.charAt(i) == t.charAt(j)){
            ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
          }else{
            ans[i][j] = ans[i-1][j];
          }
        }
      }

      for(int i = 0 ; i < l1; i++){
        for(int j = 0; j < l2 ; j ++){
          System.out.print(ans[i][j] +" ");
        }
        System.out.println("");
      }

      return ans[l1-1][l2-1] ;
    }

}
