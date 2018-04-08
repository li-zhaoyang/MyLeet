import java.util.*;
class Solution {
    public List<Integer> getRow(int rowIndex) {
      int[] thisRowA = new int[rowIndex + 1];
      List<Integer> ans = new ArrayList<Integer>();
      thisRowA[0] = 1;
      for( int i = 1 ; i <= rowIndex; i++){
        for(int j = i; j > 0 ; j --){
          thisRowA[j] += thisRowA[j-1];
        }
      }
      for(int i = 0 ; i < rowIndex + 1; i ++){
        ans.add(thisRowA[i]);
      }
      return ans;
    }
}
