class Solution {
    public int[] searchRange(int[] nums, int target) {
      int[] ans = {-1,-1};
      if(nums.length == 0)  return ans;

      ans[1] = findLargestIdx(nums, 0, nums.length-1, target) ;
      ans[0] = findSmallestIdx(nums, 0, nums.length-1, target);
      return ans;
    }

    public int findLargestIdx(int[] nums, int start, int end, int target){
      if(start == end){
        if(nums[start] == target) return start;
        return -1;
      }
      if(start +1 == end){
        if(nums[end] == target) return end;
        if(nums[start] == target) return start;
        return -1;
      }
      if(nums[start] > target){
        return -1;
      }
      int mid = start + (end - start)/2;
      if(nums[mid] < target) return findLargestIdx(nums, mid+1, end, target);
      if(nums[mid] > target)  return findLargestIdx(nums, start, mid-1,target);
      return findLargestIdx(nums, mid, end, target);
    }

    public int findSmallestIdx(int[] nums, int start, int end, int target){
      if(start == end){
        if(nums[start] == target) return start;
        return -1;
      }
      if(start +1 == end){
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
      }
      if(nums[end] < target)  return -1;
      int mid = start + (end - start)/2;
      if(nums[mid] < target) return findSmallestIdx(nums, mid+1, end, target);
      if(nums[mid] > target)  return findSmallestIdx(nums, start, mid-1,target);
      return findSmallestIdx(nums, start, mid, target);
    }
}
