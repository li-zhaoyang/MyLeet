import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
      List<List<Integer>> fourNums = new LinkedList();
      for(int lowL = 0; lowL < nums.length-3 ; lowL++){
        if(lowL == 0 || (lowL > 0 && nums[lowL]!=nums[lowL-1])){
          for(int highL = lowL+1; highL < nums.length-2; highL++){
            if(highL == lowL+1 || ( highL > lowL + 1 && nums[highL] != nums[highL-1] )){
              int lowR = highL+1, highR = nums.length-1, sum = target - nums[lowL] - nums[highL];
              while(lowR<highR){
                if(nums[lowR] + nums[highR] == sum){
                  fourNums.add(Arrays.asList(nums[lowL], nums[highL], nums[lowR], nums[highR]));
                  while(lowR < highR && nums[lowR]==nums[lowR+1]) lowR++;
                  while(lowR < highR && nums[highR]==nums[highR-1]) highR--;
                  lowR++;
                  highR--;
                }
                else if(nums[lowR] + nums[highR] < sum){
                  lowR++;
                }
                else{
                  highR--;
                }
              }
            }
          }





        }


      }
      return fourNums;

    }
}
