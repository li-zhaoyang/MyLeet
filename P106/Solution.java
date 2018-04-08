import java.util.*;
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      if(inorder == null) return null;
      Map<Integer, Integer> thisMap = new HashMap<Integer, Integer>();
      for(int i = 0 ; i < inorder.length; i ++ ){
        thisMap.put(inorder[i], i);
      }
      return helper(thisMap, inorder, 0 , inorder.length, postorder, 0 , postorder.length);
    }

    private TreeNode helper(Map<Integer,Integer> thisMap, int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
      if(inStart >= inEnd)  return null;
      int val = postorder[postEnd - 1];
      TreeNode thisTree = new TreeNode(val);
      int j = thisMap.get(val);
      thisTree.left = helper(thisMap, inorder, inStart, j, postorder, postStart, postStart + j - inStart );
      thisTree.right = helper(thisMap, inorder, j+1, inEnd, postorder, postStart + j - inStart, postEnd - 1);
      return thisTree;
    }
}
