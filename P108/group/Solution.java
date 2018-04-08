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
    public TreeNode sortedArrayToBST(int[] nums) {
      if (nums == null) return null;
      return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int start, int end) {
      if (start == end) return new TreeNode(nums[start]);
      if (start > end)  return null;
      int mid = start + (end - start) / 2;
      TreeNode thisNode = new TreeNode(nums[mid]);
      thisNode.left = helper(nums, start, mid - 1);
      thisNode.right = helper(nums, mid + 1, end);
      return  thisNode;
    }
}
