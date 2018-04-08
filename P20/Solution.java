import java.util.*;
class Solution {
    public boolean isValid(String s) {
      Stack stack = new Stack();
      for(int i=0; i<s.length(); i++){
        if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '('){
          stack.push(s.charAt(i));

        }
        else{
          if(stack.empty()) return false;
          char a = (char)stack.pop();
          char b = s.charAt(i);
          if( ( a == '(' && b != ')' )||( a == '[' && b != ']' )||( a == '{' && b != '}' ) ){
            return false;
          }
        }
      }
      if(!stack.empty())  return false;
      return true;
    }
}
