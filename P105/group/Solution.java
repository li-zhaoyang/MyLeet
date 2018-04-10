import java.util.*;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder == null || inorder == null)  return null;
      int l = preorder.length;
      return helper(preorder, inorder, 0, l - 1, 0, l - 1);


    }
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
      if (preStart > preEnd) {
        return null;
      }
      TreeNode root = new TreeNode(preorder[preStart]);
      int rootIndexInInorder = -1;
      for (rootIndexInInorder = inStart; rootIndexInInorder <= inEnd; rootIndexInInorder++) {
        if (root.val == inorder[rootIndexInInorder]) break;
      }

      root.left = helper(preorder, inorder, preStart + 1, preStart + rootIndexInInorder - inStart, inStart, rootIndexInInorder -1);
      root.right = helper(preorder, inorder, preStart + rootIndexInInorder - inStart + 1, preEnd, rootIndexInInorder + 1, inEnd);
      return root;
    }
}
