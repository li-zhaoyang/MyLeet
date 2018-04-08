import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0) return new int[0];
      int l = nums.length;
      int[] ans = new int[l - k + 1];
      int ansIndex = 0;
      Deque<Integer> deque = new LinkedList<Integer>();
      for (int i = 0; i < l; i ++) {
        while (!deque.isEmpty() && deque.peek() < i - k + 1) {
          deque.poll();
        }
        while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
          deque.pollLast();
        }
        deque.offer(i);
        if (i >= k - 1) {
          ans[ansIndex++] = nums[deque.peek()];
        }
      }
      return ans;

    }
}
