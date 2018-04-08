import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (n > 9 * k || n < k) return ans;
        helper(ans, new LinkedList<Integer>(), 0, n, k);
        return ans;
    }

    private void helper(List<List<Integer>> ans, LinkedList<Integer> thisTempAns, int startNumber, int restSum, int restNum) {
      if (restSum == 0 && restNum == 0)  {
        ans.add(new LinkedList(thisTempAns));
        return ;
      }
      if (restSum < 0 || restNum == 0) return ;
      for (int i = startNumber + 1; i < 10; i++) {
        thisTempAns.add(i);
        helper(ans, thisTempAns, i, restSum - i, restNum - 1);
        thisTempAns.removeLast();
      }
    }
}
