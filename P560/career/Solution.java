class Solution {
    public int subarraySum(int[] nums, int k) {
      if (nums == null || nums.length == 0) return 0;
      int l = nums.length;
      int[] sums = new int[l + 1];
      int count = 0;
      for (int i = 1; i <= l; i++)
        sums[i] = nums[i - 1] + sums[i - 1];
      for (int i = 0; i <= l; i++)
        for (int j = 0; j < i; j++)
          if(sums[i] - sums[j] == k)
            count++;
      return count;
    }
}
