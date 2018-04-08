class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
          return 0;
        }
        int depth_left = minDepth(root.left) + 1;
        int depth_right = minDepth(root.right) + 1;
        if(root.left != null && root.right != null) return depth_left < depth_right ? depth_left : depth_right;
        return depth_left + depth_right - 1;
    }
}
