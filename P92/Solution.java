class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      ListNode firstOfReverse = head, leftListNode = head;
      if(head == null)  return head;
      if(head.next == null) return head;
      if( m == 1) {
        leftListNode = null;
      }
      else{
        for(int i = 0 ; i < m - 2; i ++){
          leftListNode = leftListNode.next;
        }
        firstOfReverse = leftListNode.next;
      }
      ListNode thisListNode = firstOfReverse, lastListNode = firstOfReverse, nextListNode = firstOfReverse.next;
      for(int i = m; i < n + 1; i++){
        nextListNode = thisListNode.next;
        thisListNode.next = lastListNode;
        lastListNode = thisListNode;
        thisListNode = nextListNode;
      }
      firstOfReverse.next = thisListNode;
      if(leftListNode == null)  return lastListNode;
      leftListNode.next = lastListNode;
      return head;
    }
}
