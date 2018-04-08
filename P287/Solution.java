class Solution {
    public int findDuplicate(int[] nums) {
      if (nums == null || nums.length < 2) return -1;
      int fast = nums[nums[0]];
      int slow = nums[0];
      while (true) {
        if (nums[slow] == nums[fast]) return nums[slow];
        slow = nums[slow];
        fast = nums[nums[fast]];
      }
    }
}
