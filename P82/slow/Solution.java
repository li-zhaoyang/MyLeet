import java.util.*;
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      if(head == null) return head;
      if(head.next == null) return head;
      ListNode thisListNode = head;
      ListNode lastListNode = head;
      head = null;

      boolean dup = false;
      while(thisListNode.next!=null){
        System.out.println(lastListNode.val);
        while(thisListNode.next.val == thisListNode.val){
          dup = true;
          thisListNode = thisListNode.next;
          if(thisListNode.next == null){lastListNode.next = null; return head;}
        }
        if(dup == false){
          System.out.println("here " + thisListNode.val);
          if(head == null){
            head = thisListNode;
            lastListNode = head;
          }else{
            lastListNode.next = thisListNode;
            lastListNode = thisListNode;
          }
        }
        thisListNode = thisListNode.next;
        dup = false;
      }
      if(head == null)  return thisListNode;
      lastListNode.next = thisListNode;

      return head;

    }
}
