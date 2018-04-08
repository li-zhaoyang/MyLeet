import java.util.*;
class Solution {
    public int candy(int[] ratings) {
      if(ratings == null || ratings.length == 0){
        return 0;
      }
      int l = ratings.length;
      if(l == 1)  return 1;
      int ans = 0, downStartIndex = 0, flatStartIndex = 0, sameTimeDuringDown = 0;
      boolean down = false, flatBeforeDown = false;
      int thisCandy = 1;
      for(int i = 0; i < l - 1; i++){
        if(ratings[i] < ratings[i + 1]){
          if(down){
            down = false;
            ans += (i - downStartIndex + 1) * (i - downStartIndex + 2)/2;
            if(flatBeforeDown){
              flatBeforeDown = false;
              if(thisCandy > i - downStartIndex + 1 - sameTimeDuringDown){
                ans -= (thisCandy - (i - downStartIndex + 1 - sameTimeDuringDown)) * (downStartIndex - flatStartIndex - 1);
              }

              // ans -= (thisCandy - (i - downStartIndex - sameTimeDuringDown)) * (downStartIndex - flatStartIndex);
            }
            thisCandy = 2;
          }else{
            ans += thisCandy;
            thisCandy += 1;
          }
        }
        else if(ratings[i] == ratings[i + 1]){
          if(down) {
            ans -= i - downStartIndex + 1;
            sameTimeDuringDown += 1;
          }
          else{
            ans += thisCandy;
            if(i == 0 || ratings[i] != ratings[i - 1]){
              flatBeforeDown = true;
              flatStartIndex = i;
            }
          }

        }
        else{
          if(! down){
            down = true;
            downStartIndex = i;
            sameTimeDuringDown = 0;
          }
        }
      }

      if(down){
        // down = false;
        ans += (l - downStartIndex + 1) * (l - downStartIndex)/2;

        if(flatBeforeDown){
          flatBeforeDown = false;
          if(thisCandy > l - downStartIndex - sameTimeDuringDown){
            ans -= (thisCandy - (l - downStartIndex - sameTimeDuringDown)) * (downStartIndex - flatStartIndex - 1);
          }
          // ans -= (thisCandy - (i - downStartIndex - sameTimeDuringDown)) * (downStartIndex - flatStartIndex);
        }else{
          if(thisCandy > l - downStartIndex - sameTimeDuringDown){
            ans += thisCandy - ( l - downStartIndex - sameTimeDuringDown);
          }
        }
      }
      else{
        ans += thisCandy;
        if(flatBeforeDown){
          ans -= (l - flatStartIndex - 1)*(thisCandy - 1);
        }
      }
    return ans;
  }


}
