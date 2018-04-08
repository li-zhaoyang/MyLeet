import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> ans = new LinkedList();
      if(candidates.length == 0) return ans;
      Arrays.sort(candidates);

      ans = findCB(candidates, 0, target);
      return ans;
    }

    public List<List<Integer>> findCB(int[] candidates, int start, int target){
      List<List<Integer>> rt = new LinkedList();
      if( target == candidates[start] ){       //there is answer ends now
        List<Integer> thisIL = new LinkedList();
        thisIL.add(candidates[start]);
        rt.add(thisIL);
        return rt;
      }
      if(target < candidates[start] || start+1 == candidates.length) return rt;
      int next = start + 1;
      for(;;next++){
        if(next == candidates.length)  break;
        if(candidates[next] != candidates[start]) break;
      }
      if(next != candidates.length) rt.addAll(findCB( candidates, next, target ));
      int newTarget = target - candidates[start];
      List<Integer> thisIntList = new LinkedList();
      thisIntList.add(candidates[start]);
      List<List<Integer>> ansOfNext = findCB(candidates, start+1 , newTarget);
      if(ansOfNext.size() != 0){
        for(int j = 0 ; j < ansOfNext.size() ; j++){
          List<Integer> thisIntListToAdd = new LinkedList(thisIntList);
          thisIntListToAdd.addAll(ansOfNext.get(j));
          rt.add(thisIntListToAdd);
        }
      }
      return rt;
    }



}
