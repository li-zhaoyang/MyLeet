class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if(q == null){
        if(p == null )  return true;
        return false;
      }
      if(p == null) return false;
      if(p.val != q.val)  return false;
      if(p.left != null && q.left != null){
        if(!isSameTree(p.left, q.left)) return false;
      }
      if(p.right != null && q.right != null){
        if(!isSameTree(p.right, q.right)) return false;
      }
      if((p.left == null && q.left != null) || (p.left != null && q.left == null) || (p.right == null && q.right != null) || (p.right != null && q.right == null))  return false;
      return true;
    }
}
