class Solution {
    public boolean isIsomorphic(String s, String t) {
      if (s == null || t == null) return false;
      if (s.length() <= 1) return true;
      int[] first1 = new int[128];
      int[] first2 = new int[128];
      for (int i = 0; i < 128; i++) {
        first1[i] = -1;
        first2[i] = -1;
      }
      for (int i = 0; i < s.length(); i++) {
        if (first1[s.charAt(i)] != first2[t.charAt(i)]) return false;
        if (first1[s.charAt(i)] == -1) {
          first1[s.charAt(i)] = i;
          first2[t.charAt(i)] = i;
        }
      }
      return true;
    }
}
