import java.util.*;
class Solution {
    public boolean isMatch(String s, String p) {
      if(s == null || p == null)  return false;
      int sPointer = 0, pPointer = 0, matchedAfterLastStar = 0, lastStar = -1;
      while(sPointer < s.length()){
        if(pPointer < p.length() && (p.charAt(pPointer) == '?' || p.charAt(pPointer) == s.charAt(sPointer))){
          pPointer++;
          sPointer++;
        }
        else if(pPointer < p.length() && p.charAt(pPointer) == '*'){
          lastStar = pPointer;
          matchedAfterLastStar = sPointer;
          pPointer++;
        }
        else if(lastStar != -1){
          pPointer = lastStar + 1;
          matchedAfterLastStar++;
          sPointer = matchedAfterLastStar;
        }
        else  return false;

      }

      while(pPointer < p.length()){
        if (p.charAt(pPointer) != '*') return false;
        pPointer++;
      }

      return true;
    }
}
