class Solution {
    public int maxCoins(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int l = nums.length;
      int[][] max = new int[l + 2][l + 2];
      int[] numsNew = new int[l + 2];
      max[0][0] = 1;
      numsNew[0] = 1;
      numsNew[l + 1] = 1;
      max[l + 1][l + 1] = 1;
      for (int i = 0; i < l; i++) {
        max[i + 1][i + 1] = nums[i];
        numsNew[i + 1] = nums[i];
      }
      for (int length = 1; length <= l; length++) {
        for (int start = 1; start <= l - length + 1; start ++) {
          int end = start + length - 1;
          int thisMax = Integer.MIN_VALUE;
          for (int i = 0; i < length; i++) {
             thisMax = Math.max(thisMax, numsNew[start + i] * numsNew[start - 1] * numsNew[end + 1] + max[start][start + i - 1] +  max[start + i + 1][end]);
          }
          max[start][end] = thisMax;
        }
      }
      return max[1][l];
    }
}
