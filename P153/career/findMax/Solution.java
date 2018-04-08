class Solution {
    public int findMax(int[] nums) {
      if (nums == null || nums.length == 0) return -1;
      return binaryHelper(nums, 0, nums.length - 1);
    }
    private int binaryHelper(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        if (start + 1 == end) return Math.max(nums[start], nums[end]);
        int mid = start + (end - start) / 2;
        if (nums[mid] > nums[end])  return binaryHelper(nums, mid, end - 1);
        if (nums[mid] < nums[start]) return binaryHelper(nums, start, mid - 1);
        return nums[end];
    }
}
