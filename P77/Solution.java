import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
      if(n < k )  return null;
      if(k == 0)  return null;
      if(k == 1){
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        for(int i = 0; i < n ; i++){
          List<Integer> thisList = new LinkedList<Integer>();
          thisList.add(i+1);
          ans.add(thisList);
         }
        return ans;
      }
      if(n == k){
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> thisList = new LinkedList<Integer>();
        for(int i = 0; i < n ; i++) thisList.add(i+1);
        ans.add(thisList);
        return ans;
      }
      List<List<Integer>> lastAns1 = combine(n - 1, k - 1);
      for(int i = 0; i < lastAns1.size(); i++){
        lastAns1.get(i).add(n);
      }
      lastAns1.addAll( combine(n - 1, k) );
      return lastAns1;
    }

}
