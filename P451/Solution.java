import java.util.*;
class Solution {
    public String frequencySort(String s) {
      int l = s.length();
      HashMap<Character, Integer> count = new HashMap<Character, Integer>();
      Character[] charArray = new Character[l];
      char[] ans = s.toCharArray();
      for (int i = 0; i < l; i++) charArray[i] = ans[i];
      for (char c: charArray) count.put(c, count.getOrDefault(c, 0) + 1);
      Arrays.sort(charArray, (a, b) -> count.get(b) == count.get(a)? b - a:count.get(b) - count.get(a));
      for (int i = 0; i < l; i++) ans[i] = charArray[i];
      return new String(ans);
    }
}
