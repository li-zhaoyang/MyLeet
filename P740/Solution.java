class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] pickUpSequence = new int[10001];
        for (int num: nums) {
          pickUpSequence[num] += num;
        }
        int lastSum = 0;
        int lastLastSum = 0;
        for (int i = 0; i < 10001; i++) {
          int thisSum = Math.max(pickUpSequence[i] + lastLastSum, lastSum);
          lastLastSum = lastSum;
          lastSum = thisSum;
        }
        return Math.max(lastSum, lastLastSum);
    }
}
