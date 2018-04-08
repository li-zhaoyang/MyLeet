import java.util.*;
class Solution {
  class UF {
    public int count = 0;
    public int[] id = null;
    public UF(int n) {
        count = n;
        id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while(p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot != qRoot) return false;
        else return true;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
  }
    public int findCircleNum(int[][] M) {
      if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
        return 0;
      }
      int n = M.length;
      UF uf = new UF(n);
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          if (M[i][j] == 1) {
            uf.union(i, j);

          }
        }
      }

      return uf.count;
    }
}
