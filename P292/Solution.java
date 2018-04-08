class Solution {
    public boolean canWinNim(int n) {
      if (n == 0)  return false;
      if (n == 1) return true;
      if (n == 2) return true;
      boolean[] canWin = new boolean[n];
      canWin[0] = true;
      canWin[1] = true;
      canWin[2] = true;
      for (int i = 3; i < n; i++) {
        boolean thisWin = false;
        if ( !canWin[0] || !canWin[1] || !canWin[2]) thisWin = true;
        canWin[0] = canWin[1];
        canWin[1] = canWin[2];
        canWin[2] = thisWin;
      }
      return canWin[2];
    }
}
