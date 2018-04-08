import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
      int ansSize = factorial(n)/(factorial(k) * factorial(n - k));
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
        // System.out.println(k);
        // for(int j = 0 ; j < thisListHere.size(); j ++){
        //   System.out.print(thisListHere.get(j)+" ");
        // }
        // System.out.println("");
        ans.add(thisListHere);
        return;
      }
      List<Integer> restHere = new LinkedList<Integer>(rest);
      for(int i = 0 ; i < rest.size(); i++){
        int thisNum = rest.get(i);
        thisListHere.add(thisNum);
        restHere.remove((Integer) thisNum);
        // System.out.println(i + ": "+ thisNum);
        // for(int j = 0 ; j < restHere.size(); j++) System.out.print(restHere.get(j) + " ");
        // System.out.println("");
        // for(int j = 0 ; j < thisListHere.size(); j++) System.out.print(thisListHere.get(j) + " ");
        // System.out.println("");
        addCombine(ans, restHere, thisListHere, k);
        restHere.add(thisNum);
        thisListHere.remove((Integer)thisNum);
      }
    }


    private int factorial(int n){
      int ans = 1;
      for(int i = 1; i <= n;i ++){
        ans = ans * i;
      }
      return ans;
    }
}
