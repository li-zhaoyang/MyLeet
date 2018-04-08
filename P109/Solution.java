import java.util.*;
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
      if(head == null)  return null;
      int length = 0 ;
      ListNode thisListNode = head;
      for(;;length++){
        if(thisListNode == null)  break;
        thisListNode = thisListNode.next;
      }
      return helperBST( head, length-1);
    }
    private TreeNode helperBST(ListNode head, int end){
      if(head == null || end < 0) return null;
      if(end == 0)  return new TreeNode(head.val);
      int mid = end/2;
      ListNode thisListNode = head;
      for(int i = 0 ; i < mid; i++){
        thisListNode = thisListNode.next;
      }
      TreeNode thisTree = new TreeNode(thisListNode.val);
      thisTree.left = helperBST(head, mid - 1);
      thisTree.right = helperBST(thisListNode.next , end - mid - 1);
      return thisTree;
    }
}
