class Solution {
    public boolean isMatch(String s, String p) {
      if(s == null) return false;
      if(p == null) return false;
      int l1 = s.length();
      int l2 = p.length();

      if(l2 == 0){
        if(l1 != 0) return false;
        return true;
      }

      if(l1 == 0){
        if(isChar(p.charAt(l2 - 1))) return false;
        for(int i = 1 ; i < l2; i ++){
          if(isChar(p.charAt(i - 1)) && isChar(p.charAt(i)))  return false;
        }
        return true;
      }
      //l1 >0 && l2 >0
      //p[0] is single char
      if(l2 == 1 || (l2 > 1 && p.charAt(1) != '*')){
        if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))  return isMatch(s.substring(1), p.substring(1)); //is substring(l) == null or length == 0?
        return false;
      }

      //p[0] isn't single char,p[0] p[1] is .* or a*
      if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))  return isMatch(s.substring(1), p) || isMatch(s, p.substring(2)) ;
      return isMatch(s, p.substring(2));
    }

    private boolean isChar(char c){
      if( (c - 'a' <= 25 && c - 'a' >= 0) || (c - 'A' <= 25 && c - 'A' >= 0) || c == '.') return true;
      return false;
    }
}
