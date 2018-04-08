class Solution {
    public int rob(int[] nums) {
      if(nums == null) return 0;
      int lastMax = 0, lastLastMax = 0;
      for(int i = 0 ; i < nums.length ; i ++){
        int thisMax = nums[i] + lastLastMax;
        lastLastMax = lastMax;
        if(thisMax > lastMax) lastMax = thisMax;
      }
      return lastMax;
    }
}
