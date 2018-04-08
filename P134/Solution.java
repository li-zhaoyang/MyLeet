import java.util.*;
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      if(gas == null) return -1;
      int N = gas.length;
      if(N == 0)  return -1;
      int start = 0;
      int endsAt = 0;
      int remain = 0;
      for(int i = 0 ; i < N*2 ; i++){
        remain += gas[i%N] - cost[i%N];
        if(remain < 0){
          start = i+1;
          remain = 0;
        }
        if(start >= N)  return -1;
        if( i == start + N -1)  return start;
      }
      return start;
    }
}
