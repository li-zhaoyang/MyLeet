import java.util.*;
class Solution {
    public boolean isMatch(String s, String p) {
      if(s == null || p == null)  return false;
      int sLength = s.length(), pLength = p.length();
      if(pLength == 0)  {
        if(sLength == 0) return true;
        return false;
      }
      if(sLength == 0){
        for(int i = 0 ; i < pLength ; i ++){
          if( p.charAt(i) != '*') return false;
        }
        return true;
      }
      StringBuffer sb = new StringBuffer();
      sb.append(p.charAt(0));

      for(int i = 1 ; i < pLength ; i ++){
        if(p.charAt(i) == '*' && p.charAt(i) == p.charAt(i - 1)  ){
          continue;
        }
        sb.append(p.charAt(i));
      }

      p = sb.toString();
      pLength = p.length();
      char p0 = p.charAt(0);
      String pRes = p.substring(1), sRes = s.substring(1);
      if(p0 == '?' || p0 == s.charAt(0)){
        return isMatch(sRes, pRes );
      }
      if(p0 == '*'){
        for(int i = sLength ; i >= 0 ; i--){
          if(isMatch(s.substring(i) , pRes))  return true;
        }
        return false;
      }
      return false;
    }
}
