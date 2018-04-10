import java.util.*;
class Solution {
    public boolean isBalanced(TreeNode root) {
      if(root == null)  return true;
      return heightOfTree != -1;
    }
    private int heightOfTree(TreeNode root){
      if(root == null) return 0;
      int maxLeft = heightOfTree(root.left) ;
      int maxRight = heightOfTree(root.right);
      if (maxLeft == -1 || maxRight == -1)  return -1;
      if (Math.abs(maxLeft - maxRight) > 1) return -1;
      return Math.max(maxLeft, maxRight) + 1;
    }
}
