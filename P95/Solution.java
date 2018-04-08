import java.util.*;
class Solution {
    public List<TreeNode> generateTrees(int n) {
      List<Integer> nodeVals = new ArrayList();
      for (int i = 1; i <= n ; i++ ) {
        nodeVals.add((Integer) i);
      }
      return generateFromNums(nodeVals);
    }

    private List<TreeNode> generateFromNums(List<Integer> nodeVals){
      if(nodeVals == null)  return null;
      List<TreeNode> thisTrees = new ArrayList<TreeNode>();
      for(int i = 0 ; i < nodeVals.size(); i++){
        List<TreeNode> leftSubTrees = generateFromNums(nodeVals.subList(0, i));
        List<TreeNode> rightSubTrees = generateFromNums(nodeVals.subList(i + 1, nodeVals.size()));
        if(leftSubTrees.size() == 0){
          if(rightSubTrees.size() == 0){
            TreeNode thisTree = new TreeNode(nodeVals.get(i));
            thisTrees.add(thisTree);
            continue;
          }
          for(TreeNode rightTree : rightSubTrees){
            TreeNode thisTree = new TreeNode(nodeVals.get(i));
            thisTree.right = rightTree;
            thisTrees.add(thisTree);
          }
          continue;
        }
        if(rightSubTrees.size() == 0){
          for(TreeNode tree : leftSubTrees){
            TreeNode thisTree = new TreeNode(nodeVals.get(i));
            thisTree.left = tree;
            thisTrees.add(thisTree);
          }
          continue;
        }
        for(TreeNode leftTree : leftSubTrees){
          for(TreeNode rightTree : rightSubTrees){
            TreeNode thisTree = new TreeNode(nodeVals.get(i));
            thisTree.left = leftTree;
            thisTree.right = rightTree;
            thisTrees.add(thisTree);
          }
        }
      }
      return thisTrees;
    }
}
