class Solution {
    public int minSubArrayLen(int s, int[] nums) {
      if (nums == null || nums.length == 0)  return 0;
      if (s == 0) return 1;
      int minLength = Integer.MAX_VALUE, l = nums.length;
      int curSum = 0, endIndex = 0, startIndex = 0;
      while(endIndex < l) {
        boolean endIsLength = false;
        while (curSum < s){
          if (endIndex == l) {
            endIsLength = true;
            break;
          }
          curSum += nums[endIndex++];
        }
        if (endIsLength) break;
        while (curSum >= s) {
          curSum -= nums[startIndex++];
        }
        if (endIndex - startIndex + 1 < minLength) {
          minLength = endIndex - startIndex + 1;
        }
      }
      if (minLength == Integer.MAX_VALUE) return 0;
      return minLength;
    }
}
