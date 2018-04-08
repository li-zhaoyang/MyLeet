class Solution {
    public void sortColors(int[] nums) {
      if (nums == null || nums.length == 0) return ;
      int l = nums.length;
      int r = -1;
      int g = -1;
      int b = -1;
      for (int i = 0; i < l; i++) {
        if (nums[i] == 0) {
          nums[++b] = 2;
          nums[++g] = 1;
          nums[++r] = 0;
        }
        else if (nums[i] == 1) {
          nums[++b] = 2;
          nums[++g] = 1;
        }
        else if (nums[i] == 2) {
          nums[++b] = 2;
        }
      }
    }
}
