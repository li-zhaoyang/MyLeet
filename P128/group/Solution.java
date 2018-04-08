import java.util.*;
class Solution {
  class UF {
    public int[] id;
    public int[] size;
    public UF(int n) {
      id = new int[n];
      Arrays.fill(size, 1);
      for (int i = 0; i < n; i++) {
        id[i] = i;
      }
    }

    public int find(int p) {
      while (p != id[p]) {
        id[p] = id[id[p]];
        p = id[p];
      }
      return p;
    }

    public boolean isConnected(int i, int j) {
      return find(i) == find(j);
    }

    public void unionTwo(int i, int j) {
      int iIndex = find(i);
      int jIndex = find(j);
      if (iIndex != jIndex)
        id[jIndex] = iIndex;
    }
  }
    public int longestConsecutive(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int n = nums.length;
      HashMap<Integer, Integer> reverseIndexMap = new HashMap<Integer, Integer>();
      HashSet<Integer> numSet = new HashSet<Integer>();
      UF uf = new UF(n);
      for (int i = 0; i < nums.length; i++) {
        if (!reverseIndexMap.containsKey(nums[i]))
          reverseIndexMap.put(nums[i], i);
      }
      int max = 1;
      for (int num: nums) {
        if (numSet.contains(num)) continue;
        if (numSet.contains(num - 1)) uf.unionTwo(reverseIndexMap.get(num - 1), reverseIndexMap.get(num));
        if (numSet.contains(num + 1)) uf.unionTwo(reverseIndexMap.get(num + 1), reverseIndexMap.get(num));
        numSet.add(num);
      }
      int[] count = new int[n];
      for (int i = 0; i < n; i++) {
        int thisRoot = uf.find(i);
        count[thisRoot]++;
        max = Math.max(count[thisRoot], max);
      }
      return max;
    }

}
