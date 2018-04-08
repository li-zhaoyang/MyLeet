class Solution {
    public int findKthLargest(int[] nums, int k) {
      return select(nums, 0, nums.length - 1, k - 1);
    }
    private int select(int[] nums, int left, int right, int k) {
      if (left == right)  return nums[left];
      int pivotIndex = left + (int) Math.floor(Math.random() * (right - left + 1));
      //partition
      int temp = nums[right];
      nums[right] = nums[pivotIndex];
      nums[pivotIndex] = temp;
      int smallIndex = left;
      for (int i = left; i < right; i++) {
        if (nums[i] > nums[right]) {
          temp = nums[smallIndex];
          nums[smallIndex] = nums[i];
          nums[i] = temp;
          smallIndex++;
        }
      }
      temp = nums[right];
      nums[right] = nums[smallIndex];
      nums[smallIndex] = temp;
      if (smallIndex < k) {
        return select(nums, smallIndex + 1, right, k);
      } else if (smallIndex > k) {
        return select(nums, left, smallIndex - 1, k);
      } else
        return nums[smallIndex];
    }
}
