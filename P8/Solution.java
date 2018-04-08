class Solution {
  int INT_MAX = 2147483647;
  int INT_MIN =-2147483648;
    public int myAtoi(String str) {
      Boolean hasSign = false;
      int i=0,l=str.length();
      for(i =0 ;i<l;i++){
        if(str.charAt(i)!=' ') break;
      }
      if(i==l) return 0;
      if(str.charAt(i)=='+' || str.charAt(i)=='-' || (str.charAt(i)-'0'>=0 && str.charAt(i)-'0'<10) ) i=i;
      else return 0;

      if(str.charAt(i)=='+' || str.charAt(i)=='-'){
        if(i+1==l) return 0;
        if(str.charAt(i+1)-'0'<0 && str.charAt(i+1)-'0'>9) return 0;
        hasSign = true;
      }
      Boolean isNeg = false;
      if(hasSign && str.charAt(i)=='-') isNeg = true;
      int j;
      if(hasSign) i=i+1;
      for(j = i ;j<str.length();j++){
        if(str.charAt(j)-'0'<0 || str.charAt(j)-'0'>9) break;
      }
      int num = toInt(de0(str.substring(i,j)),isNeg);
      return num;
    }

    public String de0(String s){
      int l = s.length();
      int i=0;
      for(i=0;i<l;i++){
        if(s.charAt(i) != '0') break;
      }
      return(s.substring(i,l));
    }

    public int toInt(String s,Boolean isNeg){
      int l = s.length();
      if(l>10 && isNeg) return INT_MIN;
      if(l>10 && !isNeg) return INT_MAX;
      if(l==10){
        if(s.charAt(0)-'0'>2 && isNeg) return INT_MIN;
        if(s.charAt(0)-'0'>2 && !isNeg) return INT_MAX;
        if(s.charAt(0)-'0'==2) {
          int num9 = StoInt(s.substring(1,10));
          if(!isNeg){
            if(num9>=147483647) return INT_MAX;
          }
          if(isNeg){
            if(num9>=147483648) return INT_MIN;
          }
        }
      }
      String str = new String(s);
      if(isNeg){
        return -StoInt(str);
      }
      return StoInt(str);
    }

    public int StoInt(String s){
      int l = s.length();
      int num = 0;
      for(int i = l-1; i>=0;i--){
        num+= ((int)s.charAt(i)-'0') * Math.pow(10,l-1-i);
      }
      return num;
    }
}
