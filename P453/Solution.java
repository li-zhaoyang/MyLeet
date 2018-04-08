class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num: nums) {
          sum += num;
          min = Math.min(min, num);
        }
        return sum - min * nums.length;
    }
}
