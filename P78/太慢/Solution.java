import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      
      return helpSubset(nums, 0);
    }
    private List<List<Integer>> helpSubset(int[] nums,int start){
      List<List<Integer>> ans = new LinkedList<List<Integer>>();
      if(start == nums.length){
        List<Integer> thisList = new LinkedList<Integer>();
        ans.add(thisList);
        return ans;
      }
      List<List<Integer>> nextAns = helpSubset(nums, start + 1);
      for(int j = 0; j < nextAns.size(); j++){
        //ans.add(nextAns.get(j));
        LinkedList<Integer> nextToAdd = new LinkedList<Integer>(nextAns.get(j));
        nextToAdd.add(nums[start]);
        ans.add(nextToAdd);
      }
      ans.addAll(nextAns);
      return ans;
    }
}
