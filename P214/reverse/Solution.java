class Solution {
    public String shortestPalindrome(String s) {
      int l = s.length();
      String rev = reverseString(s);
      for (int i = 0; i < l; i++) {
        if (s.substring(0, l - i).equals(rev.substring(i)))
          return rev.substring(0, i) + s;
      }
      return "";
    }

    private String reverseString(String s) {
      StringBuffer sb = new StringBuffer();
      for (int i = s.length() - 1; i >= 0; i--) {
        sb.append(s.charAt(i));
      }
      return sb.toString();
    }
}
