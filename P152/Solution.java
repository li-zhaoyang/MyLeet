class Solution {
    public int maxProduct(int[] nums) {
      if(nums == null)  return Integer.MIN_VALUE;
      int l = nums.length;
      if(l == 0)  return Integer.MIN_VALUE;
      if(l == 1)  return nums[0];
      boolean minus = false;
      // int product = 1;
      return helperNoZero(nums, 0, l);
    }

    private int helperNoZero(int[] nums, int startIndex, int endIndex){
      // int firstNegPosition = endIndex, lastNegPosition = startIndex - 1;
      boolean foundFirstNeg = false, foundLastNeg = false;
      int productBeforeFirstNeg = 1, productAfterFirstNeg = 1, productBeforeLastNeg = 1, productAfterLastNeg = 1;
      int allProLeft = 1, allProRight = 1, numNegLeft = 0, numNegRight = 0, totalNumLeft = 0, totalNumRight = 0;
      boolean  hasZero = false;
      int maxProduct = Integer.MIN_VALUE;
      for(int i = startIndex; i < endIndex ; i++){
        if(nums[i] < 0 ) {
          numNegLeft += 1;
          if(!foundFirstNeg){
            // firstNegPosition = i;
            foundFirstNeg = true;
          }else{
            productAfterFirstNeg *= nums[i];
          }
          allProLeft *= nums[i];
          totalNumLeft +=1;
        }else if(nums[i] >0){
          if(!foundFirstNeg){
            productBeforeFirstNeg *= nums[i];
          }else{
            productAfterFirstNeg *= nums[i];
          }
          allProLeft *= nums[i];
          totalNumLeft +=1;
        }else{
          hasZero = true;
          if(totalNumLeft != 0){
            if(totalNumLeft == 1 && numNegLeft == 1){
              if(maxProduct < 0)  maxProduct = 0;
            }else{
              if(!foundFirstNeg || numNegLeft%2 == 0){
                if(maxProduct < allProLeft) maxProduct = allProLeft;
              }
              else{
                if(productBeforeFirstNeg > maxProduct) maxProduct = productBeforeFirstNeg;
                if(productAfterFirstNeg > maxProduct ) maxProduct = productAfterFirstNeg;
              }
            }

          }
          productBeforeFirstNeg = 1;
          productAfterFirstNeg = 1;
          numNegLeft = 0 ;
          allProLeft = 1;
          foundFirstNeg = false;
          totalNumLeft = 0;
        }
        if(nums[endIndex - i - 1] < 0 ) {
          numNegRight += 1;
          if(!foundLastNeg){
            // lastNegPosition = endIndex - i - 1;
            foundLastNeg = true;
          }else{
            productBeforeLastNeg *= nums[endIndex - i - 1];
          }
          allProRight *= nums[endIndex - i - 1];
          totalNumRight += 1;
        }else if(nums[endIndex - i - 1] > 0){
          if(!foundLastNeg){
            productAfterLastNeg *= nums[endIndex - i - 1];
          }else{
            productBeforeLastNeg *= nums[endIndex - i - 1];
          }
          allProRight *= nums[endIndex - i - 1];
          totalNumRight += 1;
        }else{
          if(totalNumRight !=0){
            if(numNegRight == 1 && totalNumRight == 1){
              if(maxProduct < 0)  maxProduct = 0;
            }else{
              if(!foundLastNeg || numNegRight%2 == 0){
                if(maxProduct < allProRight) maxProduct = allProRight;
              }
              else{
                if(productBeforeLastNeg > maxProduct) maxProduct = productBeforeLastNeg;
                if(productAfterLastNeg > maxProduct ) maxProduct = productAfterLastNeg;
              }
            }
          }
          productBeforeLastNeg = 1;
          productAfterLastNeg = 1;
          numNegRight = 0;
          allProRight = 1;
          foundLastNeg = false;
          totalNumRight = 0;
        }
      }
      if(nums[endIndex - 1] != 0){
        if(totalNumLeft != 0){
          if(totalNumLeft == 1 && numNegLeft == 1){
            if(maxProduct < 0)  maxProduct = 0;
          }else{
            if(!foundFirstNeg || numNegLeft%2 == 0){
              if(maxProduct < allProLeft) maxProduct = allProLeft;
            }
            else{
              if(productBeforeFirstNeg > maxProduct) maxProduct = productBeforeFirstNeg;
              if(productAfterFirstNeg > maxProduct ) maxProduct = productAfterFirstNeg;
            }
          }
        }
      }
      if(nums[startIndex] != 0){
        if(totalNumRight !=0){
          if(numNegRight == 1 && totalNumRight == 1){
            if(maxProduct < 0)  maxProduct = 0;
          }else{
            if(!foundLastNeg || numNegRight%2 == 0){
              if(maxProduct < allProRight) maxProduct = allProRight;
            }
            else{
              if(productBeforeLastNeg > maxProduct) maxProduct = productBeforeLastNeg;
              if(productAfterLastNeg > maxProduct ) maxProduct = productAfterLastNeg;
            }
          }
        }
      }
      return maxProduct;
    }
}
