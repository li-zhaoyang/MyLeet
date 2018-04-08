import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
      if(heights == null || heights.length == 0)  return 0;
      return helpFind(heights, 0, heights.length - 1);
    }
    private int helpFind(int[] heights, int start, int end){
      if(start == end)  return heights[start];
      int min = Integer.MAX_VALUE, minIndex = -1, i = start, maxSize = Integer.MIN_VALUE;
      while(i <= end){
        if(heights[i] < min){
          minIndex = i;
          min = heights[i];
        }
        i++;
      }
      if(minIndex != start){
        int maxLeft = helpFind(heights, start, minIndex - 1);
        if(maxLeft > maxSize) maxSize = maxLeft;
      }
      if(minIndex != end){
        int maxRight = helpFind(heights, minIndex + 1, end);
        if(maxRight > maxSize)  maxSize = maxRight;
      }
      int thisMaxOnSmallest = (end - start + 1)*min;
      if(thisMaxOnSmallest  > maxSize) maxSize = thisMaxOnSmallest;

      return maxSize;
    }
}
