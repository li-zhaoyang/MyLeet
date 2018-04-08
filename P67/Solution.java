class Solution {
    public String addBinary(String a, String b) {
      int aL = a.length(), bL = b.length();
      if( aL > bL ){
        String temp = b;
        b = a;
        a = temp;
        int tempI = aL;
        aL = bL;
        bL = tempI;

      }
      StringBuffer sb = new StringBuffer(b);
      boolean addOn = false;
      for(int i = 0 ; i < aL; i++){
        if(addOn){
          if(a.charAt(aL - i - 1) == '1' && b.charAt(bL - i - 1) == '1')  sb.setCharAt(bL - i - 1,'1');
          else if(a.charAt(aL - i - 1) == '0' && b.charAt(bL - i - 1) == '0'){
            sb.setCharAt(bL - i - 1, '1');
            addOn = false;
          }else{
            sb.setCharAt(bL - i - 1,'0');
          }
        }else{
          if(a.charAt(aL - i - 1) == '1' && b.charAt(bL - i - 1) == '1'){
            sb.setCharAt(bL - i - 1,'0');
            addOn = true;
          }else if(a.charAt(aL - i - 1) == '0' && b.charAt(bL - i - 1) == '0'){
            sb.setCharAt(bL - i - 1,'0');
          }else{
            sb.setCharAt(bL - i - 1, '1');
          }
        }
      }

      for(int i = bL - aL - 1; i >= 0; i--){
        if(addOn){
          if(b.charAt(i) == '1'){
            sb.setCharAt(i,'0');
          }else{
            sb.setCharAt(i,'1');
            addOn = false;
          }
        }else{
          if(b.charAt(i) == '1'){
            sb.setCharAt(i,'1');
          }else{
            sb.setCharAt(i,'0');
          }
        }
      }
      if(addOn) return sb.insert(0,'1').toString();
      for(int i = 0; i < sb.length(); i++){
        if(sb.charAt(i) != '0') return sb.substring(i);
      }
      String ans = "0";
      return ans;

    }
}
