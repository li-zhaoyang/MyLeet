import java.util.*;
class Solution {
    class NumWithLineNum implements Comparable{
      int num;
      int lineNum;
      int index;
      public NumWithLineNum(int a, int b, int c) {
        num = a;
        lineNum = b;
        index = c;
      }
      @Override
      public int compareTo(Object o) {
        NumWithLineNum other = (NumWithLineNum) o;
        if (this.num == other.num) {
          return Integer.valueOf(this.lineNum).compareTo(other.lineNum);
        }
        return Integer.valueOf(this.num).compareTo(other.num);
      }
    }
    public int kthSmallest(int[][] matrix, int k) {
      TreeSet<NumWithLineNum> treeSet = new TreeSet<NumWithLineNum>();
      int n = matrix.length;
      for (int i = 0; i < n; i++) {
        treeSet.add(new NumWithLineNum(matrix[i][0], i, 0));
      }
      int num = 0;
      for (int i = 0; i < k; i++) {
        NumWithLineNum thisNWLM = treeSet.pollFirst();
        if (i == k - 1) return thisNWLM.num;
        if (thisNWLM.index < n - 1) {
          treeSet.add(new NumWithLineNum(matrix[thisNWLM.lineNum][thisNWLM.index + 1], thisNWLM.lineNum, thisNWLM.index + 1));
        }
        num = thisNWLM.num;
      }
      return num;

    }
}
