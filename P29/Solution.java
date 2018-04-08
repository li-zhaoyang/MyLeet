class Solution {
    public int divide(int dividend, int divisor) {
      if(dividend == -2147483648 && divisor == -1){
        return 2147483647;
      }
      if( dividend < 0 && divisor < 0 ){
        return divideNeg(dividend, divisor);
      }
      else if(dividend < 0 && divisor > 0){
        return -divideNeg(dividend, -divisor);
      }
      else if(dividend > 0 && divisor < 0){
        return -divideNeg(-dividend, divisor);
      }
      else if(dividend > 0 && divisor > 0 ){
        return divideNeg(-dividend, -divisor);
      }
      return 0;
    }

    public int divideNeg(int dividendN, int divisorN){
      if(dividendN > divisorN)  return 0;
      if(dividendN == divisorN)  return 1;
      int move = 0;
      while( (divisorN<<move) > dividendN  && (divisorN<<move)<0 ){
        move ++;
      }
      dividendN = dividendN - (divisorN<<(move-1));
      return ( 1<<(move-1) ) + divideNeg(dividendN, divisorN);
    }
}
