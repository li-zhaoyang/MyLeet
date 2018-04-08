import java.util.*;
class Solution {
    public int calculate(String s) {
      Queue<Character> symbolQueue = new LinkedList<Character>();
      Queue<Integer> numQueue = new LinkedList<Integer>();
      int thisNum = 0;
      boolean sign = true;
      int curAns = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') continue;
        else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
          if (symbolQueue.isEmpty()) {
            if (sign) curAns += thisNum;
            else curAns -= thisNum;
            thisNum = 0;
          } else {
            numQueue.offer(thisNum);
            thisNum = 0;
            int head = numQueue.poll();
            while (!numQueue.isEmpty()) {
              char operation = symbolQueue.poll();
              int operand = numQueue.poll();
              if (operation == '*') head *= operand;
              else head /= operand;
            }
            if (sign) curAns += head;
            else curAns -= head;
          }
          if (s.charAt(i) == '+') sign = true;
          else sign = false;
        } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
          numQueue.offer(thisNum);
          thisNum = 0;
          symbolQueue.offer(s.charAt(i));
        } else {
          thisNum = thisNum * 10 + s.charAt(i) - '0';
        }
      }
      if (symbolQueue.isEmpty()) {
        if (sign) curAns += thisNum;
        else curAns -= thisNum;
      } else {
        numQueue.offer(thisNum);
        int head = numQueue.poll();
        while (!numQueue.isEmpty()) {
          char operation = symbolQueue.poll();
          int operand = numQueue.poll();
          if (operation == '*') head *= operand;
          else head /= operand;
        }
        if (sign) curAns += head;
        else curAns -= head;
      }
      return curAns;
    }
}
