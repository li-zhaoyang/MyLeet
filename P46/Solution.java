import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
      Arrays.sort(nums);

      return permuteSorted(nums,0);
    }

    public List<List<Integer>> permuteSorted(int[] nums, int start){
      List<List<Integer>> rt = new LinkedList();
      if(start + 1 == nums.length){
        List<Integer> thisIL = new LinkedList<Integer>();
        thisIL.add(nums[start]);
        rt.add(thisIL);
        return rt;
      }
//      if(numsList.size() == 0)  return rt;


      for(int i = start; i< nums.length ; i++){
        int[] thisNums = nums.clone();
        for(int j = i;j>start ; j--){
          thisNums[j] = thisNums[j-1];
        }
        List<List<Integer>> nextAnsList = permuteSorted(thisNums, start + 1);
        for(int j = 0 ; j < nextAnsList.size(); j++){
          List<Integer> thisIL = new LinkedList<Integer>();
          thisIL.add(nums[i]);
          thisIL.addAll(nextAnsList.get(j));
          rt.add(thisIL);
        }
      }
      return rt;

    }

    public ListListInteger permute(int[] nums) {
   ListListInteger list = new ArrayList();
    Arrays.sort(nums);  not necessary
   backtrack(list, new ArrayList(), nums);
   return list;
}

private void backtrack(ListListInteger list, ListInteger tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList(tempList));
   } else{
      for(int i = 0; i  nums.length; i++){
         if(tempList.contains(nums[i])) continue;  element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
}
}
