class Solution {
    public int findMin(int[] nums) {
      if (nums == null || nums.length == 0) return -1;
      return binaryHelper(nums, 0, nums.length - 1);
    }
    private int binaryHelper(int[] nums, int start, int end) {
      if (start == end) return nums[start];
      int mid = start + (end - start) / 2;
      if (nums[mid] > nums[end]) return binaryHelper(nums, mid + 1, end);
      if (nums[mid] < nums[start]) return binaryHelper(nums, start, mid);
      return nums[start];
    }
}
