import java.util.*;
class Solution {
    public String reorganizeString(String S) {
      String s = S;
      if (s == null || s.length() == 0) return "";
      int l = s.length();
      int[] count0 = new int[26];
      int[] count = new int[26];
      for (int i = 0; i < l; i++) {
        count0[s.charAt(i) - 'a'] += 100;
      }
      for (int i = 0; i < 26; i++) count0[i] += i;
      Arrays.sort(count0);
      for (int i = 0; i < 26; i++) count[i] = count0[26 - i - 1];
      int index = 0;
      char[] reorganizedChars = new char[l];
      for (int i = 0; i < 26; i++) {
        int thisCount = count[i] / 100;
        if (thisCount > (l + 1) / 2)  return "";
        for (int j = 0; j < thisCount; j++) {
          if (index >= l)  index = 1;
          reorganizedChars[index] = (char) (count[i] % 100 + 'a');
          index += 2;
        }
      }
      return new String(reorganizedChars);
    }
}
