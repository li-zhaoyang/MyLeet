import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

      List<List<Integer>> ans = new LinkedList<List<Integer>>();
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
        ans.add(thisLevel);
        queue = newQueue;
      }
    return ans;
    }
}
