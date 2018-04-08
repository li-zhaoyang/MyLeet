import java.util.*;
class Solution {
    public int jump(int[] nums) {
      if(nums == null || nums.length < 2) return 0;
      int l = nums.length;
      if(l == 2)  return 1;
      int maxReach = 0, rangeEnd = 0, jump = 0;
      for(int i = 0 ; i < nums.length - 1; i ++){
        maxReach = (i + nums[i]) > maxReach ? (i + nums[i]) : maxReach;
        if(maxReach >= nums.length - 1) return jump + 1;
        if(i == rangeEnd){
          jump += 1;
          rangeEnd = maxReach;
        }
      }
      return jump;
    }

}
