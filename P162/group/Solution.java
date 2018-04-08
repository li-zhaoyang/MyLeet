class Solution {
    public int findPeakElement(int[] nums) {
      return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int start, int end) {
      if (start == end) return start;
      if (start + 1 == end) return nums[start] > nums[end] ? start : end;
      int mid = start + (end - start) / 2;
      // from before mid != 0, mid != length - 1
      if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
      if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) return helper(nums, mid + 1, end);
      else return helper(nums, start, mid - 1);
      // we have end >= start + 2 so mid - 1 >= start
    }
}
