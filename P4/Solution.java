class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if(nums1 == null || nums1.length == 0) return getMediumFrom1(nums2);
      if(nums2 == null || nums2.length == 0) return getMediumFrom1(nums1);
      int l1 = nums1.length, l2 = nums2.length;
      if(l1 > l2){
        int[] temp = nums1;
        nums1 = nums2;
        nums2 = temp;
      }
      return helpFind(nums1, nums2, 0 , nums1.length - 1);
    }

    private double helpFind(int[] nums1, int[] nums2, int start, int end){
      // if(start >= end)  return getMediumFrom2(nums1, nums2, start ,  (nums1.length + nums2.length + 1)/2 - start);
      int mid = start + (end - start)/2;
      int i = mid, j = (nums1.length + nums2.length + 1)/2 - i;
      int l1 = nums1.length, l2 = nums2.length;
      int l = l1 + l2;
      if(i == 0){
        if(nums1[i] < nums2[j - 1]){
          return helpFind(nums1, nums2, mid + 1, end);
        }
        if(l1 == l2) return (double)(nums1[0] + nums2[l2 - 1])/2.0;
        if(l % 2 == 0){
          int right = nums1[i] < nums2[j] ? nums1[i]:nums2[j];
          return (double)(nums2[j - 1] + right)/2.0;
        }
        return (double)nums2[j - 1];
      }
      if( i == l1) {
        if(nums1[i - 1] > nums2[j]){
          return helpFind(nums1, nums2, start, mid - 1);
        }
        if(l1 == l2) return (double)(nums2[0] + nums1[l1 - 1])/2.0;
        int left = nums1[l1 - 1 ] > nums2[j - 1]? nums1[l1 - 1] : nums2[j - 1];
        if(l % 2 == 0){
          return (double)(left + nums2[j])/2.0;
        }
        return (double)left;
      }

      if(nums1[i] < nums2[j - 1]){
        return helpFind(nums1, nums2, mid + 1, end);
      }
      if(nums1[i - 1] > nums2[j]){
        return helpFind(nums1, nums2, start, mid - 1);
      }
      return getMediumFrom2(nums1, nums2, i , j);
    }

    private double getMediumFrom2(int[] nums1, int[] nums2, int i, int j){
      int l = nums1.length + nums2.length;
      if( l % 2 == 0){
        int left,right;
        if(nums1[i - 1] > nums2[j - 1]) left = nums1[i - 1];
        else left = nums2[j - 1];
        if(nums1[i] < nums2[j]) right = nums1[i];
        else  right = nums2[j];
        return (double)(left + right)/2.0;
      }

      if(nums1[i - 1] > nums2[j - 1]) return (double)nums1[i - 1];
      return (double)nums2[j - 1];

    }

    private double getMediumFrom1(int[] nums){
      if(nums == null)  return 0;
      int l = nums.length;
      if(l == 0)  return 0;
      if(l %2 == 0) {
        return (double)(nums[l/2 - 1] + nums[l/2]) / 2.0;
      }
      return (double)nums[l/2];
    }
}
