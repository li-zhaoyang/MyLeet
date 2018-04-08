class Solution {
    public int titleToNumber(String s) {
      int l = s.length();
      int sum = 0, i;
      for( i = 0 ; i < l ; i ++){
        sum += (int) Math.pow(26, i);
      }

      for(i = l - 1 ; i >= 0 ; i-- ){
        sum += (int) Math.pow( 26, i ) * (s.charAt(l - 1 - i) - 'A');
      }

      return sum;

    }
}
