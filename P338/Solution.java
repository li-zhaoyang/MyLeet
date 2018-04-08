class Solution {
    public int[] countBits(int num) {
        if (num == 0)
          return new int[1];
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
          ans[i] = ans[i / 2] + i % 2;
        }
        return ans;
    }
}
