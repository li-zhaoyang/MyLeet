class Solution {
    public int rob(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int countLastLast = 0, countLast;
      for (int i = 0; i < nums.length; i ++) {
        int thisMax = Math.max(nums[i] + countLastLast, countLast);
        countLastLast = countLast;
        countLast = thisMax;
      }
      return countLast;
    }
}
