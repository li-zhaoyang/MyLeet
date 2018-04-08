/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
      int length = 0;
      ListNode thisNode = head;
      while (thisNode != null) {
        length++;
        if (thisNode.next == null)  break;
        thisNode = thisNode.next;
      }
      ListNode endNode = thisNode;
      thisNode = head;
      ListNode lastListNode = null;
      for (int i = 0; i < length; i++) {
        if (i > length / 2) {
          ListNode temp = thisNode.next;
          thisNode.next = lastListNode;
          lastListNode = thisNode;
          thisNode = temp;
        } else {
          lastListNode = thisNode;
          thisNode = thisNode.next;
        }
      }

      for (int i = 0; i < length / 2; i++) {
        if (head.val != endNode.val) return false;
        head = head.next;
        endNode = endNode.next;
      }
      return true;
    }
}
