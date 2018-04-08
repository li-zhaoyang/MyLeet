import java.util.Arrays;
class Solution {
    public void nextPermutation(int[] nums) {
      if(nums.length == 0 || nums.length == 1) return;
      int temp = 0;
      if(!findAndSwap(nums, 0, nums.length-1)){
        Arrays.sort(nums, 0, nums.length);
      }
    }

    public boolean findAndSwap(int[] nums, int start, int end){
      int temp = 0;
      for(int i = end - 1 ; i>=start; i--){
        if(nums[i]<nums[i+1]){
          int j = indexMinLagerthan(nums, i, i+1, end);
          temp = nums[j];
          nums[j] = nums[i] ;
          nums[i] = temp;
          Arrays.sort(nums, i+1, end+1);
          return true;
        }
      }
      return false;
    }

    public int indexMinLagerthan(int[] nums, int i, int start, int end){
      int min = 2147483647;
      int index = -2;
      for(int j = i+1; j <= end; j++){
        if(nums[j] > nums[i] && nums[j] < min){
          min = nums[j];
          index = j;
        }
      }
      return index;
    }
}
