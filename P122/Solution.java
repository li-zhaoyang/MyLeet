class Solution {
    public int maxProfit(int[] prices) {
      int l = prices.length;
      if(l < 2) return 0;
      int p = 0;
      int min = Integer.MAX_VALUE;
      for(int i = 0; i < l - 1; i ++){
        if(prices[i] < min) {
          min = prices[i];
          continue;
        }
        if(prices[i] > prices[i+1]){
          p += prices[i] - min;
          min = prices[i + 1];
          i++;
        }
      }
      if(prices[l - 1] > min) p += prices[l - 1] - min;
      return p;

    }
}
