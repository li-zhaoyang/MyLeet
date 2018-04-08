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
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<Integer>();
      if (root == null) return ans;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      Set<TreeNode> visited = new HashSet<TreeNode>();
      stack.push(root);
      while (!stack.isEmpty()) {
        if (stack.peek().left != null && !visited.contains(stack.peek().left)) {
          stack.push(stack.peek().left);
          continue;
        }
        if (stack.peek().right != null && !visited.contains(stack.peek().right)) {
          stack.push(stack.peek().right);
          continue;
        }
        TreeNode thisPop = stack.pop();
        ans.add(thisPop.val);
        visited.add(thisPop);
      }
      return ans;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<Integer>();
      if (root == null) return ans;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode thisPop = stack.pop();
        ans.add(thisPop.val);
        if (thisPop.right != null)  stack.push(thisPop.right);
        if (thisPop.left != null) stack.push(thisPop.left);
      }
      return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<Integer>();
      if (root == null) return ans;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      Set<TreeNode> visited = new HashSet<TreeNode>();
      stack.push(root);
      while (!stack.isEmpty()) {
        if (stack.peek().left != null && !visited.contains(stack.peek().left)) {
          stack.push(stack.peek().left);
          continue;
        }
        TreeNode thisPop = stack.pop();
        ans.add(thisPop.val);
        visited.add(thisPop);
        if (thisPop.right != null) {
          stack.push(thisPop.right);
        }
      }
      return ans;
    }
}
