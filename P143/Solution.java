import java.util.*;
class Solution {
    public void reorderList(ListNode head) {
      HashMap<Integer, ListNode> nodeMap = new HashMap<Integer, ListNode>();
      ListNode thisNode = head;
      int i = 0;
      while(thisNode != null){
        nodeMap.put(i, thisNode);
        i++;
        thisNode = thisNode.next;
      }
      for(int j = 0 ; j < i/2; j++){
        nodeMap.get(j).next = nodeMap.get(i - j - 1);
        nodeMap.get(i - j - 1).next = nodeMap.get(j + 1);
      }
      if(i != 0) nodeMap.get(i/2).next = null;
    }
}
