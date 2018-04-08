import java.util.*;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length == 0 || inorder.length == 0)  return null;
      int i = 0;
        for(int j = 0 ; j < inorder.length; j++){
          if(preorder[i] ==inorder[j]){
            TreeNode thisTree = new TreeNode(preorder[i]);
            thisTree.left = buildTree( Arrays.copyOfRange(preorder, i+1, i+j+1), Arrays.copyOfRange(inorder, 0, j) );
            thisTree.right = buildTree( Arrays.copyOfRange(preorder, i+j+1, preorder.length), Arrays.copyOfRange(inorder, j+1, inorder.length) );
            return thisTree;
          }
        }

      return null;

    }
}
