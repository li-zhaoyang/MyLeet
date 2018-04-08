import java.util.*;
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> ans = new ArrayList();
      if(root == null)  return ans;
      List<Integer> hasIntList = new ArrayList();
      helperSum(ans, hasIntList, root, sum);
      return ans;
    }
    private void helperSum(List<List<Integer>> ans, List<Integer> hasIntList, TreeNode root, int sum){
      if(root == null)  return;
      List<Integer> thisList = new ArrayList(hasIntList);
      thisList.add(root.val);
      sum -= root.val;
      if(sum == 0 ){
        if(root.left == null && root.right == null) ans.add(thisList);
      }
      helperSum(ans, thisList, root.left, sum);
      helperSum(ans, thisList, root.right, sum);
    }
}
