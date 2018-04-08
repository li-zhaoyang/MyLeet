import java.util.*;
class Mid {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> ans = new LinkedList<Integer>();
      if(root == null)  return ans;
      ans.addAll(inorderTraversal(root.left));
      ans.add(root.val);
      ans.addAll(inorderTraversal(root.right));
      return ans;
    }
}
