import java.util.*;
class Solution {
    public String frequencySort(String s) {
      int l = s.length();
      HashMap<Character, Integer> count = new HashMap<Character, Integer>();
      String[] buckets = new String[l + 1];
      for (char c: s.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1);
      for (char c: count.keySet()) {
        buckets[count.get(c)] = buckets[count.get(c)] == null? "" + c: buckets[count.get(c)] + c;
      }
      StringBuffer sb = new StringBuffer();
      for (int i = l; i > 0; i--) {
        if (buckets[i] == null) continue;
        for (char c: buckets[i].toCharArray()) {
          for (int j = 0; j < i; j++) {
            sb.append(c);
          }
        }
      }
      return sb.toString();
    }
}
