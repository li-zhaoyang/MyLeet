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
      if (root == null) return "";
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      StringBuffer sb = new StringBuffer();
      sb.append(root.val);
      q.offer(root);
      while (!q.isEmpty()) {
        for (int i = 0; i < q.size(); i++) {
          TreeNode thisNode = q.poll();
          if (thisNode.left != null) {
            sb.append(",").append(thisNode.left.val);
            q.offer(thisNode.left);
          } else {
            sb.append(",").append("a");
          }
          if (thisNode.right != null) {
            sb.append(",").append(thisNode.right.val);
            q.offer(thisNode.right);
          } else {
            sb.append(",").append("a");
          }
        }
      }
      return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data.equals("")) return null;
      String[] nodesInData = data.split(",");
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      TreeNode root = new TreeNode(Integer.parseInt(nodesInData[0]));
      q.offer(root);
      int index = 1;
      while (!q.isEmpty()) {
        for (int i = 0; i < q.size(); i++) {
          TreeNode thisParent = q.poll();
          if (index == nodesInData.length) break;
          String leftStr = nodesInData[index++];
          if (!leftStr.equals("a")) {
            TreeNode leftNode = new TreeNode(Integer.parseInt(leftStr));
            thisParent.left = leftNode;
            q.offer(leftNode);
          }
          if (index == nodesInData.length) break;
          String rightStr = nodesInData[index++];
          if (!rightStr.equals("a")) {
            TreeNode rightNode = new TreeNode(Integer.parseInt(rightStr));
            thisParent.right = rightNode;
            q.offer(rightNode);
          }
        }
      }
      return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
