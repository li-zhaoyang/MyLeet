import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
      if(tokens == null)  return 0;
      if(tokens.length == 0) return 0;
      Stack<Integer> stack = new Stack<Integer>();
      int operandLeft;
      int operandRight;
      for(int i = 0 ; i < tokens.length; i++){
        if(tokens[i].equals("/") || tokens[i].equals( "-") || tokens[i].equals( "*") || tokens[i].equals( "+")){
          operandRight = stack.pop();
          operandLeft  = stack.pop();
          if(tokens[i].equals("/")) stack.push(operandLeft/operandRight);
          if(tokens[i].equals("+")) stack.push(operandLeft + operandRight);
          if(tokens[i].equals("*")) stack.push(operandLeft * operandRight);
          if(tokens[i].equals("-")) stack.push(operandLeft - operandRight);
        }
        else{
          stack.push(Integer.parseInt(tokens[i]));
        }
      }

      return stack.pop();

    }
}
