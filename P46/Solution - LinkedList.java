import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
      Arrays.sort(nums);
      List<Integer> numsList = new LinkedList<Integer>();
      for(int i = 0; i < nums.length; i++){
        numsList.add(nums[i]);
      }
      return permuteSorted(numsList);
    }

    public List<List<Integer>> permuteSorted(List<Integer> numsList){
      List<List<Integer>> rt = new LinkedList();
//      if(numsList.size() == 0)  return rt;
      for(int i = 0; i< numsList.size() ; i++){
        List<Integer> newNumsList = new LinkedList<Integer>(numsList);
        newNumsList.remove(i);
        if(newNumsList.size() == 0){
          List<Integer> thisIL = new LinkedList<Integer>();
          thisIL.add(numsList.get(i));
          rt.add(thisIL);
          return rt;
        }
        List<List<Integer>> nextAnsList = permuteSorted(newNumsList);
        for(int j = 0 ; j < nextAnsList.size(); j++){
          List<Integer> thisIL = new LinkedList<Integer>();
          thisIL.add(numsList.get(i));
          thisIL.addAll(nextAnsList.get(j));
          rt.add(thisIL);
        }


      }
      return rt;

    }
}
