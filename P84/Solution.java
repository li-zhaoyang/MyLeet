import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
      if(heights == null || heights.length == 0)  return 0;
      int max = 0;
      Stack<Integer> thisStack = new Stack<Integer>();
      for(int i = 0 ; i < heights.length; i++){
        while(!thisStack.empty() && heights[thisStack.peek()] > heights[i]){
          int thisIdx = thisStack.pop();
          int thisArea = 0;
          if(thisStack.empty()){
            thisArea = i * heights[thisIdx];
          }
          else thisArea = (i - thisStack.peek() - 1) * heights[thisIdx];
          if(max < thisArea)  max = thisArea;
        }
        thisStack.push(i);
      }
      while(!thisStack.empty()){
        int thisIdx = thisStack.pop();
        int thisArea = 0;
        if(thisStack.empty()){
          thisArea = heights.length * heights[thisIdx];
        }else{
          thisArea = (heights.length - thisStack.peek() - 1) * heights[thisIdx];
        }
        if(max < thisArea)  max = thisArea;
      }
      return max;
    }
}
