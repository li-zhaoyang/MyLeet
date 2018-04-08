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
      HashSet<Integer> clonedNode = new HashSet<Integer>();
      HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
      UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
      nodeMap.put(node.label, newNode);
      clonedNode.add(node.label);
      cloning(clonedNode,nodeMap, node, newNode);
      return newNode;
    }

    private void cloning(HashSet<Integer> clonedNode,HashMap<Integer, UndirectedGraphNode> nodeMap, UndirectedGraphNode lastOriginalNode, UndirectedGraphNode lastNewNode ){
      UndirectedGraphNode newNode;
      for(int i = 0; i < lastOriginalNode.neighbors.size(); i++){
        UndirectedGraphNode thisNode = lastOriginalNode.neighbors.get(i);
        int thisLabel = thisNode.label;
        if(nodeMap.containsKey(thisLabel)){
          newNode = nodeMap.get(thisLabel);
        }else{
          newNode = new UndirectedGraphNode(thisLabel);
          nodeMap.put(thisLabel,newNode);
        }
        lastNewNode.neighbors.add(newNode);
        if(thisLabel == lastOriginalNode.label){
          continue;
        }
        if(clonedNode.contains(thisLabel)){
          continue;
        }
        clonedNode.add(thisLabel);
        cloning(clonedNode, nodeMap, thisNode, newNode);

      }

    }
}
