import java.util.*;
class Solution {
    public int maxDepth(TreeNode root) {
      if(root == null)  return 0;
      int i = 0;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.add(root);
      while(true){
        if(queue.peek() == null)  break;
        Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
        while(queue.peek() != null){
          TreeNode thisTree = queue.poll();
          if(thisTree.left != null) newQueue.add(thisTree.left);
          if(thisTree.right != null)  newQueue.add(thisTree.right);
        }
        queue = newQueue;
        ++i;
      }
    return i;
    }
}
