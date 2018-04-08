import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {
      if (s == null || s.length() == 0) return 0;
      int l = s.length();
      if (k >= l - 1) return l;
      int[] count = new int[26];
      int max = k + 1;
      for (int start = 0, end = -1; start < l - k - 1 && end < l;) {
        int thisLength = end - start + 1;
        int maxCount = Arrays.stream(count).max().getAsInt();
        if (thisLength - maxCount > k){
          char movedOutChar = s.charAt(start++);
          count[movedOutChar - 'A']--;
        } else {
          if (thisLength > max)  max = thisLength;
          if (end == l - 1) {
            break;
          }
          char movedInChar = s.charAt(++end) ;
          count[movedInChar - 'A']++;
        }
      }
      return max;
    }
}
