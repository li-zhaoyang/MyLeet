import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
      List<Integer> ans = new ArrayList<Integer>();
      if (nums == null || nums.length == 0) return  ans;
      int x = 0, cx = 0, y = 0, cy = 0;
      for (int num : nums) {
        if (num == x) cx++;
        else if (num == y) cy++;
        else if (cx == 0) {
          x = num;
          cx = 1;
        }
        else if (cy = 0) {
          y = num;
          cy = 1;
        }
        else {
          cx--;
          cy--;
        }
      }
      cx = 0;
      cy = 0;
      for (int num : nums) {
        if (num == x) cx++;
        else if (num == y) cy++;
      }
      if (cx > nums.length / 3) ans.add(x);
      if (cy > nums.length / 3) ans.add(y);
      return ans;
    }
}
