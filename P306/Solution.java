class Solution {
    public boolean isAdditiveNumber(String num) {
      if (num == null)  return false;
      return helper(num, 0, -1, -1, 0);
    }
    private boolean helper(String num, int start, long lastLastNum, long lastNum, int numCount) {
      if (start == num.length()) {
        if (numCount < 3) return false;
        return true;
      }
      if (numCount < 2) {
        for (int i = start + 1; i <= num.length(); i++) {
          if (num.charAt(start) == '0' && i > start + 1)  break;
          if (numCount == 0)
            if (helper(num, i, -1, Long.parseLong(num.substring(start, i)), 1))
              return true;
          if (numCount == 1)
            if (helper(num, i, lastNum, Long.parseLong(num.substring(start, i)), 2))
              return true;
        }
      } else {
        long newInt = lastNum + lastLastNum;
        if (num.charAt(start) == '0' && newInt != 0)  return false;
        String newIntStr = Long.toString(newInt);
        int newIntLength = newIntStr.length();
        if (newIntLength > num.length() - start)  return false;
        for (int i = 0; i < newIntStr.length(); i++) {
          if (num.charAt(i + start) != newIntStr.charAt(i)) return false;
        }
        if (helper(num, start + newIntLength, lastNum, newInt, numCount + 1))
          return true;
      }
      return false;
    }
}
