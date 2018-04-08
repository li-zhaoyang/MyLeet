
import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
      Set<Integer> ansSet = new HashSet<Integer>();
      for (int i = 0; i < nums.length; i++) {
        if (nums[Math.abs(nums[i]) - 1] < 0)  ansSet.add(Math.abs(nums[i]));
        nums[Math.abs(nums[i]) - 1] = - Math.abs(nums[Math.abs(nums[i]) - 1]);
      }
      return new ArrayList<Integer>(ansSet);
    }
}


// import java.util.*;
// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//
//     }
// }
