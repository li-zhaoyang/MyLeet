class Solution {
    public boolean search(int[] nums, int target) {
      int n = nums.length;
      if(n == 0) return false;
      if(n == 1){
        if(nums[0] == target) return true;
        return false;
      }
      int splitIndex = findSplitIndex(nums, 0, n-1);
      System.out.println(splitIndex);
      if(splitIndex == 0) return hasInt(nums, 0, n-1, target);
      if(target < nums[0]) return hasInt(nums, splitIndex, n-1, target);
      if(target > nums[n-1])  return hasInt(nums, 0, splitIndex-1, target);
      if(target == nums[0]) return true;
      return false;

    }
    private int findSplitIndex(int[] nums, int start, int end){
      int start0 = start;
      while(start != end && nums[start] == nums[start+1]){
        start++;
      }
      while(end != start && nums[end] == nums[end-1]){
        end--;
      }
      if(start == end) return start0;
      if(start + 1 == end){
        if(nums[start] < nums[end]) return start0;
        return end;
      }

      int mid = start + (end - start)/2;
      if( nums[mid] < nums[start] ) return findSplitIndex(nums, start + 1, mid);
      if( nums[mid] > nums[end] ) return findSplitIndex(nums, mid + 1, end);
      return start0;
    }
    private boolean hasInt(int[] nums, int start, int end, int target){
      int mid = start + (end - start)/2;
      if(start + 1 >= end){
        if(nums[start] == target || nums[end] == target)  return true;
        return false;
      }
      if(nums[mid] < target)  return hasInt(nums, mid + 1, end, target);
      if(nums[mid] > target)  return hasInt(nums, start, mid-1, target);
      return true;
    }
}
