import java.util.*;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      if(triangle.size() == 0)  return 0;
      return min(triangle, 0, 0);
    }
    private int min(List<List<Integer>> triangle, int indexOfLine, int index ){
      int minS = Integer.MAX_VALUE;
      List<Integer> thisLine = triangle.get(indexOfLine);
      int thisLineSize = thisLine.size();
      if(index < 0 || index >= thisLineSize)  return minS;
      if(indexOfLine == triangle.size() - 1)  return thisLine.get(index);
      int minNext = 0;
      int nextLineSize = triangle.get(indexOfLine + 1).size();
      if(index >=0 && index < nextLineSize){
        minNext = min(triangle, indexOfLine + 1, index);
        if(minNext == Integer.MAX_VALUE){
          minS = minS < Integer.MAX_VALUE ? minS:Integer.MAX_VALUE;
        }
        else{
          minS = minS < (thisLine.get(index) + minNext) ? minS : (thisLine.get(index) + minNext);
        }
      }
      if(index + 1>=0 && index + 1 < nextLineSize){
        minNext = min(triangle, indexOfLine + 1, index + 1);
        if(minNext == Integer.MAX_VALUE){
          minS = minS < Integer.MAX_VALUE ? minS:Integer.MAX_VALUE;
        }
        else{
          minS = minS < (thisLine.get(index ) + minNext) ? minS : (thisLine.get(index) + minNext);
        }
      }

      return minS;

    }
}
