class Solution {
    public int search(int[] nums, int target) {
      if(nums.length == 0)  return -1;
      if(nums.length == 1){
        if(nums[0] == target) return 0;
        return -1;
      }
      int start = 0, end = nums.length;
      int splitI = findSplitIndex(nums, start, end);
      if(target < nums[0])  return findInSorted(nums, splitI, end, target);
      if(target > nums[end-1])  return findInSorted(nums, start, splitI, target);
      //return findInSorted(nums, start, end, target);
      return findInSorted(nums, start, end, target);

    }
    public int findInSorted(int[] nums, int start, int end, int target){
      if(start==end || start+1 == end ){
        if(start == nums.length)  return -1;
        if(nums[start] == target) return start;
        return -1;
      }
      if(nums[(start+end)/2] > target) return findInSorted(nums, start, (start+end)/2, target);
      if(nums[(start+end)/2] < target) return findInSorted(nums, (start+end)/2, end, target);
      return (start+end)/2;
    }
    public int findSplitIndex(int[] nums, int start, int end){
      if(start == end || start+1 == end)  return end;
      if( nums[(start+end)/2] < nums[start] ) return findSplitIndex(nums, start, (start+end)/2);
      if( nums[(start+end)/2] > nums[end-1] ) return findSplitIndex(nums, (start+end)/2, end);
      return end;
    }
}
