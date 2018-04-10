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
class Solution {
    public void recoverTree(TreeNode root) {
      Stack<TreeNode> stack = new Stack<TreeNode>();
      TreeNode cur = root;
      TreeNode prev = null, left = null, right = null;
      boolean first = true;
      while(!stack.empty() || cur != null){
        while(cur!= null){
          stack.push(cur);
          cur = cur.left;
        }
        TreeNode thisTree = stack.pop();
        if(! first){
          if(prev.val > thisTree.val) {
            if(left == null)  left = prev;
            right = thisTree;
          }
        }
        first = false;
        prev = thisTree;
        System.out.println(thisTree.val);
        cur = thisTree.right;
      }

      if(left == null) {
        return;
      }
      int temp = left.val;
      left.val = right.val;
      right.val = temp;
    }
}
