import java.util.*;
class Solution {
    public String parseTernary(String expression)  {
      String s = expression;
      int l = expression.length();
      Stack<Character> stack = new Stack<Character>();
      for (int i = l - 1; i >= 0; i--){
        if (!stack.isEmpty() && stack.peek() == '?') {
          stack.pop();
          char firstChoice = stack.pop();
          stack.pop();
          char secondChoice = stack.pop();
          if (s.charAt(i) == 'T') stack.push(firstChoice);
          else stack.push(secondChoice);
        } else
          stack.push(s.charAt(i));
      }
      char c = stack.pop();
      System.out.println(c);
      return (new Character(c)).toString();
    }
}
