



class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode thisNode = head, last = new ListNode(0);
      boolean first = true;
      while(true){
        if(first){
          if(getNextN(thisNode,n)==null){
            head = head.next;
            break;
          }
          first = false;
        }
        //construct n next
        else if(getNextN(thisNode,n)==null){
          last.next = thisNode.next;
          break;
        }
        last = thisNode;
        thisNode = thisNode.next;
      }
      return head;
    }
    public ListNode getNextN(ListNode thisNode, int n){
      ListNode nThNode = thisNode;
      for(int i=0;i<n;i++){
        nThNode = nThNode.next;
      }
      return nThNode;
    }
}
