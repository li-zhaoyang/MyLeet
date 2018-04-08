class Solution {
    public int romanToInt(String s) {
      int l = s.length();
      int i=0;
      int num=0;

      for(i=0;i<l;){
        if(i<l-1){
          if(s.charAt(i) == 'C' && s.charAt(i+1) == 'M'){
            num+=900;
            i+=2;
            continue;
          }
          if(s.charAt(i) == 'C' && s.charAt(i+1) == 'D'){
            num+=400;
            i+=2;
            continue;
          }
          if(s.charAt(i) == 'X' && s.charAt(i+1) == 'C'){
            num+=90;
            i+=2;
            continue;
          }
          if(s.charAt(i) == 'X' && s.charAt(i+1) == 'L'){
            num+=40;
            i+=2;
            continue;
          }
          if(s.charAt(i) == 'I' && s.charAt(i+1) == 'X'){
            num+=9;
            i+=2;
            continue;
          }
          if(s.charAt(i) == 'I' && s.charAt(i+1) == 'V'){
            num+=4;
            i+=2;
            continue;
          }
        }
        if(s.charAt(i) == 'M') num+=1000;
        if(s.charAt(i) == 'D') num+=500;
        if(s.charAt(i) == 'C') num+=100;
        if(s.charAt(i) == 'L') num+=50;
        if(s.charAt(i) == 'X') num+=10;
        if(s.charAt(i) == 'V') num+=5;
        if(s.charAt(i) == 'I') num+=1;
        i++;
      }
      return num;

    }
}
