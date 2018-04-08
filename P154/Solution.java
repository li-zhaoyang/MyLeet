class Solution {
    public int findMin(int[] nums) {
      int l = nums.length;
      if(l == 1)  return nums[0];
      if(nums[l - 1] > nums[0]) return nums[0];
      return findDevided(nums, 0, l-1);
    }

    private int findDevided(int[] nums, int start, int end){
      while(nums[start] == nums[start + 1] ){
        start++;
        if(start == end)  return nums[start];
      }
      while(nums[end] == nums[end - 1]){
        end -- ;
        if(end == 0)  return nums[end];
      }
      if(start + 1 >= end)  return nums[end];
      int mid = start + (end - start)/2;
      if(nums[mid] > nums[start]){
        if(nums[mid + 1] < nums[mid]) return nums[mid + 1];
        return findDevided(nums, mid + 1, end);
      }
      else{
        if(nums[mid - 1] > nums[mid]) return nums[mid];
        return findDevided(nums, start, mid - 1);
      }
    }
}
