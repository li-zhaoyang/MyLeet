class Solution {
    public void sortColors(int[] nums) {
      int temp = 0;
      for(int i = 0 ; i < nums.length; i++){
        if(nums[i] == 0){
          for(int j = i ; j > 0; j--){
            if(nums[j - 1] == 0)  break;
            temp = nums[j - 1];
            nums[j - 1] = nums[j];
            nums[j] = temp;
          }
        }
        if(nums[i] == 1){
          for(int j = i ; j > 0; j--){
            if(nums[j - 1] == 0 || nums[j-1] == 1)  break;
            temp = nums[j - 1];
            nums[j - 1] = nums[j];
            nums[j] = temp;
          }
        }

      }

    }
}
