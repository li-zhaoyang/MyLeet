class Solution {
    public int rob(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      if (l.length == 1)  return nums[0];
      int l = nums.length;
      int countLastLast1 = 0, countLast1 = 0, countLastLast2 = 0, countLast2 = 0;
      for (int i = 0; i < l - 1; i ++) {
        int thisMax1 = countLast1;
        if (nums[i] + countLastLast1 > countLast1) {
          thisMax1 = nums[i] + countLastLast1;
        }
        countLastLast1 = countLast1;
        countLast1 = thisMax1;
      }
      for (int i = 1; i < l; i++) {
        int thisMax2 = countLast2;
        if (nums[i] + countLastLast2 > countLast2) {
          thisMax2 = nums[i] + countLastLast2;
        }
        countLastLast2 = countLast2;
        countLast2 = thisMax2;
      }
      return Math.max(countLast1, countLast2);
    }
}
