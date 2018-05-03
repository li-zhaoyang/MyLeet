class Solution {
    public String removeDuplicateLetters(String s) {
      if (s == null || s.length() == 0)  return "";
      int[] count = new int[26];
      for (char c: s.toCharArray()) {
        count[c - 'a']++;
      }
      int i = 0, pos = 0;
      for (; i < s.length(); i++) {
        if (s.charAt(i) < s.charAt(pos)) pos = i;
        if (--count[s.charAt(i) - 'a'] == 0)  break;
      }

      return s.charAt(pos) + removeDuplicateLetters(s.substring(pos).replaceAll("" + s.charAt(pos), ""));

    }
}
