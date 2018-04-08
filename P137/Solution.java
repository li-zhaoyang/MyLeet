import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
      int a = 0;
      int b = 0;
      for(int c:nums){
        int newA = (~a&b&c) | (a&~b&~c);
        b = ( ~a&~b&c)|(~a&b&~c);
        a = newA;
      }
      return a|b;
    }
}
