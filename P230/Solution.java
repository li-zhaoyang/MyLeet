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
    public int kthSmallest(TreeNode root, int k) {
      HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
      belowThisNode(root, map);
      return helper(root, k, map);
    }

    private int helper(TreeNode thisNode, int k, HashMap<TreeNode, Integer> map) {
      int leftChildNum = thisNode.left == null ? 0 :map.get(thisNode.left);
      if (leftChildNum + 1 == k)  return thisNode.val;
      if (leftChildNum >= k) return helper(thisNode.left, k, map);
      return helper(thisNode.right, k - leftChildNum - 1, map);
    }


    private int belowThisNode(TreeNode thisNode, HashMap<TreeNode, Integer> map) {
      if (thisNode == null) return 0;
      int thisAns = 1 + belowThisNode(thisNode.left, map) + belowThisNode(thisNode.right, map);
      map.put(thisNode, thisAns);
      return thisAns;
    }
}
