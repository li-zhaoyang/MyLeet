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
    public int maxPathSum(TreeNode root) {
      if (root == null) return 0;
      int[] max = {Integer.MIN_VALUE};
      List<Integer> maxPath = new ArrayList<Integer>();
      List<Integer> thisPath = new ArrayList<Integer>();
      maxFromThis(root, max,thisPath, maxPath);
      return max[0];
    }
    private int maxFromThis(TreeNode root,int[] max,List<Integer> thisPath, List<Integer> maxPath) {
      if (root == null)  return 0;
      int left = Math.max(maxFromThis(root.left, max, new ArrayList<Integer>(), maxPath), 0);
      int right = Math.max(maxFromThis(root.right, max, new ArrayList<Integer>(), maxPath), 0);
      if (left + right + root.val > max[0]) {
        max[0] = left + right + root.val;
        maxPath = new ArrayList<Integer>();
        if (left != 0) maxPath.addAll(leftPath);
        maxPath.add(root.val);
        if (right != 0) maxPath.add(rightPath.reverse());
      }
      int ans = right;
      if (left > right) {
        ans = left;
        thisPath.addAll(leftPath);
      }
      else thisPath.addAll(rightPath);
      thisPath.add(root.val);
      return ans + root.val;
    }
}
