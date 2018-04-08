import java.util.*;
class Solution {
  public int calculate(String s) {
    int l;
    if(s==null || (l = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    // Stack<Character> signStack = new Stack<Character>();
    int num = 0;
    char sign = '+';
    boolean inExpo = false;
    int baseNum = 0;
    ArrayList<Integer> expos = new ArrayList<Integer>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ' || s.charAt(i) == ')' || s.charAt(i) == '(') continue;
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9' ) {
        num = num * 10 + s.charAt(i) - '0';
      } else {
        if (s.charAt(i) == '^') {
          expos.add(num);
          inExpo = true;
        }
        else{
          if (inExpo) {
            expos.add(num);
            int expo = getExpoFromList(expos);
            expos = new ArrayList<Integer>();
            pushStack(stack, sign, expo);
            inExpo = false;
          } else {
            pushStack(stack, sign, num);
          }
          sign = s.charAt(i);
        }
        num = 0;
      }
    }
    if (inExpo) {
      expos.add(num);
      int expo = getExpoFromList(expos);
      pushStack(stack, sign, expo);
    } else {
      pushStack(stack, sign, num);
    }
    int sum = 0;
    for (int number: stack) {
      sum += number;
    }
    return sum;
  }

  private int getExpoFromList(ArrayList<Integer> list) {
    int l = list.size();
    int ans = list.get(l - 1);
    for (int i = l - 2; i >= 0; i--) {
      ans = (int) Math.pow(list.get(i), ans);
    }
    return ans;
  }

    private void pushStack(Stack<Integer> stack, char sign, int num) {
      if (sign == '+')  stack.push(num);
      if (sign == '-')  stack.push(-num);
      if (sign == '*')  stack.push(stack.pop() * num);
      if (sign == '^')  stack.push((int) Math.pow(stack.pop(), num));
    }
}
