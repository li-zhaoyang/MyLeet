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
      StringBuffer sb = new StringBuffer();
      if (root == null) return "";
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      sb.append(root.val);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode cur = queue.poll();
          sb.append(',');
          if (cur.left != null) {
            sb.append(cur.left.val);
            queue.offer(cur.left);
          } else sb.append(" ");
          sb.append(',');
          if (cur.right != null) {
            sb.append(cur.right.val);
            queue.offer(cur.right);
          } else sb.append(" ");
        }
      }
      return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data == "") return null;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      String[] nodeVals = data.split(",");
      if (nodeVals.length == 0) return null;
      TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
      queue.offer(root);
      int index = 1;
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode thisNode = queue.poll();
          if (index == nodeVals.length) return root;
          if (!nodeVals[index].equals(" ")) {
            TreeNode newNode = new TreeNode(Integer.parseInt(nodeVals[index]));
            thisNode.left = newNode;
            queue.offer(newNode);
          }
          index ++;
          if (index == nodeVals.length) return root;
          if (!nodeVals[index].equals(" ")) {
            TreeNode newNode = new TreeNode(Integer.parseInt(nodeVals[index]));
            thisNode.right = newNode;
            queue.offer(newNode);
          }
          index ++;
        }
      }
      return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
