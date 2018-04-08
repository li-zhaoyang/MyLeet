import java.util.*;
class Solution {
    public void flatten(TreeNode root) {
      if(root == null)  return;
      lastTInFlatten(root);
    }

    private TreeNode lastTInFlatten(TreeNode root){
      if(root.left == null && root.right == null) return root;
      if(root.left == null){
        return lastTInFlatten(root.right);
      }
      if(root.right == null){
        root.right = root.left;
        root.left = null;
        return lastTInFlatten(root.right);
      }
      TreeNode right = root.right;
      root.right = root.left;
      root.left = null;
      lastTInFlatten(root.right).right = right;
      return lastTInFlatten(right);

    }
}
