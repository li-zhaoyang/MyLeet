import java.util.*;
class Solution {
    class Node implements Comparable{
      int id;
      int dist;
      public Node(int num) {
        id = num;
        dist = Integer.MAX_VALUE;
      }
      @Override
      public int compareTo(Object a) {
        Node other = (Node) a;
        if (this.dist == other.dist) {
            return Integer.valueOf(this.id).compareTo(other.id);
        } else {
            return Integer.valueOf(this.dist).compareTo(other.dist);
        }
      }
    }
    private void addToMapAndSet(int nodeId, HashMap<Integer, Node> idToNodeMap, TreeSet<Node> treeSet, int k) {
      Node thisNode = new Node(nodeId);
      idToNodeMap.put(nodeId, thisNode);
      if (nodeId == k) thisNode.dist = 0;
      treeSet.add(thisNode);
    }
    public int networkDelayTime(int[][] times, int N, int K) {
      int k = K;
      if (times == null || times.length == 0 || times[0] == null || times[0].length == 0 || N == 0) return -1;
      HashMap<Integer, HashMap<Node, Integer>> neighborTable = new HashMap<Integer, HashMap<Node, Integer>>();
      TreeSet<Node> treeSet = new TreeSet<Node>();
      HashMap<Integer, Node> idToNodeMap = new HashMap<Integer, Node>();
      for (int[] triple: times) {
        if (!idToNodeMap.containsKey(triple[0])) addToMapAndSet(triple[0], idToNodeMap, treeSet, k);
        if (!idToNodeMap.containsKey(triple[1])) addToMapAndSet(triple[1], idToNodeMap, treeSet, k);
        HashMap<Node, Integer> thisNeighborMap = neighborTable.getOrDefault(triple[0], new HashMap<Node, Integer>());
        thisNeighborMap.put(idToNodeMap.get(triple[1]), triple[2]);
        neighborTable.put(triple[0], thisNeighborMap);
      }
      HashMap<Integer, Integer> shortestDistMap = new HashMap<Integer, Integer>();

      while (!treeSet.isEmpty()) {
        Node thisNode = treeSet.pollFirst();
        shortestDistMap.put(thisNode.id, thisNode.dist);
        HashMap<Node, Integer> neighborDistMap = neighborTable.getOrDefault(thisNode.id, new HashMap<Node, Integer>());
        for (Node otherNode: neighborDistMap.keySet()) {
          int newDist = thisNode.dist + neighborDistMap.get(otherNode);
          if (otherNode.dist > newDist) {
            treeSet.remove(otherNode);
            otherNode.dist = newDist;
            treeSet.add(otherNode);
          }
        }
      }
      int max = 0;
      for (int nodeID: shortestDistMap.keySet()) {
        if (shortestDistMap.get(nodeID) > max) max = shortestDistMap.get(nodeID);
      }
      if (max == Integer.MAX_VALUE || shortestDistMap.size() != N) max = -1;
      return max;
    }

}
