import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> ans = new LinkedList<List<Integer>>();
      if(root == null)  return ans;
      Stack<TreeNode> s = new Stack<TreeNode>();
      s.push(root);
      int i = 0;
      while(true){
        if(s.empty())  break;
        List<Integer> thisLevel = new LinkedList<Integer>();
        Stack<TreeNode> newStack = new Stack<TreeNode>();
        while(!s.empty()){
          TreeNode thisTree = s.pop();
          thisLevel.add(thisTree.val);
          if(i%2 == 0){
            if(thisTree.left != null) newStack.push(thisTree.left);
            if(thisTree.right != null)  newStack.push(thisTree.right);
          }
          else{
            if(thisTree.right != null)  newStack.push(thisTree.right);
            if(thisTree.left != null) newStack.push(thisTree.left);
          }
        }
        ans.add(thisLevel);
        s = newStack;
        i++;
      }
    return ans;
    }
}
