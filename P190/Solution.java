public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      int newNum = 0;
      int bits = 0;
      while(bits<32){
        if( n == 0) break;
        int lastDigit = n & 1;
        newNum = (newNum << 1) + lastDigit;
        n = n >> 1;
        bits ++;
      }
      newNum = newNum << (32 - bits);

      return newNum;

    }
}
