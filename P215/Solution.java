class Solution {
    public int findKthLargest(int[] nums, int k) {
      return select(nums, 0, nums.length - 1, k - 1);
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
      int pivotValue = nums[pivotIndex];
      nums[pivotIndex] = nums[right];
      nums[right] = pivotValue;
      int pivotPos = left;
      for (int i = left; i < right; i++) {
        if (nums[i] > pivotValue) {
          int temp = nums[i];
          nums[i] = nums[pivotPos];
          nums[pivotPos] = temp;
          pivotPos++;
        }
      }
      int temp = nums[right];
      nums[right] = nums[pivotPos];
      nums[pivotPos] = temp;
      return pivotPos;
    }

    private int select(int[] nums, int left, int right, int k) {
      if (left == right)  return nums[left];
      int pivotIndex = left + (int) Math.floor(Math.random() * (right - left + 1));
      pivotIndex = partition(nums, left, right, pivotIndex);
      if (pivotIndex < k) return select(nums, pivotIndex + 1, right, k);
      if (pivotIndex > k) return select(nums, left, pivotIndex - 1, k);
      return nums[pivotIndex];
    }
}
