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
    public List<String> binaryTreePaths(TreeNode root) {
      List<String> ans = new ArrayList<String>();
      if (root == null) return ans;
      helper(ans, new StringBuffer(), root);
      return ans;
    }
    private void helper(List<String> ans, StringBuffer untilNow, TreeNode thisNode) {
      untilNow.append("->" + thisNode.val);
      if (thisNode.left == null && thisNode.right == null) {
        ans.add(untilNow.toString().substring(2));
      }
      if (thisNode.left != null) helper(ans, new StringBuffer(untilNow), thisNode.left);
      if (thisNode.right != null) helper(ans, new StringBuffer(untilNow), thisNode.right);
    }
}
