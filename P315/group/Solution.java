import java.util.*;

class Solution {
    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode father;
       boolean isLeft;
       int smallerCount;
       TreeNode(int x, TreeNode thisFather, boolean left){
         isLeft = left;
         father = thisFather;
         val = x;
         smallerCount = 0;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
      if (nums == null || nums.length == 0) return new ArrayList<Integer>();
      int[] sortedNums = Arrays.copyOf(nums, nums.length);
      Arrays.sort(sortedNums);
      int index = 0;
      for (int i = 0; i < sortedNums.length - 1; i++) {
        if (sortedNums[i] != sortedNums[i + 1]) {
          sortedNums[index++] = sortedNums[i];
        }
      }
      sortedNums[index++] = sortedNums[sortedNums.length - 1];
      sortedNums = Arrays.copyOf(sortedNums, index);
      HashMap<Integer, TreeNode> intToNode = new HashMap<Integer, TreeNode>();
      TreeNode root = helperBST(sortedNums, 0, sortedNums.length - 1, intToNode, null, false);
      LinkedList<Integer> ans = new LinkedList<Integer>();
      for (int i = nums.length - 1; i >= 0 ; i--) {
        addToFather(intToNode.get(nums[i]), false);
        ans.addFirst(intToNode.get(nums[i]).smallerCount);
      }
      return ans;
    }

    private TreeNode helperBST(int[] nums, int start, int end, HashMap<Integer, TreeNode> intToNode, TreeNode father, boolean isLeft){
      if(start > end) return null;
      int mid = start + (end - start)/2;
      TreeNode thisTree = new TreeNode(nums[mid], father, isLeft);
      thisTree.left = helperBST(nums, start, mid - 1, intToNode, thisTree, true);
      thisTree.right = helperBST(nums, mid + 1 , end, intToNode, thisTree, false);
      intToNode.put(nums[mid], thisTree);
      return thisTree;
    }

    private void addToFather(TreeNode root, boolean fromLeft) {
      if (root == null) return ;
      if (fromLeft) root.smallerCount ++;
      addToFather(root.father, root.isLeft);
    }
}
