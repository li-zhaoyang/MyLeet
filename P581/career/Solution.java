class Solution {
    public int findUnsortedSubarray(int[] nums) {
      if (nums == null || nums.length <= 1) return 0;
      int l = nums.length;
      int min = nums[l - 1], max = nums[0], begin = -1, end = -2;
      for (int i = 1; i < l; i++) {
        if (nums[i] < max) end = i;
        if (nums[l - i - 1] > min)  start = l - i - 1;
        max = Math.max(nums[i], max);
        min = Math.min(nums[l - i - 1], min);
      }
      return end - start + 1;
    }
}
