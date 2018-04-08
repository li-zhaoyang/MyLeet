import java.util.*;
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if(head == null)  return head;
      List<ListNode> myList = new ArrayList<ListNode>();
      ListNode thisNode = head;
      while(true){
        myList.add(thisNode);
        if(thisNode.next == null) break;
        thisNode = thisNode.next;
      }
      int listLength = myList.size();
      k = k % listLength;
      if(k == 0)  return head;
      myList.get(listLength - k - 1).next = null;
      myList.get(listLength - 1).next = head;
      return myList.get(listLength - k);
    }

}
