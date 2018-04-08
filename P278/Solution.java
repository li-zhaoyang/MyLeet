/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      return helper(1, n);
    }

    private int helper(int start, int end) {
        if (start == end)   return start;
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) return helper(start, mid);
        return helper(mid + 1, end);
     }
}
