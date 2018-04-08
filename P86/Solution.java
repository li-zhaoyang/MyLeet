import java.util.*;
class Solution {
    public ListNode partition(ListNode head, int x) {
      if(head == null)  return head;
      if(head.next == null) return head;
      ListNode leftHead = null;
      ListNode rightHead = null;
      ListNode lastLeftListNode = null;
      ListNode lastRightListNode = null;
      ListNode thisListNode = head;
      while(thisListNode != null){
        if(thisListNode.val < x){
          if(leftHead == null){
            leftHead = thisListNode;
            lastLeftListNode = thisListNode;
          }
          else{
            lastLeftListNode.next = thisListNode;
            lastLeftListNode = thisListNode;
          }
        }
        else{
          if(rightHead == null){
            rightHead = thisListNode;
            lastRightListNode = thisListNode;
          }
          else{
            lastRightListNode.next = thisListNode;
            lastRightListNode = thisListNode;
          }
        }
        thisListNode = thisListNode.next;
      }
      if(leftHead == null)  return rightHead;
      if(rightHead == null) return leftHead;
      lastLeftListNode.next = rightHead;
      lastRightListNode.next = null;
      return leftHead;

    }
}
