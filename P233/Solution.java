class Solution {
    public int countDigitOne(int n) {
      int count = 0;
      for (long i = 0; i <= n; i*= 10) {
        long devider = i * 10;
        count += (n / devider * i) + Math.min(Math.max(n % devider - i + 1, 0), i);
      }
      return count;
    }
}
