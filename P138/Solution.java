import java.util.*;
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
      if(head == null)  return null;
      HashMap<RandomListNode, RandomListNode> mHashMap = new HashMap<RandomListNode, RandomListNode>();
      RandomListNode thisNode = head;
      RandomListNode thisNewNode = null;
      RandomListNode lastNewNode = null;
      RandomListNode newHead = null;

      while(thisNode != null){
        thisNewNode = new RandomListNode(thisNode.label);
        mHashMap.put(thisNode, thisNewNode);
        if(lastNewNode != null) {
          lastNewNode.next = thisNewNode;
        }else{
          newHead = thisNewNode;
        }
        lastNewNode = thisNewNode;
        thisNode = thisNode.next;
      }
      thisNode = head;
      thisNewNode = newHead;
      while(thisNode != null){
        if(thisNode.random != null){
          thisNewNode.random = mHashMap.get(thisNode.random);
        }
        thisNode = thisNode.next;
        thisNewNode = thisNewNode.next;
      }
      return newHead;

    }
}
