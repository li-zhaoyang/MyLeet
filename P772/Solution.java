import java.util.*;
class Solution {
  public int calculate(String s) {

    //check validness
    Boolean lastIsDigit = false;
    for (char c: s.toCharArray()) {
      if (c == ' ') continue;
      else if (Character.isDigit(c)) {
        if (lastIsDigit) {
          System.out.println("Error");
          return ;
        } else {
          lastIsDigit = true;
        }
      } else {
        lastIsDigit = false;
      }
    }
    int l;
    if(s==null || (l = s.length())==0) return 0;
    // s = "(" + s + ")";
    Stack<Stack<Integer>> stackOfStacks = new Stack<Stack<Integer>>();
    Stack<Character> signStack = new Stack<Character>();
    int num = 0;
    char sign = '+';
    Stack stack = new Stack<Integer>();
    Boolean usedNum = false;
    signStack.push(sign);
    // stackOfStacks.push(stack);
    for (int i = 0; i < l; i++) {
      if (s.charAt(i) == ' ')  continue;
      if (s.charAt(i) =='(') {
        stackOfStacks.push(stack);
        signStack.push(sign);
        stack = new Stack<Integer>();
        sign = '+';
        num = 0;
        continue;
      }
      if (s.charAt(i) == ')') {
        if (!usedNum) pushStack(sign, num, stack);
        num = calculateStack(stack);
        stack = stackOfStacks.pop();
        sign = signStack.pop();
        // System.out.println(num);
        pushStack(sign, num, stack);
        usedNum = true;
      }
      if(Character.isDigit(s.charAt(i))){
           num = num * 10 + s.charAt(i) - '0';
           usedNum = false;
      }
      if (!Character.isDigit(s.charAt(i)) || i == l - 1) {
        if (!usedNum) pushStack(sign, num, stack);
        sign = s.charAt(i);
        num = 0;
      }
    }
    return calculateStack(stack);
  }

  private void pushStack(char sign, int num, Stack<Integer> stack) {
    if(sign=='-'){
        stack.push(-num);
    }
    if(sign=='+'){
        stack.push(num);
    }
    if(sign=='*'){
        stack.push(stack.pop()*num);
    }
  }

  private int calculateStack(Stack<Integer> stack) {
    int ans = 0;
    for(int i:stack){
        ans += i;
    }
    return ans;
  }
}
