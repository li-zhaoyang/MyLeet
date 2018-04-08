class Solution {
    public int numDecodings(String s) {
      int l = s.length();
      if(l == 0) return 0;
      char c0 = s.charAt(0);
      if(c0 == '0')  return 0;
      if(l == 1) return 1;
      char c1 = s.charAt(1);
      if(l == 2){
        if((c0 == '2' && (c1 - '0') <7) || (c0 == '1'))  return numDecodings(s.substring(1)) +1;
        return numDecodings(s.substring(1));
      }
      if((c0 == '2' && (c1 - '0') <7) || (c0 == '1') ) return numDecodings(s.substring(2)) + numDecodings(s.substring(1));
      return numDecodings(s.substring(1));
    }
}
