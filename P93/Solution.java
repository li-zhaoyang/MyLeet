import java.util.*;
class Solution {
    public List<String> restoreIpAddresses(String s) {
      List<String> ans = new LinkedList<String>();
      if(s.length() < 4 || s.length() > 12) return ans;
      int seats = s.length() - 1;
      StringBuffer sb = new StringBuffer(s);
      for(int i = 1; i <= seats; i++ ){
        for(int j = i+1; j <= seats; j++){
          for(int k = j + 1; k <= seats; k++){
            StringBuffer s1 = new StringBuffer(sb.substring(0,i));
            StringBuffer s2 = new StringBuffer(sb.substring(i,j));
            StringBuffer s3 = new StringBuffer(sb.substring(j,k));
            StringBuffer s4 = new StringBuffer(sb.substring(k,s.length()));
            if(checkValid(s1) && checkValid(s2) && checkValid(s3) && checkValid(s4))  ans.add(s1.append(".").append(s2).append(".").append(s3).append(".").append(s4).toString());
          }
        }
      }
      return ans;


    }

    private boolean checkValid(StringBuffer sb){
      if(sb.length() > 3 || (sb.charAt(0)=='0' && sb.length() != 1) || Integer.valueOf(sb.toString()) > 255)  return false;
      return true;
    }
}
