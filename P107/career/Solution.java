import java.util.*;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      if (root == null) return ans;
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.offer(root);
      while (!q.isEmpty()) {
        List<Integer> thisRow = new ArrayList<Integer>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
          TreeNode thisNode = q.poll();
          thisRow.add(thisNode.val);
          if (thisNode.left != null) q.offer(thisNode.left);
          if (thisNode.right != null) q.offer(thisNode.right);
        }
        ans.add(thisRow);
      }
      Collections.reverse(ans);
      return ans;
    }
}
