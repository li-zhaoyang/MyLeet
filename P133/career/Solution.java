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
      Queue<UndirectedGraphNode> newNodeQueue = new LinkedList<UndirectedGraphNode>();
      // HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
      HashMap<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
      queue.offer(node);
      // set.add(node);
      UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
      oldToNew.put(node, newRoot);
      // newNodeQueue.offer(newRoot);
      while (!queue.isEmpty()) {
        int size = queue.size();
        UndirectedGraphNode oriNode = queue.poll();
        // UndirectedGraphNode newNode = newNodeQueue.poll();
        UndirectedGraphNode newNode = oldToNew.get(oriNode);
        newNode.neighbors = new ArrayList<UndirectedGraphNode>();
        for (int j = 0; j < oriNode.neighbors.size(); j++) {
          UndirectedGraphNode linkedRoot = oriNode.neighbors.get(j);
          if (oldToNew.containsKey(linkedRoot)){
            newNode.neighbors.add(oldToNew.get(linkedRoot));
            continue;
          }
          // set.add(linkedRoot);
          queue.offer(linkedRoot);
          UndirectedGraphNode newLinkedRoot = new UndirectedGraphNode(linkedRoot.label);
          newNode.neighbors.add(newLinkedRoot);
          // newNodeQueue.offer(newLinkedRoot);
          oldToNew.put(linkedRoot, newLinkedRoot);
        }
      }
      return newRoot;
    }
}
