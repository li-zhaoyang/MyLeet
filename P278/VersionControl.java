/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class VersionControl {
  public boolean isBadVersion(int n) {
    if (n >= 5) return true;
    return false;
  }
}
