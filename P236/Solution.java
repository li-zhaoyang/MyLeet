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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;
        TreeNode fromLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode fromRight = lowestCommonAncestor(root.right, p, q);
        if (fromLeft == null)   return fromRight;
        if (fromRight == null)  return fromLeft;
        return root;
    }
}
