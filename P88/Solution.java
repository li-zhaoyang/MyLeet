class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      for(int i0 = m + n - 1; i0 >= n; i0--){
        nums1[i0] = nums1[i0 - n];
      }
      int i = 0, i1 = n, i2 = 0;

      while(true){
        if(i == m + n)  break;
        if(i1 == m + n){
          nums1[i++] = nums2[i2++];
          continue;
        }
        if(i2 == n){
          nums1[i++] = nums1[i1++];
          continue;
        }
        if(nums1[i1] < nums2[i2]){
          nums1[i++] = nums1[i1++];
        }
        else  nums1[i++] = nums2[i2++];
      }

    }
}
