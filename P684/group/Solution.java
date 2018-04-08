import java.util.*;
class Solution {

  class UF {
    int [] id;
    public UF(int n) {
      id = new int[n];
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

    public boolean diffGroupUnion(int i, int j) {
      int iIndex = find(i);
      int jIndex = find(j);
      if (iIndex != jIndex) {
        id[jIndex] = iIndex;
        return true;
      }
      return false;
    }
  }

  public int[] findRedundantConnection(int[][] edges) {
    int ansIndex = -1;
    int n = edges.length;
    UF uf = new UF(n);
    boolean[] seen = new boolean[n];
    for (int i = 0; i < n; i++) {
      int left = edges[i][0] - 1;
      int right = edges[i][1] - 1;
      boolean diffGroup = uf.diffGroupUnion(left, right);
      if (seen[left] && seen[right] && !diffGroup) {
        ansIndex = i;
      }
      seen[left] = true;
      seen[right] = true;
    }
    return edges[ansIndex];
  }

}
