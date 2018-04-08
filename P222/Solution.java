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
    public int countNodes(TreeNode root) {
      TreeNode rightTravel = root;
      int leftCount = leftDepth(root), rightCount = 0;
      while (rightTravel != null) {
        rightCount++;
        rightTravel = rightTravel.right;
      }
      if (leftCount == rightCount) return (1 << leftCount) - 1;
      int lastRowCount = 0;
      int thisDepth = 1;
      TreeNode travel = root;
      while (true) {
        int leftDepthCount = leftDepth(travel.left);
        int rightDepthCount = leftDepth(travel.right);
        if (leftDepthCount > rightDepthCount) travel = travel.left;
        if (leftDepthCount == rightDepthCount) {
          if (leftDepthCount == 0) return (1 << rightCount) - 1 + lastRowCount + 1;
          lastRowCount += (1 << (leftCount - thisDepth - 1));
          travel = travel.right;
        }
        thisDepth++;
      }
    }

    private int leftDepth(TreeNode root) {
      int count = 0;
      while(root != null) {
        count++;
        root = root.left;
      }
      return count;
    }
}
