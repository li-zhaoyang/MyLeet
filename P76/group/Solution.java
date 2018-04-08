import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
      int minDis = Integer.MAX_VALUE;
      int[] countMap = new int[128];
      String ans = new String();
      for (char c: t.toCharArray()) {
        countMap[c]++;
      }
      int startIndex = 0, endIndex = 0, needCharNum = t.length();
      while(endIndex < s.length()) {
        if (countMap[s.charAt(endIndex)] > 0) {
          countMap[s.charAt(endIndex)]--;
          endIndex ++;
          needCharNum--;
        }
        if (needCharNum == 0) {     //just get there
          while(true){    //get to the first countMap[startChar] = 0, so we
            //need this char as start
            // if countMap[charAt[i]] < 0, this char is either not in t, or in t
            // but occurred more than we need
            if (countMap[s.charAt(startIndex++)]++ == 0) break;
          }
          needCharNum++;
          //startIndex = real start + 1, so the current number should plus
          //this also implies that in next while endIndex, needCharNum > 0
          //so if (needCharNum == 0) always appear immediately after  --
          if (endIndex - startIndex + 1 < minDis){
            minDis = endIndex - startIndex + 1;
            ans = s.substring(startIndex - 1, endIndex);
          }
        }
      }
      return ans;
    }
}
