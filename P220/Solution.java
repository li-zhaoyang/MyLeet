import java.util.*;
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      if (t < 0 || k <= 0) return false;
      HashMap<Integer, Long> map = new HashMap<Integer, Long>();
      for (int i = 0; i < nums.length; i++) {
        int key = 0;
        if (nums[i] >= 0) key = nums[i] /(t + 1);
        else key = nums[i] /(t + 1) - 1;
        long tLong = (long) t;
        if (map.containsKey(key)) return true;
        if (map.containsKey(key - 1) && ((long) nums[i] - map.get(key - 1) <= tLong)) return true;
        if (map.containsKey(key + 1) && (map.get(key + 1) - (long) nums[i] <= tLong))  return true;
        map.put(key, (long) nums[i]);
        if (i - k >= 0) map.remove(nums[i - k] / (t + 1));
      }
      return false;
    }
}
