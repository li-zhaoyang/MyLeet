import java.util.*;
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
      int l1 = nums1.length;
      int l2 = nums2.length;
      int[] ans = new int[k];
      for (int i = Math.max(0, k - l2); i <= k && i <= l1; ++i) {
        int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
        if (greater(candidate, 0, ans, 0)) ans = candidate;
      }
      return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
      int[] ans = new int[k];
      for (int i = 0, j = 0, r = 0; r < k; ++r)
        ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
      return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
      while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
        i++;
        j++;
      }
      return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxArray(int[] nums, int k) {
      int l = nums.length;
      int[] ans = new int[k];
      Stack<Integer> stack = new Stack<Integer>();
      for (int i = 0; i < l; i++) {
        if (!stack.isEmpty() && stack.peek() < nums[i] && stack.size() + l - i > k) {
          stack.pop();
        }
        if (stack.size() < k)
          stack.push(nums[i]);
      }
      for (int i = k - 1; i >= 0; i--) {
        ans[i] = stack.pop();
      }
      return ans;
    }
}
