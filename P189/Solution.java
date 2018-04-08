class Solution {
    public void rotate(int[] nums, int k) {
      if(k == 0)  return ;
      if(nums == null)  return;
      int n = nums.length;
      if(n < 2) return;
      k = k%n;
      k = n - k;
      if(k ==0) return;
      for(int j = 0 ; j < getGCD(n, k); j++){
        int thisNum = nums[j], thisIndex = j;
        for(int i = 0 ; i < n ; i ++){
          int newIndex = (thisIndex + k) % n;
          nums[thisIndex] =nums[newIndex];
          if(newIndex == j)  break;
          thisIndex = newIndex;
        }
        nums[thisIndex] = thisNum;
      }
    }

    private int getGCD(int a, int b) {
      int max = Math.max(a, b);
      int min = Math.min(a, b);
      if(min == 0)  return max;
      return getGCD(min, max % min);
    }
}
