/*
    Contest 124
    Feb 16, 2019
*/
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> q = new ArrayDeque();
        Set<Integer> visited = new HashSet();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) count++;
                if (grid[i][j] == 2) {
                    q.offer(i * n + j);
                    visited.add(i * n + j);
                }
            }
        }
        int step = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                int x = cur / n;
                int y = cur % n;
                int[] dx = {0, -1, 0, 1};
                int[] dy = {1, 0, -1, 0};
                for (int j = 0; j < 4; j++) {
                    int xx = x + dx[j];
                    int yy = y + dy[j];
                    if (xx >= m || xx < 0 || yy >= n || yy < 0 || visited.contains(xx * n + yy) || grid[xx][yy] != 1) continue;
                    q.offer(xx * n + yy);
                    visited.add(xx * n + yy);
                }
            }
            step++;
        }
        return visited.size() == count ? Math.max(step, 0) : -1;
    }
}