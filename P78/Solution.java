import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new LinkedList<List<Integer>>();
      //List<Integer> thisEmptyList = ;
      ans.add(new LinkedList<Integer>());
      for(int i = 0 ; i < nums.length; i++){
        int currentSize = ans.size();
        for(int j = 0 ; j < currentSize; j ++){
          List<Integer> thisList = new LinkedList<Integer>(ans.get(j));
          thisList.add(nums[i]);
          ans.add(thisList);
        }
      }
      return ans;
    }
}
