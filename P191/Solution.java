public class Solution {
    // you need treat n as an unsigned value
    public int hammingWeight(int n) {
      int newNum = 0;
      int bits = 0;
      while(bits<32){
        if( n == 0) break;
        int lastDigit = n & 1;
        if(lastDigit == 1) newNum++;
        n = n >> 1;
        bits ++;
      }
      return newNum;

    }
}
