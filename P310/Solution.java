import java.util.*;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      List ans = new ArrayList<Integer>();
      if (n == 0) return ans;
      if (n == 1) {
        ans.add(0);
        return ans;
      }
      //Contruct a tree.From a point, DFS, store the two longest routes to the end, then find the medians
      ArrayList<LinkedList<Integer>> table = new ArrayList<LinkedList<Integer>>();
      for (int i = 0; i < n; i++) {
        table.add(new LinkedList<Integer>());
      }
      for (int i = 0; i < edges.length; i++) {
        table.get(edges[i][0]).add(edges[i][1]);
        table.get(edges[i][1]).add(edges[i][0]);
      }
      System.out.println("furthest");
      int furthest = bfsWithRouteFurthest(new HashMap<Integer, Integer>(), 0, table);
      HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
      furthest = bfsWithRouteFurthest(father, furthest, table);

      List longestPath = new ArrayList<Integer>();
      while (father.containsKey(furthest)) {
        longestPath.add(furthest);
        furthest = father.get(furthest);
      }
      longestPath.add(furthest);

      int l = longestPath.size();
      if (l % 2 == 0) {
        ans.add(longestPath.get(l / 2 - 1));
        ans.add(longestPath.get(l / 2));
      } else {
        ans.add(longestPath.get(l / 2));
      }
      return ans;
    }

    private int bfsWithRouteFurthest(HashMap<Integer, Integer> father, int root, ArrayList<LinkedList<Integer>> table) {
      Queue<Integer> queue = new LinkedList<Integer>();
      Set<Integer> set = new HashSet<Integer>();
      queue.offer(root);
      set.add(root);

      int furthest = -1;
      while (!queue.isEmpty()) {
        int lastNum = -1;
        for (int i = 0; i < queue.size(); i++) {
          lastNum = queue.poll();
          for (int j = 0; j < table.get(lastNum).size(); j++) {
            int thisToAdd = table.get(lastNum).get(j);
            if (!set.contains(thisToAdd)) {
              queue.offer(thisToAdd);
              set.add(thisToAdd);
              father.put(table.get(lastNum).get(j), lastNum);
            }
          }
        }
        if (queue.isEmpty()) {
          furthest = lastNum;
        }
      }
      return furthest;
    }
}
