import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) {
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
      int m = matrix.length, n = matrix[0].length, max = 0;
      int[] heights = new int[n];
      for(int i = 0 ; i < m ; i ++){
        for(int j = 0 ; j < n ; j ++){
          if(matrix[i][j] == '1') heights[j] ++;
          else heights[j] = 0;
        }
        int thisMax = largestRectangleArea(heights);
        if(thisMax > max) max = thisMax;
      }
      return max;
    }

    private int largestRectangleArea(int[] heights) {
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
