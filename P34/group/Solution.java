class Solution {
    public int[] searchRange(int[] nums, int target) {
      if (nums == null || nums.length == 0) return new int[]{-1, -1};
      int l = nums.length;
      int oneOfTargetIndex = findEqualIndex(nums, target, 0, l - 1);
      if(oneOfTargetIndex == -1)  return new int[]{-1, -1};
      int[] ans = new int[2];
      ans[0] = findFarMost(nums, target, 0, oneOfTargetIndex, false);
      ans[1] = findFarMost(nums, target, oneOfTargetIndex, l - 1, true);
      return ans;
    }
    private int findEqualIndex(int[] nums, int target, int start, int end) {
      if (start == end) {
        if (nums[start] == target)  return start;
        return -1;
      }
      if (start > end)  return -1;
      int mid = start + (end - start) / 2;
      if (nums[mid] > target) return findEqualIndex(nums, target, start, mid - 1);
      if (nums[mid] < target) return findEqualIndex(nums, target, mid + 1, end);
      return mid;
    }

    private int findFarMost(int[] nums, int target, int start, int end, boolean findRight) {
      if (start == end) return start;
      int mid = start + (end - start) / 2;   //mid might equals start.
      if (nums[mid] == target) {
        if (mid + 1 == end && findRight) {
            if (nums[end] == target) return end;
            return mid;
        }
        if (findRight)  return findFarMost(nums, target, mid, end, findRight); //( might not end) addressed in mid + 1 == end
        return findFarMost(nums, target, start, mid, findRight);
      }
      if (findRight) return findFarMost(nums, target, start, mid - 1, findRight);
      //might produce start > end ? Impossible target is always in closed range,
      // so when findRight, nums[start] always equals to target
      //  here nums[mid] != target, so mid != start
      return findFarMost(nums, target, mid + 1, end, findRight);
    }
}
