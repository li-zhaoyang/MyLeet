import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      List<Integer> thisAnsItem = new ArrayList<Integer>();
      helper(ans, thisAnsItem, nums, 0);
      return ans;
    }
    public void helper(List<List<Integer>> ans, List<Integer> thisAnsItem, int[] nums, int startIndex) {
      if(nums == null) return;
      int n = nums.length;
      if (n == startIndex) {
        ans.add(thisAnsItem);
        return;
      }
      for (int i = startIndex; i < n; i++) {
        int temp = nums[i];
        nums[i] = nums[startIndex];
        nums[startIndex] = temp;
        List<Integer> thisAnsItemNew = new ArrayList<Integer>(thisAnsItem);
        thisAnsItemNew.add(nums[startIndex]);
        helper(ans, thisAnsItemNew, nums, startIndex + 1);
        temp = nums[i];
        nums[i] = nums[startIndex];
        nums[startIndex] = temp;
      }
    }
}
