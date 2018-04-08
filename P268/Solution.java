class Solution {
    public int missingNumber(int[] nums) {
      int n = nums.length;
      long sum = 0;
      for (int num: nums) sum += (long) num;
      sum = (n - 1) * n / 2 - sum;
      return (int) sum;
    }
}
