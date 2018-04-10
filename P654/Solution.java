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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int start, int end) {
      if (start > end)  return null;
      int index = -1, max = Integer.MIN_VALUE;
      for (int i = start; i <= end; i++) {
        if (nums[i] > max) {
          max = nums[i];
          index = i;
        }
      }
      TreeNode thisNode = new TreeNode(max);
      thisNode.left = helper(nums, start, index - 1);
      thisNode.right = helper(nums, index + 1, end);
      return thisNode;
    }
}
