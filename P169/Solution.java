import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
      int goal = nums.length / 2 + 1;
      if(goal == 1) return nums[0];
      HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
      for(int num:nums){
        if(!myMap.containsKey(num)){
          myMap.put(num, 0);
        }
        int thisTimes = myMap.get(num) + 1 ;
        if(thisTimes == goal) return num;
        myMap.put(num, thisTimes);
      }

      return 0;

    }
}
