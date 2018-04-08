class Solution {
    // public int wiggleMaxLength(int[] nums) {
    //   if (nums == null || nums.length == 0) return 0;
    //   int l = nums.length;
    //   System.out.println(l);
    //   int[] dpUp = new int[l];
    //   int[] dpDown = new int[l];
    //   Arrays.fill(dpUp, 1);
    //   Arrays.fill(dpDown, 1);
    //   int max = 1;
    //   for (int i = 1; i < l; i++) {
    //     for (int j = 0; j < i; j ++) {
    //       if (nums[i] > nums[j]) dpUp[i] = Math.max(dpUp[i], dpDown[j] + 1);
    //       if (nums[i] < nums[j]) dpDown[i] = Math.max(dpDown[i], dpUp[j] + 1);
    //       max = Math.max(max, Math.max(dpUp[i], dpDown[i]));
    //     }
    //   }
    //   return max;
    // }
    public int wiggleMaxLength(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int l = nums.length;
      System.out.println(l);
      int[] dpUp = new int[l];
      int[] dpDown = new int[l];
      dpUp[0] = 1;
      dpDown[0] = 1;
      for (int i = 1; i < l; i++) {
        if (nums[i] > nums[i - 1]) {
          dpUp[i] = dpDown[i - 1] + 1;
          dpDown[i] = dpDown[i - 1];
        }
        if (nums[i] < nums[i - 1]) {
          dpUp[i] = dpUp[i - 1];
          dpDown[i] = dpUp[i - 1] + 1;
        }
        if (nums[i] == nums[i - 1]) {
          dpUp[i] = dpUp[i - 1];
          dpDown[i] = dpDown[i - 1];
        }
      }
      return Math.max(dpUp[l - 1], dpDown[l - 1]);
    }
}
