/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  private ListNode newHead = null;
    public ListNode reverseList(ListNode head) {
      if (head == null) return head;
      reverseLast(head);
      return newHead;
    }

    private ListNode reverseLast(ListNode head) {
      if (head.next == null){
        newHead = head;
        return head;
      }
      ListNode lastInReverse = reverseLast(head.next);
      lastInReverse.next = head;
      head.next = null;
      return head;
    }
}
