import java.util.*;
class Solution {
    public boolean isPossible(int[] nums) {
      if (nums == null || nums.length == 0) return false;
      HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
      HashMap<Integer, Integer> lastNumNeeded = new HashMap<Integer, Integer>();
      for (int num: nums)  count.put(num, count.getOrDefault(num, 0) + 1);
      for (int num: nums) {
        if (count.get(num) == 0)  continue;
        if (lastNumNeeded.getOrDefault(num, 0) > 0) {
            lastNumNeeded.put(num, lastNumNeeded.get(num) - 1);
            lastNumNeeded.put(num + 1, lastNumNeeded.getOrDefault(num + 1, 0) + 1);
        } else if (count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0){
          count.put(num + 1, count.get(num + 1) - 1);
          count.put(num + 2, count.get(num + 2) - 1);
          lastNumNeeded.put(num + 3, lastNumNeeded.getOrDefault(num + 3, 0) + 1);
        } else return false;
        count.put(num, count.get(num) - 1);
      }
      return true;
    }
}
