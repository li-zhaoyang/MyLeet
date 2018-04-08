import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      if (nums == null) return ans;
      Arrays.sort(nums);
      List<Integer> thisAnsItem = new ArrayList<Integer>();
      helper(ans, thisAnsItem, 0, nums);
      return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> thisAnsItem, int startIndex, int[] nums) {
      int n = nums.length;
      if (n == startIndex) {
        ans.add(thisAnsItem);
        return ;
      }
      // with this, from next index
      List<Integer> thisAnsItemNew = new ArrayList<Integer>(thisAnsItem);
      thisAnsItemNew.add(nums[startIndex]);
      helper(ans, thisAnsItemNew, startIndex + 1, nums);
      // no this, from next different index
      while(startIndex + 1 != nums.length && nums[startIndex + 1] == nums[startIndex]) {
        startIndex++;
      }
      helper(ans, new ArrayList<Integer>(thisAnsItem), startIndex + 1, nums);
    }
}
