class Solution {
    public String reverseString(String s) {
      char[] charArray = s.toCharArray();
      int l = charArray.length;
      for (int i = 0; i < l/2; i++) {
        charArray[i] = (char) (charArray[i] ^ charArray[l - i - 1]);
        charArray[l - i - 1] = (char) (charArray[i] ^ charArray[l - i - 1]);
        charArray[i] = (char) (charArray[i] ^ charArray[l - i - 1]);
      }
      return new String(charArray);
    }
}
