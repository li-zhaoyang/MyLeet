import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> ans = new ArrayList();
      return findCB(candidates, 0, target);
    }

    public List<List<Integer>> findCB(int[] candidates, int start, int target){
      List<List<Integer>> rt = new ArrayList();
      if( target % candidates[start] == 0 ){       //there is answer ends now
        List<Integer> thisIL = new ArrayList();
        for(int i =0; i < target/candidates[start] ; i++){
          thisIL.add(candidates[start]);
        }
        rt.add(thisIL);
      }
      if(start + 1 == candidates.length){       //at the last one
        return rt;
      }
      int newTarget = 0;
      List<Integer> thisIntList = new ArrayList();
      for(int i = 0; i<= target/candidates[start]; i++){
        if(i == target/candidates[start] && target%candidates[start] == 0) break;
        newTarget = target - candidates[start] * i;
        if(i!=0)  thisIntList.add(candidates[start]);
        List<List<Integer>> ansOfNext = findCB(candidates, start + 1 , newTarget);
        if(ansOfNext.size() == 0) continue;
        for(int j = 0 ; j < ansOfNext.size() ; j++){
          List<Integer> thisIntListToAdd = new ArrayList(thisIntList);
          thisIntListToAdd.addAll(ansOfNext.get(j));
          rt.add(thisIntListToAdd);
        }
      }
      return rt;
    }
}
