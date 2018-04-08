import java.util.*;
class Solution {
  class UpDown {
    int up;
    int down;
    public double value() {
      return (double) up / (double) down;
    }
    public UpDown(int u, int d) {
      up = u;
      down = d;
    }
  }
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
      int k = K;
      int n = A.length;
      PriorityQueue<UpDown> pq = new PriorityQueue<UpDown>((a, b) -> Double.valueOf(b.value()).compareTo(a.value()));
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          UpDown thisUd = new UpDown(A[i], A[j]);
          if (pq.size() == k && thisUd.value() > pq.peek().value())  continue;
          pq.offer(thisUd);
          if (pq.size() > k)  pq.poll();
        }
      }
      UpDown ud = pq.poll();
      System.out.println(ud.up+ " " + ud.down);
      return new int[]{ud.up, ud.down};
    }
}
