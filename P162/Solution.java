class Solution {
    public int findPeakElement(int[] nums) {
      return binaryFindChange(nums, 0, nums.length);
    }

    private int binaryFindChange(int[] nums, int start, int end){
      if(start + 1 >= end)  return start;
      int mid = start + (end - start)/2;
      boolean midChange = computeMidChange(nums, mid);
      if(midChange == false){
        if(computeMidChange(nums, mid - 1)) return mid - 1;
        return binaryFindChange(nums, start, mid - 1);
      }
      if(midChange == true){
        if(!computeMidChange(nums, mid + 1 )) return mid;
        return binaryFindChange(nums, mid + 1, end);
      }
      return 0;
    }

    private boolean computeMidChange(int[] nums, int mid){
      if(mid == 0)  return true;
      if(mid == nums.length)  return false;
      return ((nums[mid] - nums[mid - 1]) > 0);
    }
}
