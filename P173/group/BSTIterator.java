/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class BSTIterator {
    TreeNode thisNode;
    Stack<TreeNode> rootToEnd;
    boolean start;

    public BSTIterator(TreeNode root) {
      rootToEnd = new Stack<TreeNode>();
      fillStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return !rootToEnd.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
      TreeNode ans = rootToEnd.pop();
      fillStack(ans.right);
      return ans.val;
    }

    private void fillStack(TreeNode root){
    while(root != null){
      rootToEnd.push(root);
      root = root.left;
    }
}



}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
