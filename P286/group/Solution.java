import java.util.*;
public class Solution {
    public void wallsAndGates(int[][] rooms) {

       int m = rooms.length;
       int n = rooms[0].length;
       for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
           if(rooms[i][j] == 0){
             Queue<Integer> queue = new LinkedList<Integer>();
             queue.add(i * n + j);
             while (!queue.isEmpty()) {
               int posInt = queue.poll();
               modifyAround(rooms, posInt / n, posInt % n, rooms[posInt / n][posInt % n], queue);
             }
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
