class Solution {
    public int findMin(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      return findDevided(nums, 0, nums.length - 1);
    }

    private int findDevided(int[] nums, int start, int end){     //when come in, start <= end, and in range
      int l = nums.length;
      start = findFarmostEqualIndex(nums, start, true);
      end = findFarmostEqualIndex(nums, end, false);
      if (end <= start) return nums[end];
      int mid = start + (end - start) / 2;
      if (nums[mid] > nums[end]) { //search right
        //make sure mid is not the answer, so after plus one ans is in the range
        //we have nums[mid] > nums[end] so after moving mid, m + 1 <= end, will not exceed end (nums range)
        // so at start, no need to check nums range, start <= end guaranteed
        mid = findFarmostEqualIndex(nums, mid, true);
        return findDevided(nums, mid + 1, end);
      }
      if (nums[mid] < nums[start]) {  //search left, same induction as above
        mid = findFarmostEqualIndex(nums, mid, false);
        if (nums[mid - 1] > nums[mid])  return nums[mid];
        return findDevided(nums, start, mid - 1);
      }
      return nums[start];
    }

    private int findFarmostEqualIndex(int[] nums, int startIndex, boolean toRight) {
      if (toRight) {
        int i = startIndex;
        while (i != nums.length - 1 && nums[i] == nums[i + 1]) {
          i++;
        }
        return i;
      } else {
        int i = startIndex;
        while (i != 0 && nums[i - 1] == nums[i]) {
          i--;
        }
        return i;
      }
    }
}
