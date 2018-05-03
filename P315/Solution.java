import java.util.*;
class Solution {
  class Node {
    Node left, right;
    int val, sum, dup;
    public Node(int v, int s) {
      val = v;
      sum = s;
      dup = 1;
    }
  }
    public List<Integer> countSmaller(int[] nums) {
      int l = nums.length;
      Integer[] ans = new Integer[l];
      Node root = null;
      for (int i = l - 1; i >= 0; i--) {
        root = insert(nums[i], root, ans, i, 0);
      }
      return Arrays.asList(ans);
    }

    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
      if (node == null) {
        node = new Node(num, 0);
        ans[i] = preSum;
      } else if (node.val == num) {
        node.dup++;
        ans[i] = preSum + node.sum;
      } else if (node.val > num) {
        node.sum ++;
        node.left = insert(num, node.left, ans, i, preSum);
      } else {
        node.right = insert(num, node.right, ans, i, preSum + node.sum + node.dup);
      }
      return node;

    }
}
