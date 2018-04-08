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
      stack.push(root);
      TreeNode thisTree ;
      List<Integer> ans = new ArrayList<Integer>();
      if(root == null)  return ans;
      while(!stack.empty()){
        thisTree = stack.peek();
        if(thisTree.left != null ){
          if(!set.contains(thisTree.left)){
            stack.push(thisTree.left);
            continue;
          }
        }
        if(thisTree.right != null){
          if(!set.contains(thisTree.right)){
            stack.push(thisTree.right);
            continue;
          }
        }
        ans.add(thisTree.val);
        set.add(thisTree);
        stack.pop();
      }
      return ans;
    }
}
