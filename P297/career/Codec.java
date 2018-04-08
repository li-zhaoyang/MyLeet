import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if (root == null) return "#";
      StringBuffer sb = new StringBuffer();
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.offer(root);
      sb.append(root.val);
      while (!q.isEmpty()) {
        for (int i = 0; i < q.size(); i++) {
          TreeNode node = q.poll();
          sb.append(',');
          if (node.left != null) {
            q.offer(node.left);
            sb.append(node.left.val);
          } else {
            sb.append('#');
          }
          sb.append(',');
          if (node.right != null) {
            q.offer(node.right);
            sb.append(node.right.val);
          } else {
            sb.append('#');
          }
        }
      }
      return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data == null || data.length() == 0) return null;
      String[] nodeVals = data.split(",");
      if (nodeVals.length == 0 || nodeVals[0].equals("#"))  return null;
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
      q.offer(root);
      int i = 1;
      while (!q.isEmpty()) {
        for (int j = 0; j < q.size(); j++) {
          TreeNode node = q.poll();
          if (i == nodeVals.length) break;
          String s = nodeVals[i++];
          if (!s.equals("#")) {
            node.left = new TreeNode(Integer.parseInt(s));
            q.offer(node.left);
          }
          if (i == nodeVals.length) break;
          s = nodeVals[i++];
          if (!s.equals("#")) {
            node.right = new TreeNode(Integer.parseInt(s));
            q.offer(node.right);
          }
        }
      }
      return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
