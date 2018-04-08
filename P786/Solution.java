import java.util.*;
class Solution {

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
      int k = K;
      int n = A.length;
      PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> A[a[0]] * A[b[1]] - A[b[0]] * A[a[1]]);
      for (int i = 0; i < n - 1; i++) {
        pq.offer(new int[]{i, n - 1});
      }
      for (int i = 0; i < k - 1; i++) {
        int[] thisOut = pq.poll();
        if (thisOut[1] - 1 > thisOut[0]) {
          thisOut[1]--;
          pq.offer(thisOut);
        }
      }
      int[] thisOut = pq.peek();
      System.out.println(A[thisOut[0]] + " " + A[thisOut[1]]);
      return new int[]{A[thisOut[0]], A[thisOut[1]]};
    }
}
