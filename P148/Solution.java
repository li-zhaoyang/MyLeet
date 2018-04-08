// import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
      if(head == null)  return head;
      if(head.next == null) return head;
      ListNode fast = head.next;
      ListNode slow = head;
      ListNode lastSlow = null;
      while(fast != null){
        lastSlow = slow;
        slow = slow.next;
        if(fast.next == null) break;
        fast = fast.next.next;
      }
      lastSlow.next = null;
      ListNode mid = slow;
      head = sortList(head);
      mid = sortList(mid);
      return merge(head, mid);
    }

    public ListNode merge(ListNode head, ListNode mid){
      if(head == null)  return mid;
      if(mid == null) return head;
      ListNode left = head;
      ListNode right = mid;
      ListNode thisNode = new ListNode(0);
      ListNode newHead = thisNode;
      while(true){
        if(left.val < right.val){
          thisNode.next = left;
          left = left.next;
          if(left == null){
            thisNode.next.next = right;
            break;
          }
        }else{
          thisNode.next = right;
          right = right.next;
          if(right == null){
            thisNode.next.next = left;
            break;
          }
        }
        thisNode = thisNode.next;
      }
      return newHead.next;
    }

}
