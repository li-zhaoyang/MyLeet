import java.util.*;
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      List<LinkedList<Boolean>> ways = new ArrayList<LinkedList<Boolean>>();
      lowestAncestor(root, p, ways, new LinkedList<Boolean>());
      lowestAncestor(root, q, ways, new LinkedList<Boolean>());
      TreeNode thisNode = root;
      if (ways.size() < 2)  return null;
      for (int i = 0; i < ways.get(0).size() && i < ways.get(1).size(); i++) {
        if (ways.get(0).get(i) != ways.get(1).get(i)) return thisNode;
        if (ways.get(0).get(i)) thisNode = thisNode.left;
        else thisNode = thisNode.right;
      }
      return thisNode;
    }

    private boolean lowestAncestor(TreeNode thisNode, TreeNode p, List<LinkedList<Boolean>> ways, LinkedList<Boolean> temp) {
      if (thisNode == null) return false;
      if (thisNode == p){
        ways.add(temp);
        return true;
      }
      temp.add(true);
      if (lowestAncestor(thisNode.left, p, ways, new LinkedList<Boolean>(temp))) return true;
      temp.removeLast();
      temp.add(false);
      return lowestAncestor(thisNode.right, p, ways, new LinkedList<Boolean>(temp));
    }
}
