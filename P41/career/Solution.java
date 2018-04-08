import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
      if(nums == null)  return 1;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
          int temp = nums[i];
          nums[i] = nums[nums[i] - 1];
          nums[nums[i] - 1] = nums[i];
          i--;
        }
      }
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) return i + 1;
      }
      return nums.length + 1;
    }
}
