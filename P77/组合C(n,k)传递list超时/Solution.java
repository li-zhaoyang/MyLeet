import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> ans = new LinkedList<List<Integer>>();
      List<Integer> rest = new LinkedList<Integer>();
      List<Integer> thisList = new LinkedList<Integer>();
      for(int i = 0; i < n; i++) rest.add(i + 1);
      addCombine(ans, rest, thisList, k);
      return ans;
    }

    private void addCombine(List<List<Integer>> ans, List<Integer> rest, List<Integer> thisList, int k){
      List<Integer> thisListHere = new LinkedList<Integer>(thisList);
      if(thisListHere.size() == k){
        ans.add(thisListHere);
        return;
      }
      List<Integer> restHere = new LinkedList<Integer>(rest);
      for(int i = 0 ; i < rest.size(); i++){
        int thisNum = rest.get(i);
        thisListHere.add(thisNum);
        restHere.remove((Integer) thisNum);
        addCombine(ans, restHere, thisListHere, k);
        //restHere.add(thisNum);
        thisListHere.remove((Integer)thisNum);
      }
    }
}
