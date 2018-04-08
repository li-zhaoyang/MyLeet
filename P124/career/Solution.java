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
    public int maxPathSum(TreeNode root) {
      if (root == null) return 0;
      int[] max = {Integer.MIN_VALUE};
      maxFromThis(root, max);
      return max[0];
    }
    private int maxFromThis(TreeNode root,int[] max) {
      if (root == null) return 0;
      int left = Math.max(maxFromThis(root.left, max), 0);
      int right = Math.max(maxFromThis(root.right, max), 0);
      max[0] = Math.max(max[0], left + right + root.val);
      return Math.max(left, right) + root.val;
    }
}
