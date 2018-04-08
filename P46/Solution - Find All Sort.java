import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      List<List<Integer>> ans = new LinkedList();
      if(nums.length == 0) return ans;
      Arrays.sort(nums);
      findCB(ans,nums, 0);

      return ans;
    }

    public void findCB(List<List<Integer>> ans, int[] nums, int start){
      if(start == nums.length){
        List<Integer> thisIntList = new LinkedList();
        for(int i = 0 ; i < nums.length; i++){
          thisIntList.add(nums[i]);
        }
        ans.add(thisIntList);
        return;
      }



      for(int i = start ; i < nums.length ; i++){
          used.add(nums[i]);
          swapEInArr(nums, start, i);
          findCB(ans, nums, start+1);
          swapEInArr(nums, start, i);
      }

    }

    private void swapEInArr(int[] nums, int i, int j){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }

    private boolean foundInList(List<Integer> used, int num){
      for(int i = 0 ; i < used.size() ; i++){
        if(used.get(i) == num)  return true;
      }
      return false;
    }

}
