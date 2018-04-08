/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists == null || lists.length == 0) return null;
      int l = lists.length;
      if( l == 1) return lists[0];
      ListNode[] newLists= new ListNode[l/2 + l%2];
      for(int i = 1 ; i < l ; i++){
        if(i % 2 == 1)  newLists[i/2] = mergeTwoLists(lists[i - 1], lists[i]);
        if(i % 2 == 0 && i == l - 1) newLists[i/2] = lists[i];
      }
      return mergeKLists(newLists);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      ListNode thisL1 = l1;
      ListNode thisL2 = l2;
      ListNode newList = null;
      if(l1.val < l2.val) {
        newList = new ListNode(l1.val);
        thisL1 = l1.next;
      }
      else{
        newList = new ListNode(l2.val);
        thisL2 = l2.next;
      }
      ListNode thisNL = newList;

      while(true){
        if(thisL1 == null && thisL2 == null)  return newList;
        if(thisL1 == null){
          thisNL.next = thisL2;
          return newList;
        }
        if(thisL2 == null){
          thisNL.next = thisL1;
          return newList;
        }
        if(thisL1.val<thisL2.val){
          thisNL.next = new ListNode(thisL1.val);
          thisL1 = thisL1.next;
        }else{
          thisNL.next = new ListNode(thisL2.val);
          thisL2 = thisL2.next;
        }
        thisNL = thisNL.next;
      }
      //return null;

    }

}
