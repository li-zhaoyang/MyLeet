import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0) return new int[0];
      int n = nums.length;

        int index = 0;
        int[] ans = new int[n - k + 1];

        Deque<Integer> maxDQ = new LinkedList<Integer>();
        Deque<Integer> minDQ = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            while (!maxDQ.isEmpty() && maxDQ.peek() < i - k + 1)    maxDQ.poll();
            while (!minDQ.isEmpty() && minDQ.peek() < i - k + 1)    minDQ.poll();
            while (!maxDQ.isEmpty() && nums[maxDQ.peekLast()] < nums[i]) maxDQ.pollLast();
            while (!minDQ.isEmpty() && nums[minDQ.peekLast()] > nums[i]) minDQ.pollLast();
            maxDQ.offer(i);
            minDQ.offer(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[maxDQ.peek()] - nums[minDQ.peek()];
            }
        }
        for (int i = 0; i < n - k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println(ans[n - k]);
        return ans;

    }
}
