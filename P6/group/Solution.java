class Solution {
    public String convert(String s, int numRows) {
      int l = s.length();
      if(l == 0) return "";
      if(l == 1 || numRows == 1) return s;
      StringBuffer sb = new StringBuffer("");
      //firstline
      for (int i = 0; i <= (l - 1)/(2 * numRows - 2); i++) {
        sb.append(s.charAt(i * (2 * numRows - 2)));
      }
      // sb.append("\n");
      //2 - n-1 line
      for (int i = 1; i <= numRows - 2; i++) {
        for (int j = 0; j <= (l - 1)/(2 * numRows - 2); j++) {
          if (j * (2 * numRows - 2) + i >= l) break;
          sb.append(s.charAt(j * (2 * numRows - 2) + i));
          if ((j + 1) * (2 * numRows - 2) - i >= l) break;
          sb.append(s.charAt((j + 1) * (2 * numRows - 2) - i));
        }
        // sb.append("\n");
      }
      //last line
      for (int i = 0; i <= (l - 1)/(2 * numRows - 2); i++) {
        if (i * (2 * numRows - 2) + numRows - 1 >= l) break;
        sb.append(s.charAt(i * (2 * numRows - 2) + numRows - 1));
      }
      return sb.toString();
    }
}
