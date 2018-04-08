import java.util.*;
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        return merge(buildings, 0, buildings.length-1);
    }

    private LinkedList<int[]> merge(int[][] buildings, int lo, int hi) {
        LinkedList<int[]> res = new LinkedList<>();
        if (lo > hi)  return res;
        if (lo == hi) {
          res.add(new int[]{buildings[lo][0], buildings[lo][2]});
          res.add(new int[]{buildings[lo][1], 0});
          return res;
        }
        int mid = lo + (hi - lo) / 2;
        LinkedList<int[]> leftAns = merge(buildings, lo, mid);
        LinkedList<int[]> rightAns = merge(buildings, mid + 1, hi);
        int x = -1, heightLeft = 0, heightRight = 0;
        while (!leftAns.isEmpty() || !rightAns.isEmpty()) {
          long x1 = leftAns.isEmpty() ? Long.MAX_VALUE : leftAns.peekFirst()[0];
          long x2 = rightAns.isEmpty() ? Long.MAX_VALUE : rightAns.peekFirst()[0];
          if (x1 < x2) {
            x = (int) x1;
            heightLeft = leftAns.pollFirst()[1];
          }
          if (x1 > x2) {
            x = (int) x2;
            heightRight = rightAns.pollFirst()[1];
          }
          if (x1 == x2) {
            x = (int) x1;
            heightLeft = leftAns.pollFirst()[1];
            heightRight = rightAns.pollFirst()[1];
          }
          int height = Math.max(heightLeft, heightRight);
          if (res.isEmpty() || height != res.peekLast()[1]) res.add(new int[]{x, height});
        }
        return res;
    }
}
