import java.util.*;
class Solution {
    public boolean isHappy(int n) {
      HashSet<Integer> set = new HashSet<Integer>();
      return isHappyWithSet(set, n);
    }
    private boolean isHappyWithSet(HashSet<Integer> set, int n) {
      if (set.contains(n))  return false;
      if (n == 1) return true;
      set.add(n);
      int newNum = 0;
      while (n != 0) {
        newNum += (n % 10) * (n % 10);
        n /= 10;
      }
      return isHappyWithSet(set, newNum);
    }
}
