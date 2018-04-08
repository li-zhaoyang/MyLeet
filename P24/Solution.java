/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head){
      ListNode thisListNode = head, lastListNode = head, thisNextListNode0 = head;
      if(head == null)  return head;
      if(head.next == null) return head;
      head = thisListNode.next;
      int i=0;
      while(true){
        thisNextListNode0 = thisListNode.next;
        if(i%2 ==0 ){
          if(thisListNode.next == null){
            break;
          }

          if(thisListNode.next.next == null){
            thisListNode.next = null;
          }else if(thisListNode.next.next.next == null){
            thisListNode.next = thisListNode.next.next;
          }else thisListNode.next = thisListNode.next.next.next;
        }
        if(i%2 ==1){
          if(thisListNode.next == null) {
            thisListNode.next = lastListNode;
            break;
          }
          thisListNode.next = lastListNode;
        }
        lastListNode = thisListNode;
        thisListNode = thisNextListNode0;
        i++;
      }
      return head;

    }
}
