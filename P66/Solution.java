class Solution {
    public int[] plusOne(int[] digits) {
      if(digits[0] == 0){
        int[] ans = {1};
        return ans;
      }
      int addOn = 1;
      int thisSum = 0;
      for(int i = digits.length-1 ; i >= 0; i--){
        thisSum = digits[i] + addOn;
        if(thisSum > 9){
          digits[i] = thisSum % 10;
          addOn = 1;
        }else {
          digits[i] = thisSum;
          addOn = 0;
        }
      }
      if(addOn == 0) return digits;
      int[] ans = new int[digits.length+1];
      ans[0] = 1;
      for(int i = 1; i < ans.length; i++){
        ans[i] = digits[i - 1];
      }
      return ans;

    }
}
