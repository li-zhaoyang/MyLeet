/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

      int l1 = 0, l2 = 0;
      ListNode thisNodeA = headA, thisNodeB = headB;
      while(thisNodeA != null){
        l1++;
        thisNodeA = thisNodeA.next;
      }
      while(thisNodeB != null){
        l2++;
        thisNodeB = thisNodeB.next;
      }
      if(l1 > l2){
        ListNode temp = headB;
        headB = headA;
        headA = temp;
      }
      thisNodeA = headA;
      thisNodeB = headB;
      int i = Math.abs(l2 - l1);
      System.out.println(i);
      while(i > 0){
        thisNodeB = thisNodeB.next;
        i --;
      }
      while(true){
        if(thisNodeA == thisNodeB)  return thisNodeA;
        thisNodeB = thisNodeB.next;
        thisNodeA = thisNodeA.next;
      }
    }
}
