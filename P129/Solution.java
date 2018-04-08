import java.util.*;
class Solution {
    public int sumNumbers(TreeNode root) {
      if(root == null)  return 0;
      depths(root);
      return root.val;
    }
    public List<Integer> depths(TreeNode root){ //root is never null
      List<Integer> ans = new ArrayList<Integer>();
      int thisSum = 0;
      if(root.left == null && root.right == null){
        ans.add(1);
        return ans;
      }
      if(root.right != null){
        List<Integer> fromRight = depths(root.right);
        for(int i = 0 ; i < fromRight.size(); i ++){
          thisSum += (root.val *  (int)Math.pow(10, fromRight.get(i)));
          ans.add(fromRight.get(i) + 1);
        }
        thisSum += root.right.val;
      }
      if(root.left != null){
        List<Integer> fromLeft = depths(root.left);
        for(int i = 0 ; i < fromLeft.size(); i ++){
          thisSum += (root.val *  (int)Math.pow(10, fromLeft.get(i)));
          ans.add(fromLeft.get(i) + 1);
        }
        thisSum += root.left.val;
      }
      root.val = thisSum;
      return ans;
    }
}
