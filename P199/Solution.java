/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> ans = new ArrayList<Integer>();
      if(root == null)  return ans;
      Stack<TreeNode> nodeStack = new Stack<TreeNode>();
      Stack<Integer> depthStack = new Stack<Integer>();
      int thisDepth = 0, maxIndex = -1;
      TreeNode thisNode ;
      nodeStack.push(root);
      depthStack.push(0);
      while(!nodeStack.empty()){
        thisNode = nodeStack.pop();
        thisDepth = depthStack.pop();
        while(true){
          if(thisNode.left != null){
            nodeStack.push(thisNode.left);
            depthStack.push(thisDepth + 1);
          }
          if(maxIndex < thisDepth) {
            ans.add(thisNode.val);
            maxIndex ++ ;
          }
          if(thisNode.right == null)  break;
          thisNode = thisNode.right;
          thisDepth++;
        }
      }

      return ans;
    }
}
