
import java.util.*;
class MyStack {
  Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
      queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      Queue<Integer> newQueue = new LinkedList<Integer>();
      while(true) {
        int thisNum = queue.poll();
        if (queue.isEmpty()){
          queue = newQueue;
          return thisNum;
        }
        newQueue.offer(thisNum);
      }
    }

    /** Get the top element. */
    public int top() {
      Queue<Integer> newQueue = new LinkedList<Integer>();
      while(true) {
        int thisNum = queue.poll();
        newQueue.offer(thisNum);
        if (queue.isEmpty()){
          queue = newQueue;
          return thisNum;
        }
      }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
