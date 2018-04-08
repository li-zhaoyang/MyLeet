import java.util.*;
class Solution {
    class Cell {
      int row;
      int col;
      int num;
      public Cell(int r, int c, int n) {
        row = r;
        col = c;
        num = n;
      }
    }
    public int trapRainWater(int[][] heightMap) {
      if (heightMap == null || heightMap.length <= 2 || heightMap[0] == null || heightMap[0].length <= 2) return 0;
      int m = heightMap.length;
      int n = heightMap[0].length;
      PriorityQueue<Cell> pq = new PriorityQueue<Cell>((a, b) -> Integer.valueOf(a.num).compareTo(Integer.valueOf(b.num)));
      Set<Integer> visited = new HashSet<Integer>();
      for (int i = 0; i < m; i++) {
        pq.offer(new Cell(i, 0, heightMap[i][0]));
        pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        visited.add(i * n);
        visited.add(i * n + n - 1);
      }
      for (int j = 1; j < n - 1; j++) {
        pq.offer(new Cell(0, j, heightMap[0][j]));
        pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        visited.add(j);
        visited.add((m - 1) * n + j);
      }
      int max = 0;
      int ans = 0;
      while (!pq.isEmpty()) {
        Cell outCell = pq.poll();
        int r = outCell.row;
        int c = outCell.col;
        int num = outCell.num;
        if (num < max)  ans += max - num;
        else max = num;
        if (r > 0 && !visited.contains((r - 1) * n + c)) {
          pq.offer(new Cell(r - 1, c, heightMap[r - 1][c]));
          visited.add((r - 1) * n + c);
        }
        if (r < m - 1 && !visited.contains((r + 1) * n + c)) {
          pq.offer(new Cell(r + 1, c, heightMap[r + 1][c]));
          visited.add((r + 1) * n + c);
        }
        if (c > 0 && !visited.contains(r * n + c - 1)) {
          pq.offer(new Cell(r, c - 1, heightMap[r][c - 1]));
          visited.add(r * n + c - 1);
        }
        if (c < n - 1 && !visited.contains(r * n + c + 1)) {
          pq.offer(new Cell(r, c + 1, heightMap[r][c + 1]));
          visited.add(r * n + c + 1);
        }

      }
      return ans;
    }
}
