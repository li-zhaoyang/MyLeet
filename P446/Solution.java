class Solution {
    public int numberOfArithmeticSlices(int[] A) {
      if (A == null || A.length == 0) return 0;
      int n = A.length;
      HashMap<Long, Integer>[] maps = new HashMap[n];
      int count = 0;
      for (int i = 0; i < n; i++) {
        maps[i] = new HashMap<Long, Integer>();
        for (int j = 0; j < i; j++) {
          Long diff = (long) ((long) A[i] - (long) A[j]);
          if (maps[j].containsKey(diff)) {
            maps[i].put(diff, maps[i].getOrDefault(diff, 0) + maps[j].get(diff) + 1);
            count += maps[j].get(diff);
          }
          else
            maps[i].put(diff, maps[i].getOrDefault(diff, 0) + 1);
        }
      }
      return count;
    }
}
