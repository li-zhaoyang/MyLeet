import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
      List<Integer> list = new ArrayList(nums.length);
      for(int num:nums){
        list.add(num);
      }

      Set<Integer> set = new HashSet<Integer>(list);

      int sumL = list.stream().mapToInt(Integer::intValue).sum();
      int sumS = set.stream().mapToInt(Integer::intValue).sum();
      return 2*sumS - sumL;
    }
}
