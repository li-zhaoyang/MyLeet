import java.util.*;
class Solution {
    public int minDistance(String word1, String word2) {

      int m = word1.length(), n = word2.length();

      if(m == 0)  return n ;
      if(n == 0)  return m ;

      int[][] dp = new int[m + 1][n + 1];
      for(int i = 0 ; i <= m + n; i ++){
        if(i <= m) dp[i][0] = i;
        if(i <= n) dp[0][i] = i;
        if( i > m && i > n)  break;
      }

      for( int i = 1 ; i <= m ; i ++){
        for(int j = 1 ; j <= n; j ++ ){
          int thisMin = dp[i][j - 1] + 1;
          thisMin = thisMin < (dp[i - 1][j] + 1) ? thisMin : (dp[i - 1][j] + 1) ;
          if(word1.charAt(i - 1) == word2.charAt(j - 1)){
            thisMin = thisMin < dp[i - 1][j - 1] ? thisMin : dp[i - 1][j - 1] ;
          }
          else{
            thisMin = thisMin < (dp[i - 1][j - 1] + 1) ? thisMin : (dp[i - 1][j - 1] + 1) ;
          }
          dp[i][j] = thisMin;
        }
      }
      return dp[m][n];
    }
}
