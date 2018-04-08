class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // if (m == n) return m;
        // if (m == 0) return 0;  //n > 0. m > 0
        // int mBitLength = bitLengthOfPosInt(m);
        // if (mBitLength != bitLengthOfPosInt(n)) return 0;
        for (int i = 0; i < 31; i++) {
          if (m >> i == n >> i) return (m >> i) << i;
        }
        return -1;
    }

}
