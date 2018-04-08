import java.util.*;
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
      if(nums.length == 0)  return null;
      return helperBST(nums, 0, nums.length-1);
    }
    private TreeNode helperBST(int[] nums, int start, int end){
      if(start > end) return null;
      int mid = start + (end - start)/2;
      TreeNode thisTree = new TreeNode(nums[mid]);
      thisTree.left = helperBST(nums, start, mid - 1);
      thisTree.right = helperBST(nums, mid + 1 , end);
      return thisTree;
    }
}
