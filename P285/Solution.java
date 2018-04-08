import java.util.*;
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      if (root == null || p == null)  return null;
      TreeNode pRight = p.right;
      if (pRight != null) {
        return findLeftMost(pRight);
      }
      int pValue = p.val;
      TreeNode findPRoot = root;
      while (findPRoot != null) {
        if (findPRoot.val < p.val) {
          findPRoot = findPRoot.right;
        } else if (findPRoot.val > p.val) {
          pRight = findPRoot;
          findPRoot = findPRoot.left;
        } else {
          break;
        }
      }
      return pRight;
    }
    private TreeNode findLeftMost(TreeNode pRight) {
      while (pRight.left != null) {
        pRight = pRight.left;
      }
      return pRight;
    }
    public TreeNode helperBST(int[] nums, int start, int end, HashMap<Integer, TreeNode> nodeMap){
      if(start > end) return null;
      int mid = start + (end - start)/2;
      TreeNode thisTree = new TreeNode(nums[mid]);
      nodeMap.put(nums[mid], thisTree);
      thisTree.left = helperBST(nums, start, mid - 1, nodeMap);
      thisTree.right = helperBST(nums, mid + 1 , end, nodeMap);
      return thisTree;
  }
}
