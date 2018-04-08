class Solution {
    public boolean isPalindrome(int x) {
      if(x==0) return true;
      if(x< 0){
        return false;
        //x=-x;
      }

      double ld = Math.log10(x);
      int l = (int)Math.floor(ld) +1 ;
      //System.out.println(l+"");
      if(l%2==0){
        for(int i=0;i<l/2;i++){
          if( (x/((int)Math.pow(10,l/2-i-1)))%10 != (x/((int)Math.pow(10,l/2+i)))%10 ) return false;
        }
      }
      else if(l%2 == 1){
        for(int i=0;i<l/2;i++){
          //System.out.println((x/((int)Math.pow(10,l/2-i-1)))%10+"");
          //System.out.println((x/((int)Math.pow(10,l/2+i+1)))%10+"");
          if( (x/((int)Math.pow(10,l/2-i-1)))%10 != (x/((int)Math.pow(10,l/2+i+1)))%10 ) return false;
        }
      }
      return true;

    }
}
