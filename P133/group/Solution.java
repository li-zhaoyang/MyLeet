import java.util.*;
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      if(node == null)  return null;
      Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
      HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
      UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
      map.put(node, newRoot);
      queue.add(node);
      while (!queue.isEmpty()) {
        UndirectedGraphNode thisNode = queue.poll();
        UndirectedGraphNode thisNewNode = map.get(thisNode);
        for (int i = 0; i < thisNode.neighbors.size(); i++) {
          UndirectedGraphNode thisNeighborNode = thisNode.neighbors.get(i);
          if(!map.containsKey(thisNeighborNode)) {
            UndirectedGraphNode thisNewNeighborNode = new UndirectedGraphNode(thisNeighborNode.label);
            thisNewNode.neighbors.add(thisNewNeighborNode);
            map.put(thisNeighborNode, thisNewNeighborNode);
            queue.add(thisNeighborNode);
          } else {
            thisNewNode.neighbors.add(map.get(thisNeighborNode));
          }
        }
      }
      return newRoot;
    }
}
