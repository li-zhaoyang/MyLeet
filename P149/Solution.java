import java.util.*;
import java.math.BigDecimal;
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
      if(points == null){
        return 0;
      }
      int l = points.length;
      if(l <= 2){
        return l;
      }

      int  max = 2;
      for(int i = 0 ; i < l; i ++){
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int x0Points = 1;
        int samePoints = 0;
        for(int j = 0 ; j < l ; j ++){
          if(j == i)  continue;
          if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
            samePoints ++;
          }
          if(points[i].x - points[j].x == 0){
            x0Points ++;
          }else{
            double thisSlope = (double)(points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
            if(map.containsKey(thisSlope)){
              map.put(thisSlope, map.get(thisSlope) + 1);
              max = max > map.get(thisSlope)? max: map.get(thisSlope);
            }
            else{
              map.put(thisSlope, 2);
            }
            if(max < map.get(thisSlope) + samePoints) max = map.get(thisSlope) + samePoints;
          }
        }
        if(max < x0Points) max = x0Points;
      }


      return max;

    }
}
