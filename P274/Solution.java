import java.util.*;
class Solution {
    public int hIndex(int[] citations) {
      if (citations == null || citations.length == 0) return 0;
      Arrays.sort(citations);
      for (int i = 0; i < citations.length; i++) {
        if (citations[citations.length - i - 1] < i + 1) return i;
      }
      return citations.length;
    }
}
