class Solution {
    public int removeDuplicates(int[] nums) {
      if(nums.length==0)  return 0;
      int l = 0;
      for(int i=0;i<nums.length-1;i++){
        if(nums[i]!=nums[i+1]){
          nums[l] = nums[i];
          l++;
        }
      }
      nums[l] =nums[nums.length-1];
      l++;
      //for(int i=0;i<l;i++)  System.out.println(nums[i]);
      return l;

    }
}
