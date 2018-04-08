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
      HashMap<TreeNode, Integer> sumCount = new HashMap<TreeNode, Integer>();
      sum(root, sumCount);
      return kthSmallestHelper(root, k, sumCount);
    }

    private int sum(TreeNode root, HashMap<TreeNode, Integer> sumCount) {
      if (root == null) return 0;
      if (sumCount.containsKey(root)) return sumCount.get(root);
      int ans = sum(root.left, sumCount) + 1 + sum(root.right, sumCount);
      sumCount.put(root, ans);
      return ans;
    }

    private int kthSmallestHelper(TreeNode root, int k, HashMap<TreeNode, Integer> sumCount) {
      if (root.left == null) {
        if (k == 1) return root.val;
        return kthSmallestHelper(root.right, k - 1, sumCount);
      }
      int leftCount = sumCount.get(root.left);
      if (leftCount == k - 1) return root.val;
      if (leftCount < k - 1)  return kthSmallestHelper(root.right, k - leftCount - 1, sumCount);
      return kthSmallestHelper(root.left, k, sumCount);
    }
}
