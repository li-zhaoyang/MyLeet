/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      if(head == null)  return null;
      ListNode thisNode = head, ansList = null, lastNodeOfLastRun = null;
      boolean first = true;
      while(thisNode != null){
        int i = 0;
        ListNode thisStart = thisNode;
        while(i < k && thisNode != null){
          thisNode = thisNode.next;
          i ++;
        }
        if(i != k){
          break;
        }
        ListNode newThisNode = thisStart, newLastNode = thisNode;
        i = 0;
        while(i < k){
          ListNode nextTemp = newThisNode.next;
          newThisNode.next = newLastNode;
          newLastNode = newThisNode;
          newThisNode = nextTemp;
          i ++;
        }
        if(first){
          first = false;
          ansList = newLastNode;
        }
        else lastNodeOfLastRun.next = newLastNode;
        lastNodeOfLastRun = thisStart;
      }
      if(first) return head;
      return ansList;
    }
}
