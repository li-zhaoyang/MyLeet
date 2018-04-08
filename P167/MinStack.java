import java.util.*;
class MinStack {
    private long min;
    private Stack<Integer> stack;
    private Stack<Integer> stackForMin;

    /** initialize your data structure here. */
    public MinStack() {
      stack = new Stack<Integer>();
      stackForMin = new Stack<Integer>();
      min = Long.MAX_VALUE;
    }

    public void push(int x) {
      if(x <= min){
        min = x;
        stackForMin.push(x);
      }
      stack.push(x);
    }

    public void pop() {
      int thisNum = stack.pop();
      if(thisNum == min){
        stackForMin.pop();
        if(stackForMin.empty()){
          min = Long.MAX_VALUE;
        }else{
          min = stackForMin.peek();
        }

      }
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
