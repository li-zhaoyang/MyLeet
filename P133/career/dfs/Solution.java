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
      Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
      HashMap<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
      stack.push(node);
      UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
      oldToNew.put(node, newRoot);
      while (!stack.isEmpty()) {
        int size = stack.size();
        UndirectedGraphNode oriNode = stack.pop();
        UndirectedGraphNode newNode = oldToNew.get(oriNode);
        newNode.neighbors = new ArrayList<UndirectedGraphNode>();
        for (int j = 0; j < oriNode.neighbors.size(); j++) {
          UndirectedGraphNode linkedRoot = oriNode.neighbors.get(j);
          if (oldToNew.containsKey(linkedRoot)){
            newNode.neighbors.add(oldToNew.get(linkedRoot));
            continue;
          }
          stack.push(linkedRoot);
          UndirectedGraphNode newLinkedRoot = new UndirectedGraphNode(linkedRoot.label);
          newNode.neighbors.add(newLinkedRoot);
          oldToNew.put(linkedRoot, newLinkedRoot);
        }
      }
      return newRoot;
    }
}
