import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      if (numCourses == 0 || prerequisites.length == 0)  return true;
      ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
      int[] inOrder = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
        graph.add(new LinkedList<Integer>());
      }
      for (int[] pair: prerequisites) {
        graph.get(pair[1]).add(pair[0]);
        inOrder[pair[0]]++;
      }
      Queue<Integer> heads = new LinkedList<Integer>();
      for (int i = 0; i < numCourses; i++) {
        if (inOrder[i] == 0)  heads.offer(i);
      }
      int count = 0;
      while (!heads.isEmpty()) {
        LinkedList<Integer> neighbors = graph.get(heads.poll());
        count++;
        for (int i = 0; i < neighbors.size(); i++) {
          inOrder[neighbors.get(i)]--;
          if (inOrder[neighbors.get(i)] == 0) heads.add(neighbors.get(i));
        }
      }
      return count == numCourses;
    }
}
