import java.util.*;
class Solution {
    public int candy(int[] ratings) {
      if(ratings == null || ratings.length == 0){
        return 0;
      }
      int l = ratings.length;
      if(l == 1)  return 1;
      int[] greaterThanLeft = new int[l];
      int[] greaterThanright = new int[l];
      for(int i = 0 ; i < l; i ++){
        if(i != 0 && ratings[i] > ratings[i - 1]){
          greaterThanLeft[i] = 1;
        }
        if(i != l - 1 && ratings[i] > ratings[i + 1]){
          greaterThanright[i] = 1;
        }
      }
      for(int i = 0 ; i < l ; i ++){
        if(greaterThanLeft[i] == 0){
          greaterThanLeft[i] = 1;
        }
        else{
          greaterThanLeft[i] = greaterThanLeft[i - 1] + 1;
        }
      }
      for(int i = l -1 ; i >= 0  ; i --){
        if(greaterThanright[i] == 0){
          greaterThanright[i] = 1;
        }
        else{
          greaterThanright[i] = greaterThanright[i + 1] + 1;
        }
      }
      int candies = 0;
      for(int i = 0 ; i < l ; i ++){
        candies += greaterThanLeft[i] > greaterThanright[i]? greaterThanLeft[i]: greaterThanright[i];
      }
      return candies;
  }


}
