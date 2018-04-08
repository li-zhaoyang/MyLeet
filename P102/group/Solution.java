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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      if(root == null)  return ans;
      Queue<TreeNode> thisQueue = new LinkedList<TreeNode>();
      thisQueue.add(root);
      Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
      ArrayList<Integer> thisLine = new ArrayList<Integer>();
      while (!thisQueue.isEmpty()) {
        TreeNode thisNode = thisQueue.poll();
        thisLine.add(thisNode.val);
        if(thisNode.left != null) nextQueue.add(thisNode.left);
        if(thisNode.right != null)  nextQueue.add(thisNode.right);
        if(thisQueue.isEmpty()) {
          ans.add(thisLine);
          thisLine = new ArrayList<Integer>();
          thisQueue = nextQueue;
          nextQueue = new LinkedList<TreeNode>();
        }
      }
      return ans;
    }
}
