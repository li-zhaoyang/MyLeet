import java.util.*;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      int l = intervals.size();
      if(l == 0) {
        intervals.add(newInterval);
        return intervals;
      }
      int leftItvIndex = 0, rightItvIndex = 0;
      if(newInterval.start < intervals.get(0).start)  leftItvIndex = -1;
      else  leftItvIndex = findLeftStartIndex(intervals, 0, l - 1, newInterval.start );
      if(newInterval.end < intervals.get(0).start)  rightItvIndex = -1;
      else rightItvIndex = findLeftStartIndex(intervals, 0, l - 1, newInterval.end);

      List<Interval> toAdd = new ArrayList<Interval>();
      boolean leftOverLap = true;
      if(leftItvIndex != -1)  {
        if(intervals.get(leftItvIndex).end >= newInterval.start) newInterval.start = intervals.get(leftItvIndex).start;
        else leftOverLap = false;
      }

      if(!leftOverLap) toAdd.add(intervals.get(leftItvIndex));

      if(rightItvIndex != -1){
        newInterval.end = newInterval.end > intervals.get(rightItvIndex).end ? newInterval.end : intervals.get(rightItvIndex).end;
      }

      toAdd.add(newInterval);

      if(leftItvIndex == -1)  leftItvIndex = 0;
      for(int i = leftItvIndex; i <= rightItvIndex; i ++ ){
        intervals.remove(leftItvIndex);
      }

      intervals.addAll(leftItvIndex, toAdd);

      return intervals;
    }


    private int findLeftStartIndex(List<Interval> intervals, int start, int end, int goal){
      if(start == end || start + 1 == end) return intervals.get(end).start <= goal ? end : start;
      int mid = start + (end - start)/2;
      int midItvStart = intervals.get(mid).start;
      if(midItvStart < goal)  return findLeftStartIndex(intervals, mid , end, goal );
      if(midItvStart > goal)  return findLeftStartIndex(intervals, start, mid - 1, goal);
      return mid;
    }

}
