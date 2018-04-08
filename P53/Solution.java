class Solution {
    public int maxSubArray(int[] nums) {
      int max = Integer.MIN_VALUE;
      int maxNow = 0;
      for(int i = 0 ; i < nums.length ; i++){
        maxNow = (maxNow > 0) ? maxNow + nums[i]:nums[i];
        max = max > maxNow ? max:maxNow;
      }
      return max;

    }
}
