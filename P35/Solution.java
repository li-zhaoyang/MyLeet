class Solution {
    public int searchInsert(int[] nums, int target) {
      if(nums.length == 0)  return 0;
      return findIdx(nums, 0, nums.length-1, target) ;
    }

    public int findIdx(int[] nums, int start, int end, int target){
      if(start == end){
        if(nums[start] < target) return start+1;
        return start;
      }
      if(start + 1 == end){
        if(nums[start] >= target) return start;
        if(nums[end] >= target) return end;
        return end+1;
      }
      if(nums[start] > target)  return start;
      if(nums[end] < target)  return end+1;
      int mid = start + (end - start)/2;
      if(nums[mid] < target) return findIdx(nums, mid+1, end, target);
      if(nums[mid] > target)  return findIdx(nums, start, mid-1,target);
      return mid;
    }

}
