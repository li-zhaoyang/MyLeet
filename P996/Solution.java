/*
    Contest 124
    Feb 16, 2019
*/
class Solution {
    int ans = 0;
    public int numSquarefulPerms(int[] A) {
        per(0, A);
        return ans;
    }
    public void per(int cur, int[] A) {
        if (cur == A.length) {
            ans++;
            return;
        }
        Set<Integer> used = new HashSet();
        for (int i = cur; i < A.length; i++) {
            if (cur == 0) {
                if (!used.contains(A[i])) {
                    used.add(A[i]);
                    swap(A, cur, i);
                    per(cur + 1, A);
                    swap(A, cur, i);
                }
            } else {
                int sum = A[cur-1] + A[i];
                if (isSquare(sum) && !used.contains(A[i])) {
                    used.add(A[i]);
                    swap(A, cur, i);
                    per(cur + 1, A);
                    swap(A, cur, i);
                }
            }
        }
    }
    private boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}