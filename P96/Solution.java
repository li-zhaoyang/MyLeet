import java.util.*;
class Solution {
    public int numTrees(int n) {
      int[] nums = new int[n+1];
      nums[0] = 0;
      nums[1] = 1;
      return generateFromNums(n, nums);
    }

    private int generateFromNums(int n, int[] nums){
      if(n == 0 || n == 1)  return n;
      int ans = 0;
      for(int i = 0 ; i < n; i++){
        int ansLeft =0, ansRight = 0;
        if(i != 0){
          if(nums[i] != 0)  ansLeft = nums[i];
          else ansLeft = generateFromNums(i, nums);
        }
        if((n - 1 - i)!= 0 ){
          if(nums[n - 1 - i] != 0)  ansRight = nums[n - 1 - i];
          else ansRight = generateFromNums(n - 1 - i, nums);
        }
        if(ansLeft == 0 || ansRight == 0){
          ans += ansLeft + ansRight;
          continue;
        }
        ans += ansLeft * ansRight;
      }
      nums[n] = ans;
      return ans;
    }
}
