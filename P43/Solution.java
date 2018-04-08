class Solution {
    public String multiply(String num1, String num2) {
      if(num1 == "0" || num2 == "0")  return "0";
      int l1 = num1.length(), l2 = num2.length();
      StringBuffer sb1 = new StringBuffer(num1), sb2 = new StringBuffer(num2);
      StringBuffer sbr1 = sb1.reverse(), sbr2 = sb2.reverse(), ans = new StringBuffer();
      int[] twoDigit = new int[ l1 + l2 ];
      for(int i = 0 ; i<sbr1.length(); i++){
        for(int j = 0 ; j < sbr2.length();j++){
          twoDigit[i+j] += ( sbr1.charAt(i) - '0' ) * ( sbr2.charAt(j) - '0' );
        }
      }
      int carry = 0, i = 0;
      for(i = 0 ; i < twoDigit.length; i++){
        ans.append( (char)((twoDigit[i] + carry) % 10 +'0') );
        carry = (twoDigit[i] + carry) / 10;
      }

      i = 0;
      ans = ans.reverse();
      while(true){
        if(i == ans.length()) return "0";
        if(ans.charAt(i) != '0')  break;
        i++;
      }
      return ans.substring(i);
    }
}
