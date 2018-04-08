import java.util.*;
class Solution {
  PriorityQueue<Long> smallPQ;
  PriorityQueue<Integer> bigPQ;
  boolean atBig;
  double mid;
    /** initialize your data structure here. */


    public void addNum(int num) {
      if (mid == 0)  {
        mid = num;
        bigPQ.add(num);
        atBig = true;
        return ;
      }
      if (num >= mid) {
        if (atBig) {
          smallPQ.add((long) (Long.MAX_VALUE - bigPQ.poll()));
          bigPQ.add(num);
          mid = (float) (mid + bigPQ.peek()) / 2;
          atBig = false;
        } else {
          // smallPQ.add((long) (Long.MAX_VALUE - bigPQ.poll()));
          bigPQ.add(num);
          mid = bigPQ.peek();
          atBig = true;
        }
      } else {
        if (atBig) {
          smallPQ.add((long) (Long.MAX_VALUE - num));
          mid = (float) (mid + (long) (Long.MAX_VALUE - smallPQ.peek()));
          atBig = false;
        } else {
          smallPQ.add((long) (Long.MAX_VALUE - num));
          bigPQ.add((int) (Long.MAX_VALUE - smallPQ.poll()));
          mid = bigPQ.peek();
          atBig = true;
        }
      }
    }

    public double findMedian() {
      return mid;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
