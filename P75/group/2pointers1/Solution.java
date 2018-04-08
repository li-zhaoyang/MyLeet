class Solution {
    public void sortColors(int[] nums) {
      int leftBorder = 0;
      int rightBorder = nums.length - 1;
      for (int i = 0; i <= rightBorder;) {
        if (nums[i] == 0) {
          nums[i++] = nums[leftBorder];
          nums[leftBorder++] = 0;
          i--;
        } else if (nums[i] == 2) {
          nums[i++] = nums[rightBorder];
          nums[rightBorder--] = 2;
          i--;
        }
      }
    }
}
