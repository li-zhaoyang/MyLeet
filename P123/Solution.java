import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
      if(prices == null || prices.length < 2) return 0;
      int l = prices.length;
      int maxProfit = 0, min = Integer.MAX_VALUE;
      int[] leftMax = new int[l], rightMax = new int[l];
      for(int i = 0 ; i < l ; i ++){
        if(prices[i] > min){
          if(prices[i] - min > maxProfit) maxProfit = prices[i] - min;
        }
        else{
          min = prices[i];
        }
        leftMax[i] = maxProfit;
      }

      int max = Integer.MIN_VALUE;
      maxProfit = 0;

      for(int i = l - 1; i >= 0; i--){
        if(prices[i] < max){
          if(max - prices[i] > maxProfit) maxProfit = max - prices[i];
        }else{
          max = prices[i];
        }
        rightMax[i] = maxProfit;
      }

      maxProfit = 0;

      for(int i = 0 ; i < l ; i ++){
        if(leftMax[i] + rightMax[i] > maxProfit) maxProfit = leftMax[i] + rightMax[i];
      }
      return maxProfit;

    }
}
