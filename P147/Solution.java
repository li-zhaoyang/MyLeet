/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
      if(head == null)  return null;
      if(head.next == null) return head;
      ListNode sortedEnd = head;
      ListNode nodeToInsert = head.next;
      ListNode smallerNode = new ListNode(-1);
      smallerNode.next = head;
      while(true){
        if(nodeToInsert == null) break;
        while(true){
          if(smallerNode == sortedEnd){
            sortedEnd = nodeToInsert;
            break;
          }
          if(smallerNode.next.val > nodeToInsert.val){
            sortedEnd.next = nodeToInsert.next;
            nodeToInsert.next = smallerNode.next;
            if(smallerNode.next == head){
              head = nodeToInsert;
            }else{
              smallerNode.next = nodeToInsert;
            }
            break;
          }
          smallerNode = smallerNode.next;
        }
        nodeToInsert = sortedEnd.next;
        smallerNode = new ListNode(-1);
        smallerNode.next = head;
      }
      return head;
    }
}
