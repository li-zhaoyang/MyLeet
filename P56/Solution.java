import java.util.*;
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
      //if(intervals.size() == 0 || intervals.size() == 1) return intervals;
      // List<Interval> merged = new LinkedList<Interval>();
      intervals.sort(new Comparator<Interval>(){
        @Override
        public int compare(Interval a, Interval b){
          return a.start-b.start;
        }
      });
      // int currentEnd = intervals.get(0).end;
      // int currentIndex = 0;
      // boolean[] take = new boolean[intervals.size()];
      // take[0] = true;
      // for(int i = 1 ; i < take.length; i++){
      //   take[i] = false;
      // }

      for(int i = 1 ; i < intervals.size();){
        int lastEnd = intervals.get(i-1).end, thisEnd = intervals.get(i).end;
        if(intervals.get(i).start <= lastEnd){
          if(lastEnd < thisEnd)  intervals.get(i-1).end = thisEnd;
          intervals.remove(i);
        }
        else{
          //intervals.get(i-1).end = currentEnd;
          //currentEnd = intervals.get(i).end;
          //currentIndex = i;
          //take[i] = true;
          i++;
        }
      }

      // for(int i = 0 ; i < intervals.size(); i++){
      //   if(take[i]) merged.add(new Interval( intervals.get(i).start, intervals.get(i).end ) );
      // }
      return intervals;


    }



}
