import java.util.*;
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
      if(l1 + l2 != l3) return false;
      int[][] memory = new int[s1.length()][s2.length()];
      return helperIsInterleave(s1, s2, s3, 0, 0, memory);

    }

    private boolean helperIsInterleave(String s1, String s2, String s3, int i , int j, int[][] memory){
      int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
      if(i == l1) return s2.substring(j).equals( s3.substring(i + j) );
      if(j == l2) return s1.substring(i).equals( s3.substring(i + j) );
      if(memory[i][j] == 1 )  return true;
      if(memory[i][j] == -1) return false;
      boolean con1 = false, con2 = false;
      if(i < l1 && s1.charAt(i) == s3.charAt(i + j))  con1 = helperIsInterleave(s1, s2, s3, i + 1, j,  memory);
      if(j < l2 && s2.charAt(j) == s3.charAt(i + j))  con2 = helperIsInterleave(s1, s2, s3, i, j + 1,  memory);
      if(con1 || con2)  memory[i][j] = 1;
      else memory[i][j] = -1;
      return con1 || con2;
    }
}
