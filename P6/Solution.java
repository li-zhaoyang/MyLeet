class Solution {
    public String convert(String s, int numRows) {
      int l = s.length();
      if(l==0) return "";
      if(l==1 || numRows==1) return s;
      StringBuffer sb = new StringBuffer("");
      for(int j=0;j<(l-1)/(2*numRows-2)+1;j++){
        sb.append(s.charAt((2*numRows-2)*j));
      }
      for(int i=1;i<numRows-1;i++){
        for(int j=0;j<(l-1)/(2*numRows-2)+1;j++){
          if((2*numRows-2)*j+i>=l) break;
          sb.append(s.charAt((2*numRows-2)*j+i));
          if((2*numRows-2)*(j+1)-i>=l) break;
          sb.append(s.charAt((2*numRows-2)*(j+1)-i));
        }
      }
      for(int j=0;j<(l-1)/(2*numRows-2)+1;j++){
        if((2*numRows-2)*j+numRows-1>=l) break;
        sb.append(s.charAt((2*numRows-2)*j+numRows-1));
      }
      String sR = new String(sb);
      return sR;
    }
}
