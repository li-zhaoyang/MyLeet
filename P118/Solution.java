import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      List<Integer> lastL = null;
      for(int i = 1 ; i <= numRows; i ++){
        List<Integer> thisL = new ArrayList<Integer>();
        for( int j = 0 ; j < i ; j ++){
          thisL.add(0);
        }
        thisL.set(0, 1);
        thisL.set(i - 1, 1) ;
        if( i != 1 && i != 2 ) {
          for(int j = 1 ; j < (i+1)/2 ; j++){
            thisL.set(j, lastL.get(j - 1) + lastL.get(j));
            thisL.set(i - j - 1, thisL.get(j));
          }
        }
        lastL = thisL;
        ans.add(thisL);
      }
      return ans;
    }
}
