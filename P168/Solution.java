class Solution {
    public String convertToTitle(int n) {
      StringBuffer sb = new StringBuffer();
      long sum = 0;
      // long nLong = (long) n;

      int i = 1;
      long thisAdd = 1;
      for( ; ; i++){
        thisAdd = 1;
        for(int j = 0 ; j < i ; j++){
          thisAdd *=26;
        }
        sum += thisAdd;
        if(sum >= (long) n)  break;
      }
      int j = i;
      int k = 0;
      for(;; i--){
        thisAdd = 1;
        for(k = 0 ; k < i - 1 ; k++){
          thisAdd *=26;
        }
        n -= thisAdd ;
        if( i == 1 )  break;
      }
      for(i = j; i > 0; i--){
        thisAdd = 1;
        for(k = 0 ; k < i - 1 ; k++){
          thisAdd *=26;
        }
        int divideNum = (int) thisAdd;
        int index = n / divideNum;
        sb.append( (char)( index  + 'A')) ;
        n -= index * divideNum;
      }
      return sb.toString();

    }
}
