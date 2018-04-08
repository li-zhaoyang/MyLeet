class Solution {
    public int removeDuplicates(int[] nums) {
      if(nums.length == 0)  return 0;
      if(nums.length == 1)  return 1;
      if(nums.length == 2)  return 2;
      int newIndex = 1;
      boolean isNew = true;
      for(int i = 1 ; i < nums.length; i++){
        if(nums[i] == nums[i - 1]){
          if(isNew){
            nums[newIndex++] = nums[i];
            isNew = false;
          }else{
            continue;
          }
        }else{
          nums[newIndex++] = nums[i];
          isNew = true;
        }
      }
      return newIndex;
    }
}
