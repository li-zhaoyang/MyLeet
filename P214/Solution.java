class Solution {
    public String shortestPalindrome(String s) {
      int l = s.length();
      int i = l;
      for (; i > 0; i--) {
        if (isPalindrome(s.substring(0, i)))  break;
      }
      return (new StringBuilder(s.substring(i))).reverse().append(s).toString();
    }
    private boolean isPalindrome(String s) {
      for (int i = 0; i < s.length() / 2; i++) {
        if (s.charAt(i) != s.charAt(s.length() - 1 - i))  return false;
      }
      return true;
    }
}
