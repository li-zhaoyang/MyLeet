import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      int size = triangle.size();
      if(size == 0)  return 0;
      int[] minPathSum = new int[triangle.get(size - 1).size()];
      for(int i = 0 ; i < minPathSum.length; i ++){
        minPathSum[i] = triangle.get(size - 1).get(i);
      }
      for( int i = size - 2; i>=0 ; i --){
        for(int j = 0; j <= i; j ++){
          minPathSum[j] = (minPathSum[j] < minPathSum[j + 1] ? minPathSum[j] : minPathSum[j + 1]) + triangle.get(i).get(j);
        }
      }
      return minPathSum[0];
    }

}
