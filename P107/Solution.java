import java.util.*;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> ans = new LinkedList<List<Integer>>();
      Stack<List> s = new Stack<List>();
      if(root == null)  return ans;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(root);
      while(true){
        if(queue.peek() == null)  break;
        List<Integer> thisLevel = new LinkedList<Integer>();
        Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
        while(queue.peek() != null){
          TreeNode thisTree = queue.poll();
          thisLevel.add(thisTree.val);
          if(thisTree.left != null) newQueue.add(thisTree.left);
          if(thisTree.right != null)  newQueue.add(thisTree.right);
        }
        s.push(thisLevel);
        queue = newQueue;
      }
      while(!s.empty()){
        ans.add(s.pop());
      }
    return ans;
    }
}
