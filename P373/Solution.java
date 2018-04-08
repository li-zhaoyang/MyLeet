import java.util.*;
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<int[]> ans = new ArrayList<int[]>();
      if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
        return ans;
      int m = nums1.length, n = nums2.length;
      if (k > m * n ) k = m * n;
      PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
      for (int i = 0; i < n; i++) {
        pq.offer(new int[]{0, i});
      }
      for (int i = 0; i < k; i++) {
        int[] thisAns = pq.poll();
        ans.add(new int[]{nums1[thisAns[0]], nums2[thisAns[1]]});
        if (i == k - 1) break;
        if (thisAns[0] < m - 1) pq.offer(new int[]{thisAns[0] + 1, thisAns[1]});
      }
      return ans;
    }
}
