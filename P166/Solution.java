import java.util.*;
class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int[] ans = new int[2];
      for(int i = 0, j = numbers.length -1; i < j; ){
        if(numbers[i] + numbers[j] < target){
          i ++;
          continue;
        }
        if(numbers[i] + numbers[j] > target){
          j--;
          continue;
        }
        ans[0] = i + 1;
        ans[1] = j + 1;
        return ans;
      }
      return ans;
    }
}
