import java.util.*;
class Solution {
    public boolean isBalanced(TreeNode root) {
      if(root == null)  return true;
      if(Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) > 1 ) return false;
      return isBalanced(root.left) && isBalanced(root.right);
    }
    private int heightOfTree(TreeNode root){
      if(root == null) return 0;
      int maxLeft = heightOfTree(root.left) + 1;
      int maxRight = heightOfTree(root.right) + 1;
      return maxLeft>maxRight?maxLeft:maxRight;
    }
}
