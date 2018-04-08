import java.util.*;
class Solution {
    public int[] productExceptSelf(int[] nums) {
      if (nums == null) return null;
      int l = nums.length;
      if (l == 0) return nums;
      int[] outputArray = new int[l];
      int constForLeft = nums[0], constForRight = nums[l - 1];
      outputArray[0] = 1;
      outputArray[l - 1] = 1;
      outputArray[l / 2] = 1;
      for (int i = 1; i < l; i++){
        if (i >= l / 2) {
          if (i == l / 2) outputArray[i] = 1;
          outputArray[i] = constForLeft * outputArray[i];
          outputArray[l - i - 1] = constForRight * outputArray[l - i - 1];
          constForLeft *= nums[i];
          constForRight *= nums[l - 1 - i];
        } else {
          outputArray[i] = outputArray[i - 1] * nums[i - 1];
          outputArray[l - 1 - i] = outputArray[l - i] * nums[l - i];
          constForLeft *= nums[i];
          constForRight *= nums[l - 1 - i];
        }
      }
      return outputArray;
    }
}
