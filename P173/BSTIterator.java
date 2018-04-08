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
      if(root == null){
        thisNode = null;
      }else{
        TreeNode thisLayerNode = root;
        while(thisLayerNode.left != null){
          rootToEnd.push(thisLayerNode);
          thisLayerNode = thisLayerNode.left;
        }
        thisNode = thisLayerNode;
      }
      start = true;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      if(thisNode == null)  return false;
      if(start) return true;
      if(thisNode.right != null)  return true;
      return !rootToEnd.empty();
    }

    /** @return the next smallest number */
    public int next() {
      if(thisNode == null)  return 0;
      if(start){
        start = false;
        return thisNode.val;
      }
      if(thisNode.right != null) {
        TreeNode thisLayerNode = thisNode.right;
        while(thisLayerNode.left != null){
          rootToEnd.push(thisLayerNode);
          thisLayerNode = thisLayerNode.left;
        }
        thisNode = thisLayerNode;
        return thisNode.val;
      }
      if(rootToEnd.empty()){
        return 0;
      }
      thisNode = rootToEnd.pop();
      return thisNode.val;



    }



}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
