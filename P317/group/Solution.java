import java.util.*;
public class Solution {
    public int shortestDistance(int[][] grid) {
      if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)  return -1;
       int m = grid.length;
       int n = grid[0].length;
       int[][] allDisGrid = new int[m][n];
       for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
           if(grid[i][j] == 1){
             Queue<Integer> queue = new LinkedList<Integer>();
             int[][] thisDisGrid = new int[m][n];
             deepCopyWithDis(grid, thisDisGrid, i, j);
             queue.add(i * n + j);
             while (!queue.isEmpty()) {
               int posInt = queue.poll();
               modifyAround(thisDisGrid, posInt / n, posInt % n, thisDisGrid[posInt / n][posInt % n], queue);
             }
             addToLeft(allDisGrid, thisDisGrid);
           }
         }
       }
       int minI = -1, minJ = -1, minDis = Integer.MAX_VALUE;

       for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
           if (allDisGrid[i][j] < minDis) {
             minDis = allDisGrid[i][j];
             minI = i;
             minJ = j;
           }
         }
       }
       if(minI == -1) return -1;
       return minDis;
    }
    private void addToLeft(int[][] allDisGrid, int[][] thisDisGrid) {
      int m = allDisGrid.length;
      int n = allDisGrid[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if(allDisGrid[i][j] == Integer.MAX_VALUE || thisDisGrid == Integer.MAX_VALUE){
            allDisGrid[i][j] = Integer.MAX_VALUE;
          } else {
            allDisGrid[i][j] += thisDisGrid[i][j];
          }
        }
      }
    }
    private void deepCopyWithDis(int[][] grid, int[][] thisDisGrid, int i0, int j0) {
      int m = grid.length;
      int n = grid[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i == i0 && j == j0) {
            continue;
          }
          if (grid[i][j] == 1 || grid[i][j] == 2) {
            thisDisGrid = -1;
          } else {
            thisDisGrid = Integer.MAX_VALUE;
          }
        }
      }
    }

    private void modifyAround(int[][] rooms, int i, int j, int thisDis, Queue<Integer> queue) {
      int m = rooms.length;
      int n = rooms[0].length;
      if (i > 0 && rooms[i - 1][j] != -1) {
        modifyThis(i - 1, j, rooms, queue, thisDis);
      }
      if (i < m - 1 && rooms[i + 1][j] != -1) {
        modifyThis(i + 1, j, rooms, queue, thisDis);
      }
      if (j > 0 && rooms[i][j - 1] != -1) {
        modifyThis(i, j - 1, rooms, queue, thisDis);
      }
      if (j < n - 1 && rooms[i][j + 1] != -1) {
        modifyThis(i, j + 1, rooms, queue, thisDis);
      }
    }

    private void modifyThis(int i, int j, int[][] rooms, Queue<Integer> queue, int thisDis) {
      if (rooms[i][j] > thisDis + 1) {
        rooms[i][j] = thisDis + 1;
        queue.add(i * n + j);
      }
    }
  }
