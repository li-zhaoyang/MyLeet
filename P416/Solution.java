class Solution {
    public boolean canPartition(int[] nums) {
      if (nums == null || nums.length == 0) return false;
      int n = nums.length;
      Set<Integer> set = new HashSet<Integer>();
      int sum = 0;
      set.add(0);
      for (int i = 0; i < nums.length; i++) {
        for (int prevSum: set) {
          set.add(prevSum + nums[i]);
        }
        sum += nums[i];
      }
      System.out.println(set);
      if (sum % 2 == 1) return false;
      return set.contains(sum / 2);
    }
}
