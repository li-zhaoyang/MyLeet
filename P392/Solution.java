class Solution {
    public boolean isSubsequence(String s, String t) {
      if (s == null || s.length() == 0) return true;
      if (t == null || t.length() == 0) return false;
      int l1 = s.length();
      int l2 = t.length();
      int index1 = 0;
      for (int i = 0; i < l2; i++) {
        if (t.charAt(i) == s.charAt(index1)) {
          index1++;
          if (index1 == l1) return true;
        }
      }
      return false;
    }
}
