/*
    Contest 124
    Feb 16, 2019
*/
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
    Map<Integer, Integer> depth = new HashMap();
    Map<Integer, Integer> parent = new HashMap();
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, -1, 0);
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
    }
    private void dfs(TreeNode cur, int p, int d) {
        if (cur == null) return;
        depth.put(cur.val, d);
        parent.put(cur.val, p);
        dfs(cur.left, cur.val, d+1);
        dfs(cur.right, cur.val, d+1);
    }
}