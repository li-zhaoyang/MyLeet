import java.util.*;
class Solution {
  //BFS
    public int numSquares(int n) {
      Queue<Integer> queue = new LinkedList<Integer>();
      Set<Integer> set = new HashSet<Integer>();
      queue.offer(0);
      set.add(0);
      int depth = 0;
      while (!queue.isEmpty()) {
        depth++;
        int size = queue.size();
        while (size-- > 0) {
          int thisNum = queue.poll();
          for (int i = 1; i * i <= n ; i++) {
            int nextNum = thisNum + i * i;
            if (nextNum < n) {
              if (!set.contains(nextNum)) {
                queue.offer(nextNum);
                set.add(nextNum);
              }
            } else if (nextNum == n) {
              return depth;
            } else break;
          }
        }
      }
      return 4;
    }
}
