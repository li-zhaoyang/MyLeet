class Solution {
    public int trailingZeroes(int n) {
      int maxPowOf5 = (int) Math.floor(Math.log(n)/Math.log(5));
      int sum = 0;
      int multiplys = 1;
      for(int i = maxPowOf5; i>=1; i--){
        multiplys *= 5;
        sum += n/multiplys;
      }
      return sum;

    }
}
