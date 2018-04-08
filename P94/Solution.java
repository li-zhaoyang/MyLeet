import java.util.*;
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      HashSet<TreeNode> traveled = new HashSet<TreeNode>();
      List<Integer> ans = new LinkedList<Integer>();
      if(root == null)  return ans;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      stack.push(root);
      TreeNode thisNode = null;
      while(!stack.empty()){
        thisNode = stack.pop();
        while(true){
          stack.push(thisNode);
          thisNode = thisNode.left;
          if(thisNode == null)  break;
          if(traveled.contains(thisNode))  break;
        }
        thisNode = stack.pop();
        ans.add(thisNode.val);
        traveled.add(thisNode);
        if(thisNode.right != null)  stack.push(thisNode.right);
      }
      return ans;
    }
}
