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
    public List<Integer>  postorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      Set<TreeNode> set = new HashSet<TreeNode>();
      List<Integer> ans = new ArrayList<Integer>();
      if(root == null)  return ans;
      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode thisNode = stack.peek();
        if (!set.contains(thisNode)) {
          set.add(thisNode);
          if (thisNode.right != null) stack.push(thisNode.right);
          if (thisNode.left != null) stack.push(thisNode.left);
        } else {
          ans.add(thisNode.val);
          stack.pop();
        }
      }
      return ans;
    }
}
