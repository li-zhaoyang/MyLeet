public class Solution {
    public boolean validTree(int n, int[][] edges) {
      if(n <= 0 || edges == null) return false;
      if(edges.length != n - 1) return false;
      ArrayList<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();
      int[] id = new int[n];
      for (int i = 0; i < n; i++) {
        graph.add(new LinkedList<Integer>());
        id[i] = i;
      }
      for (int i = 0; i < edges.length; i++) {
        id[findRoot(id, edges[0])] = findRoot(id, edges[1]);
        graph.get(edges[0]).add(edges[1]);
        graph.get(edges[1]).add(edges[0]);
      }
      int root = findRoot(id, 0);
      for (int i = 1; i < n; i++) {
        if (findRoot(id, i) != root ) return false;
      }

      Queue<Integer> queue = new LinkedList<Integer>();
      HashSet<Integer> travelled = new HashSet<Integer>();
      queue.add(0);
      while (!queue.isEmpty()) {
        int thisV = queue.poll();
        if (travelled.contains(thisV))  return false;
        travelled.add(t);
        for (int i = 0; i < graph.get(thisV).size(); i++) {
          queue.add(graph.get(thisV).get(i));
        }
      }
      if(travelled.size() != n) return false;     //Can this substitute union find?
      return true;
    }

    private int findRoot(int[] id, int i) {
      while (id[i] != i)  i = id[i];
      return i;
    }
}
