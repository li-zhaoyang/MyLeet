class Solution {
    public int reverse(int x) {
      if(x==0) return 0;
      if(x<0){
        x= 0-x ;
//        char b = 'b';
//        int l = (int)b-'a';
//        System.out.println(l+"");
        StringBuffer reversedS = new StringBuffer(Integer.toString(x)).reverse();
//        System.out.println(reversedS);
        return -toInt(reversedS);
      }
      if(x>0){
        StringBuffer reversedS = new StringBuffer(Integer.toString(x)).reverse();
        return toInt(reversedS);
      }
      return 0;
    }
    public int toInt(StringBuffer s){
      int l = s.length();
      if(l>10) return 0;
      if(l==10){
        if(s.charAt(0)-'0'>2) return 0;
        if(s.charAt(0)-'0'==2) {
          int num9 = StoInt(s.substring(1,10));
          if(num9>147483647) return 0;
        }
      }
      String str = new String(s);
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
