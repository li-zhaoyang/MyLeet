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
    public int maxPathSum(TreeNode root) {
      Long max = Long.MIN_VALUE;
      if(root == null)  return Integer.MIN_VALUE;
      HashMap<TreeNode, Integer> maxMap = new HashMap<TreeNode, Integer>();
      maxSigleFromThis(root, maxMap);
      List<TreeNode> nodeList = new ArrayList(maxMap.keySet());
      for(int i = 0 ; i < nodeList.size(); i ++){
        int thisSum = maxMap.get(nodeList.get(i));
        if( (long) thisSum > max) max =(long) thisSum;
      }
      return Math.toIntExact(max);
    }

    private int maxSigleFromThis(TreeNode thisNode, HashMap<TreeNode, Integer> maxMap){
      if(thisNode.left == null && thisNode.right == null) {
        maxMap.put(thisNode, thisNode.val);
        return thisNode.val;
      }
      int thisMax = 0;
      Long thisMaxFromSingle = Long.MIN_VALUE;
      if(thisNode.left != null) {
        int thisLeft = maxSigleFromThis(thisNode.left, maxMap);
        if(thisLeft > 0) thisMax += thisLeft;
        if(thisMaxFromSingle < (long) thisLeft) thisMaxFromSingle = (long) thisLeft;
      }
      if(thisNode.right != null) {
        int thisRight = maxSigleFromThis(thisNode.right, maxMap);
        if(thisRight > 0) thisMax += thisRight;
        if(thisMaxFromSingle < (long) thisRight) thisMaxFromSingle = (long) thisRight;
      }
      maxMap.put(thisNode, thisMax + thisNode.val);
      return thisMaxFromSingle < 0?  thisNode.val : Math.toIntExact(thisMaxFromSingle) + thisNode.val;
    }
}
