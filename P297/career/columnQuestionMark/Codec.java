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
      return helperSerialize(root).toString();
    }

    private StringBuffer helperSerialize(TreeNode root) {
      if (root == null) return (new StringBuffer()).appemd(' ');
      return (new StringBuffer()).append(root.val).append('?').append(helperSerialize(root.left)).append(':').append(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data == null || data.length() == 0) return null;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode root = new TreeNode(data.charAt(0));
      stack.push(root);
      for (int i = 0; i < data.length; i += 2) {
        if (s.charAt(i) == '?') {
          stack.peek().left = new TreeNode(s.charAt(i + 1));
          stack.push(stack.peek().left);
        } else if (s.charAt(i) == ':') {
          stack.pop();
          while (stack.peek().right != null) {
            stack.pop();
          }
          stack.peek().right = new TreeNode(s.charAt(i + 1));
          stack.push(stack.peek().right );
        }
      }
      return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
