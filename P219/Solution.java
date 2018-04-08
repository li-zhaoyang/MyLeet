import java.util.*;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      if (k >= nums.length) return false;
      HashMap<Integer, Integer> numPos = new HashMap<Integer, Integer>();
      for (int i = 0; i < nums.length; i++) {
        if (numPos.contains(nums[i])) {
          if (i - numPos.get(nums[i]) <= k) return true;
        }
        numPos.put(nums[i], i);
      }
      return false;
    }
}
