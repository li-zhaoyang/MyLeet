import java.util.*;

class Solution {
    public int numDistinct(String s, String t) {
      if(s == null || s.length() == 0)  return 0;
      if(t == null || t.length() == 0)  return 0;
      int l1 = s.length();
      int l2 = t.length();
      int[][] ans = new int[l1][l2];


      for(int i = 0 ; i < l1; i++){
        for(int j = 0; j < l2 ; j ++){
          ans[i][j] = -1;
        }
      }
      helper(ans, s, t, 0, 0);
      for(int i = 0 ; i < l1; i++){
        for(int j = 0; j < l2 ; j ++){
          System.out.print(ans[i][j] +" ");
        }
        System.out.println("");
      }

      return ans[0][0] ;
    }

    private int helper(int[][] ans, String s, String t, int ps, int pt){
      if(pt == t.length())  {
        if(ps == s.length()){
          return 1;
        }
        return 1 + helper(ans, s, t, ps, pt - 1);
      }
      if(ps == s.length())  return 0;
      if(ans[ps][pt] != -1) return ans[ps][pt];
      if(s.charAt(ps) == t.charAt(pt)){
        ans[ps][pt] = helper(ans, s, t, ps + 1, pt) + helper(ans, s, t, ps + 1, pt + 1);
      }else{
        ans[ps][pt] = helper(ans, s, t, ps + 1, pt);
      }
      return ans[ps][pt];
    }
}
