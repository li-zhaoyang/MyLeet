import java.util.*;
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      if(head == null) return head;
      if(head.next == null) return head;
      ListNode thisListNode = head;
      ListNode lastListNode = null;
      ListNode newHead = new ListNode(0);
      while(thisListNode.next!=null){
        while(thisListNode.next.val == thisListNode.val){
          thisListNode = thisListNode.next;
          if(thisListNode.next == null){
            if(thisListNode.val == head.val)  return thisListNode;
            lastListNode.next = thisListNode;
            return head;
          }
        }
        if(lastListNode == null)  head = thisListNode;
        else  lastListNode.next = thisListNode;
        lastListNode = thisListNode;
        thisListNode = thisListNode.next;
      }
      lastListNode.next = thisListNode;

      return head;

    }
}
