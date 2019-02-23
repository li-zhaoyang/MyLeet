/*
    Contest 123
    Feb 9, 2019
*/
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> count = new HashMap();
        int l = A.length;
        int end = 0;
        int end1 = 0;
        int ans = 0;
        for (int i = 0; i < l; i++) {
                while (count.size() < K && end1 < l) {
                    count.put(A[end1], count.getOrDefault(A[end1++], 0) + 1);
                }
            while (end < l && count.containsKey(A[end])) {
                end++;
            }
            int right = end - end1 + 1;
            if (count.size() == K)  ans += right;
            if (count.getOrDefault(A[i], 0) == 1) {
                count.remove(A[i]);
            } else {
                count.put(A[i], count.getOrDefault(A[i], 0) - 1);
            }
        }
        return ans;
    }
}
