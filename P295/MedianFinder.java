import java.util.*;
class MedianFinder {
  PriorityQueue<Long> smallPQ;
  PriorityQueue<Integer> bigPQ;
  boolean atBig;
  boolean initial;
  double mid;
    /** initialize your data structure here. */
    public MedianFinder() {
      smallPQ = new PriorityQueue<Long>();
      bigPQ = new PriorityQueue<Integer>();
      atBig = false;
      initial = true;
    }

    public void addNum(int num) {
      if (initial)  {
        mid = num;
        bigPQ.add(num);
        atBig = true;
        initial = false;
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
          mid = (float) (mid + (long) (Long.MAX_VALUE - smallPQ.peek())) / 2;
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
