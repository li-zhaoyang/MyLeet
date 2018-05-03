/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
      if (root == null) return ;
      flattenLastNode(root);
    }

    public TreeNode flattenLastNode(TreeNode root) {
      TreeNode currentRight = root.right;
      TreeNode lastRight = null;
      if (root.left != null)  {
        lastRight = flattenLastNode(root.left);
        lastRight.right = root.right;
        root.right = root.left;
        root.left = null;
      }
      if (currentRight != null) {
        lastRight = flattenLastNode(currentRight);
      }
      return lastRight == null? root: lastRight;
    }
}
