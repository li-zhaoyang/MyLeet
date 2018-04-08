class Solution {
    public boolean isValidBST(TreeNode root) {
      return helperValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helperValid(TreeNode root, long leftBound, long rightBound){
      if(root == null)  return true;
      if((root.val >= rightBound) || (root.val <= leftBound) ) return false;
      if(root.left != null){
        if(!helperValid(root.left, leftBound, root.val)) return false;
      }
      if(root.right != null){
        if(!helperValid(root.right, root.val, rightBound))  return false;
      }
      return true;

    }
}
