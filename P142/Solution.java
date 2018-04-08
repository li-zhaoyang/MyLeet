import java.util.*;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
      if(head == null)  return null;
      ListNode slow = head;
      ListNode fast = head;
      boolean first = true;
      int i = 0;
      while(slow != null && fast != null){
        if(slow == fast && !first)  { break; }
        first = false;
        slow = slow.next;
        if(fast.next == null) return null;
        fast = fast.next.next;
        i++;
      }
      if(slow == null || fast == null)  return null;
      fast = head;
      while(true){
        if(fast == slow)  return fast;
        fast = fast.next;
        slow = slow.next;
      }
      // return null;

    }
}
