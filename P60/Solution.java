import java.util.*;
class Solution {
    public String getPermutation(int n, int k) {
      //StringBuffer sb = new StringBuffer();
      //int[] nums = new int[n];
      char[] numsC = new char[n];
      int[] factorial = new int[n];
      factorial[0] = 1;
      List<Integer> restNums = new LinkedList<Integer>();
      for(int i = 0 ; i < n ; i++){
        restNums.add(i+1);
        if(i != 0)  factorial[i] = (i+1) *factorial[i-1];
      }

      int res = k-1;
      for(int i = 0; i < n ; i++){
        if(i == n-1){
          // nums[i] = restNums.get(0);
          numsC[i] = (char) (restNums.get(0) + '0');
          break;
        }
        int index = res / (factorial[n-i-2]);
        // nums[i] = restNums.get( index ) ;
        numsC[i] = (char) (restNums.get(index) + '0');
        restNums.remove( index );
        res = res % (factorial[n-i-2]);
      }

      // for(int i = 0 ; i < n ; i++){
      //   System.out.println(nums[i]);
      // }

      return new String(numsC);




    }
}
