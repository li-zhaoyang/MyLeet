import java.util.*;
class Solution {
    public int calculate(String s) {
      if (s == null || s.length() == 0) return 0;
      Stack<Character> symbolStack = new Stack<Character>();
      Stack<Integer> numStack = new Stack<Integer>();
      int currentAns = 0,  thisNum = 0;
      boolean justPush =true;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') continue;
        else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '(') {
          if (!justPush) {
            // System.out.println(thisNum);
            numStack.push(thisNum);
            justPush = true;
            thisNum = 0;
          }
          symbolStack.push(s.charAt(i));
        }
        else if (s.charAt(i) == ')') {
          if (!justPush) {
            // System.out.println(thisNum);
            numStack.push(thisNum);
            justPush = true;
            thisNum = 0;
          }
          int inThisBracket = 0;
          while (true) {
            int thisOperand = numStack.pop();
            char thisSymbol = symbolStack.pop();
            if (thisSymbol == '+' || thisSymbol == '(') inThisBracket += thisOperand;
            if (thisSymbol == '-') inThisBracket -= thisOperand;
            if (thisSymbol == '(') break;
          }
          numStack.push(inThisBracket);
        }
        else {
          thisNum = thisNum * 10  + s.charAt(i) - '0';
          justPush = false;
        }
      }
      if (!justPush) {
        // System.out.println(thisNum);
        numStack.push(thisNum);
        justPush = true;
      }
      while (true) {
        int thisOperand = numStack.pop();
        if (symbolStack.isEmpty()) {
          currentAns += thisOperand;
          break;
        }
        char thisSymbol = symbolStack.pop();
        if (thisSymbol == '+')  currentAns += thisOperand;
        if (thisSymbol == '-') currentAns -= thisOperand;
      }

      return currentAns;
    }
}
