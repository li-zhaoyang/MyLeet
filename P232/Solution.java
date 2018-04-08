import java.util.*;

 class Solution {
     public boolean isPowerOfTwo(int n) {
       // System.out.println(1 << 31);
       if (n <= 0)  return false;
       if (n == 1)  return true;
       while (true) {
         if (n % 2 == 1)  return n == 1;
         n = n >> 1;
       }
     }
 }
