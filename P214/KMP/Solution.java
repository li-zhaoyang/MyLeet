class Solution {
    public String shortestPalindrome(String s) {
      int l = s.length();
      String revStr = reverseString(s);
      String newStr = s + "." + revStr;
      int[] table = new int[2 * l + 1];
      for (int i = 1; i < 2 * l + 1; i++) {
        int t = table[i - 1];
        while (t > 0 && newStr.charAt(t) != newStr.charAt(i)) {
          t = table[t - 1];
        }
        if (newStr.charAt(i) == newStr.charAt(t)) {
          t++;
        }
        table[i] = t;
      }
      return revStr.substring(0, l - table[2 * l]) + s;
    }

    private String reverseString(String s) {
      StringBuffer sb = new StringBuffer();
      for (int i = s.length() - 1; i >= 0; i--) {
        sb.append(s.charAt(i));
      }
      return sb.toString();
    }
}
