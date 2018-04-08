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
    public List<Integer> preorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      Set<TreeNode> set = new HashSet<TreeNode>();
      stack.push(root);
      TreeNode thisTree ;
      List<Integer> ans = new ArrayList<Integer>();
      if(root == null)  return ans;
      while(!stack.empty()){
        thisTree = stack.peek();
        if(set.contains(thisTree)){
          stack.pop();
          if(thisTree.right != null){
            stack.push(thisTree.right);
          }
          continue;
        }
        ans.add(thisTree.val);
        set.add(thisTree);
        if(thisTree.left != null){
          stack.push(thisTree.left);
        }
      }

      return ans;
    }
}
