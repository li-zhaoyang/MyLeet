import java.util.*;
class LRUCache {
    class Node{
      int mValue;
      int mKey;
      public Node next;
      public Node last;

      public Node(int key, int val){
        mKey = key;
        mValue = val;
        next = null;
        last = null;
      }

      public void setVal(int value){
        mValue = value;
      }

      public int getVal(){
        return mValue;
      }
      public int getKey(){
        return mKey;
      }
    }
    private HashMap<Integer, Node> map;

    private static int maxCapacity;

    private Node head, end;

    public LRUCache(int capacity) {
      maxCapacity = capacity;
      map = new HashMap<Integer, Node>();
      head = new Node(-1, -1);
      end = new Node(-1, -1);
      head.next = end;
      end.last = head;
    }

    public int get(int key) {

      if(map.containsKey(key)){
        Node thisNode = map.get(key);
        removeNode(thisNode);
        addNode(thisNode);
        // System.out.println(head.next.getVal() + " " + end.last.getVal());
        return thisNode.getVal();
      }

      return -1;
    }

    public void put(int key, int value) {
      if(map.containsKey(key)){
        Node thisNode = map.get(key);
        thisNode.setVal(value);
        removeNode(thisNode);
        addNode(thisNode);
        System.out.println(head.next.getVal() + " " + end.last.getVal());
        return;
      }
      Node thisNode = new Node(key, value);
      if(map.size() == maxCapacity){
        map.remove(head.next.getKey());
        removeNode(head.next);
      }
      addNode(thisNode);
      map.put(key, thisNode);
      // System.out.println(head.next.getVal() + " " + end.last.getVal());
    }

    private void removeNode(Node thisNode){
      thisNode.next.last = thisNode.last;
      thisNode.last.next = thisNode.next;
    }

    private void addNode(Node thisNode){
      end.last.next = thisNode;
      thisNode.last = end.last;
      end.last = thisNode;
      thisNode.next = end;
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
