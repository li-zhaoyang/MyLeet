class Solution {
    public double myPow(double x, int n) {
      if(x == 0){
        if(n == 0)  return 1;
        return 0;
      }
      if(n == 0) return 1.0;
      if(n < 0 ){
        if(n == Integer.MIN_VALUE){
          if(x == -1.0) return 1;
          n = -(n + 1);
        }
        else  n = -n;
        x = 1/x;
      }
      return (n%2 == 0)? myPow(x * x, n/2) : myPow(x * x, n/2)*x ;

    }
}
