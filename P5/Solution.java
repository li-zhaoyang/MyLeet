class Solution {
    public String longestPalindrome(String s) {
      int l = s.length();
      int start = 0;
      if(l==1) return s;
      if(l==2){
        if(s.charAt(0)==s.charAt(1)) return s;
        else return s.substring(0,1);
      }
      int maxLen=1;

      for(int i =0;i<l-maxLen/2;i++) {//边界检查
        for(int j=1;j<=i&&j<l-i;j++){
          if(s.charAt(i-j)==s.charAt(i+j)){
            if(j*2+1>maxLen){
              maxLen = j*2+1;
              start = i-j;
            }
          }
          else break;
        }
        if(i+1>=l) continue;
        if(s.charAt(i)==s.charAt(i+1)){
          if(maxLen<2){
            maxLen = 2;
            start = i;
          }
          for(int j=1;j<=i&&j<l-i-1;j++){
            if(s.charAt(i-j)==s.charAt(i+j+1)){
              if(j*2+2>maxLen){
                maxLen = j*2+2;
                start = i-j;
              }
            }
            else break;
          }
        }




      }

      return s.substring(start,start+maxLen);


    }

}
