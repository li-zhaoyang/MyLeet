import java.util.*;
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
    public boolean isSymmetric(TreeNode root) {
      return root == null || helper(root.left, root.right);
    }

    public boolean helper(TreeNode node1, TreeNode node2) {
      if (node1 == null && node2 == null) return true;
      if (node1 == null || node2 == null) return false;
      if(left.val!=right.val) return false;
      return helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
}
