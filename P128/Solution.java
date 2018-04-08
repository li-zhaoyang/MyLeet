import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
      Map<Integer, Integer> minMap = new HashMap<Integer, Integer>();
      Map<Integer, Integer> maxMap = new HashMap<Integer, Integer>();
      if(nums == null)  return 0;
      int ans = 0;
      for(int num:nums){
        if(minMap.containsKey(num)) continue;
        if(minMap.containsKey(num - 1) && !minMap.containsKey(num + 1)){
          int thisMin = minMap.get(num - 1);
          if(num - thisMin + 1 > ans ) ans = num - thisMin + 1;
          minMap.put(num, thisMin);
          maxMap.put(num, num);
          maxMap.remove(thisMin);
          maxMap.put(thisMin, num);
        }
        else if(!minMap.containsKey(num - 1) && minMap.containsKey(num + 1)){

          int thisMax = maxMap.get(num + 1);
          if(thisMax - num + 1 > ans) ans = thisMax - num + 1;
          maxMap.put(num, thisMax);
          minMap.put(num, num);
          minMap.remove(thisMax);
          minMap.put(thisMax, num);
        }
        else if(minMap.containsKey(num - 1) && minMap.containsKey(num + 1)){

          int thisMax = maxMap.get(num + 1);
          int thisMin = minMap.get(num - 1);
          if(thisMax - thisMin + 1 > ans) ans = thisMax - thisMin + 1;
          minMap.put(num, thisMin);
          maxMap.put(num, thisMax);
          minMap.remove(thisMax);
          minMap.put(thisMax, thisMin);
          maxMap.remove(thisMin);
          maxMap.put(thisMin, thisMax);

        }
        else{

          if(ans < 1) ans = 1;
          minMap.put(num, num);
          maxMap.put(num, num);
        }
      }
      return ans;
    }
}
