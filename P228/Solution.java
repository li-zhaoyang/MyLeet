import java.util.*;
class Solution {
    public List<String> summaryRanges(int[] nums) {
      List<String> ans = new ArrayList<String>();
      if (nums == null || nums.length == 0) return  ans;
      boolean inRange = false;
      int rangeStart  = -1;
      for (int i = 0; i < nums.length; i++) {
        if (inRange == false) {
          rangeStart = i;
          inRange = true;
        }
        if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
          if (i == rangeStart) {
            ans.add(nums[i] + "");
          } else {
            ans.add(nums[rangeStart] + "->" + nums[i]);
          }
          inRange = false;
        }
      }
      return ans;
    }
}
