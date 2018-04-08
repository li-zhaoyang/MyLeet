import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
  public int threeSumClosest(int[] nums, int target){
    Arrays.sort(nums);
    for(int dis = 0;dis<=Integer.MAX_VALUE;dis++){
      //List<List<Integer>> res = new LinkedList<>();
      for(int i=0;i<nums.length-2;i++){
        if(i==0||(i>0&&nums[i]!=nums[i-1])){
          int lowS=i+1, lowL=i+1, highS=nums.length-1, highL=nums.length-1, sumS=target-nums[i]-dis, sumL = target - nums[i] + dis;
          while(lowS<highS){
            if(nums[lowS]+nums[highS]==sumS){
              return nums[lowS]+nums[highS] +nums[i];
            }else if(nums[lowS]+nums[highS]<sumS )  lowS++;
            else highS--;
          }
          while(lowL<highL){
            if(nums[lowL]+nums[highL]==sumL){
              return nums[lowL]+nums[highL] +nums[i];
            }else if(nums[lowL]+nums[highL]<sumL ) lowL++;
            else highL--;
          }
        }
      }
    }
  return 0;
  }
}
