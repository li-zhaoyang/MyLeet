import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
      int length = s.length();
      int max = 0;

      boolean lastEnd = false;
      int lastStartIndex = 0;

      for (int i = 0 ; i < length ;i ++  ) {
        if(s.charAt(i) == '('){
          int left = 1;
          int j = i + 1 ;
          for(; j < length; j ++){
            if(s.charAt(j) == '(')  {
              left +=1;
            }
            else{
              left -= 1;
              if(left == 0) {
                if(lastEnd) max = (j - lastStartIndex + 1) > max ? (j - lastStartIndex  + 1) : max;
                else max = (j - i + 1) > max ? (j - i + 1) : max;
                break;
              }
            }
          }
          if(!lastEnd){
            lastEnd = true;
            lastStartIndex = i;
          }
          i = j;
        }else{
          lastEnd = false;
        }
      }

      lastEnd = false;
      lastStartIndex = 0;
      for (int i = 0 ; i < length ;i ++  ) {
        if(s.charAt(length - i - 1) == ')'){
          int right = 1;
          int j = i + 1 ;
          for(; j < length; j ++){
            if(s.charAt(length - j - 1) == ')')  {
              right +=1;
            }
            else{
              right -= 1;
              if(right == 0) {
                if(lastEnd) max = (j - lastStartIndex + 1) > max ? (j - lastStartIndex  + 1) : max;
                else max = (j - i + 1) > max ? (j - i + 1) : max;
                break;
              }
            }
          }
          if(!lastEnd){
            lastEnd = true;
            lastStartIndex = i;
          }
          i = j;
        }
        else{
          lastEnd = false;
        }
      }

      return max;
    }
}
