import java.util.*;
class Solution {
    public int trap(int[] height) {
      if(height == null || height.length < 3 )  return 0;
      return betweenConvexes(height, 0, height.length - 1);
    }

    private int betweenConvexes(int[] height, int start, int end){
      if(end - start < 2)  return 0;
      int min = height[start] < height[end] ? height[start] : height[end];
      int deduct = 0, max = 0, maxIndex = -1;
      for(int i = start + 1 ; i < end; i ++){
        if(height[i] > max ) {
          max = height[i];
          maxIndex = i;
        }
        if(height[i] > min) deduct += min;
        else deduct += height[i] ;
      }
      if(maxIndex != -1 && max > min)  return betweenConvexes(height, start, maxIndex) + betweenConvexes(height, maxIndex, end);
      return min * (end - start - 1) - deduct;
    }
}
