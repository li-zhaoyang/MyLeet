class Solution {
    public int maximumGap(int[] nums) {
      int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      int l = nums.length;
      if(l < 2) return 0;
      for(int num:nums){
        if(num < min) min = num;
        if(num > max) max = num;
      }
      double avrGap = ((double)( max - min ))/((double)( l - 1 ));
      System.out.println(avrGap);
      int gap = (int) Math.ceil( avrGap );
      if(gap == 0)  return 0;
      int[] minOfBuckets = new int[ l  ];
      int[] maxOfBuckets = new int[ l ];
      for(int i = 0 ; i < l  ; i++){
        minOfBuckets[i] = Integer.MAX_VALUE;
        maxOfBuckets[i] = Integer.MIN_VALUE;
      }
      int index;
      for(int num : nums){
        index = (num - min)/gap;
        if(num < minOfBuckets[index] )  minOfBuckets[index] = num;
        if(num > maxOfBuckets[index] )  maxOfBuckets[index] = num;
      }
      int lastMax = Integer.MAX_VALUE, maxGap = gap;
      boolean start = true;
      for(int i = 0 ; i < l ; i++){
        if(minOfBuckets[i] == Integer.MAX_VALUE && maxOfBuckets[i] == Integer.MIN_VALUE){
          continue;
        }
        if(!start){
          if((minOfBuckets[i] - lastMax) > maxGap) maxGap = minOfBuckets[i] - lastMax;
        }else{
          start = false;
        }
        lastMax = maxOfBuckets[i];
      }
      return maxGap;
    }
}
