import java.util.*;
class Solution {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (root == null) return ans;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    HashMap<TreeNode, Integer> posMap = new HashMap<TreeNode, Integer>();
    q.offer(root);
    posMap.put(root, 0);
    while (!q.isEmpty()) {
      for (int i = 0; i < q.size(); i++) {
        TreeNode thisNode = q.poll();
        int pos = posMap.get(thisNode);
        List<Integer> thisLevelList = map.getOrDefault(pos, new ArrayList<Integer>());
        thisLevelList.add(thisNode.val);
        map.put(pos, thisLevelList);
        if (thisNode.left != null) {
          q.offer(thisNode.left);
          posMap.put(thisNode.left, pos - 1);
        }
        if (thisNode.right != null) {
          q.offer(thisNode.right);
          posMap.put(thisNode.right, pos + 1);
        }
      }
    }
    while (!map.isEmpty()) {
      Map.Entry<Integer, List<Integer>> mapEntry = map.pollFirstEntry();
      ans.add(mapEntry.getValue());
    }

    return ans;
  }

  public void helper(Map<Integer, List<Integer>> map, TreeNode thisNode, int pos) {
    if (thisNode == null) return;
    helper(map, thisNode.left, pos - 1);
    helper(map, thisNode.right, pos + 1);
  }
}
