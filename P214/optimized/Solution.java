class Solution {
    public String shortestPalindrome(String s) {
      int l = s.length();
      int j = 0;
      for (int i = l - 1; i >= 0; i-- ) {
        if (s.charAt(j) == s.charAt(i)) j++;
      }
      if (j == l) return s;
      return reverseString(s.substring(j)) + shortestPalindrome(s.substring(0, j)) + s.substring(j);
    }

    private String reverseString(String s) {
      StringBuffer sb = new StringBuffer();
      for (int i = s.length() - 1; i >= 0; i--) {
        sb.append(s.charAt(i));
      }
      return sb.toString();
    }
}
