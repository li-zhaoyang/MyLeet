import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> ans = new LinkedList<List<Integer>>();
      //List<Integer> thisEmptyList = ;
      ans.add(new LinkedList<Integer>());
      for(int i = 0 ; i < nums.length; i++){
        int currentSize = ans.size();
        List<List<Integer>> thisAns = new LinkedList<List<Integer>>();
        for(int j = 0 ; j < currentSize; j ++){
          List<Integer> thisList = new LinkedList<Integer>(ans.get(j));
          thisList.add(nums[i]);
          thisAns.add(thisList);
        }
        ans.addAll(thisAns);
        while(true){
          if(i + 1 == nums.length)  break;
          if(nums[i] != nums[i+1])  break;
          List<List<Integer>> thisAnsI1 = new LinkedList<List<Integer>>();
          for(int j = 0; j < thisAns.size(); j++){
            List<Integer> thisNewList = new LinkedList<Integer>(thisAns.get(j));
            thisNewList.add(nums[i]);
            thisAnsI1.add(thisNewList);
          }
          ans.addAll(thisAnsI1);
          thisAns = thisAnsI1;
          i++;
        }
      }
      return ans;
    }
}
