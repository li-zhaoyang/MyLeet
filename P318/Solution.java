class Solution {
    public int maxProduct(String[] words) {
      if (words == null)  return 0;
      int l = words.length;
      int[] bitMaps = new int[l];
      for (int i = 0; i < l; i++) {
        for (char c: words[i].toCharArray())  bitMaps[i] |= (1 << (c - 'a'));
      }
      int max = 0;
      for (int i = 1; i < l; i++) {
        for (int j = 0; j < i; j++) {
          if ((bitMaps[i] & bitMaps[j]) == 0) max = Math.max(max, words[i].length() * words[j].length());
         }
      }
      return max;
    }
}
