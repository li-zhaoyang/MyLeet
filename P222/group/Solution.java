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
    public int countNodes(TreeNode root) {
      if (root == null) return 0;
      TreeNode left = root.left;
      TreeNode right = root.right;
      int height = 1;
      while (right != null) {
        right = right.right;
        left = left.left;
        height++;
      }
      if (left == null) return 1 << height - 1;
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
