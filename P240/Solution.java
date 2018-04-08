class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
      int m = matrix.length, n = matrix[0].length;
      if (m == 1 && n == 1) return matrix[0][0] == target;
      return helper(matrix, 0, m - 1, 0, n - 1, target);
    }

    private boolean helper(int[][] matrix, int iUp, int iDown, int jLeft, int jRight, int target) {
      int m = matrix.length, n = matrix[0].length;
      if (iUp < 0 || iUp >= m || jLeft < 0 || jRight >= n)  return false;
      if (iUp == iDown && jLeft == jRight) return matrix[iUp][jRight] == target;
      if (iUp > iDown || jLeft > jRight)  return false;
      //when iDown > iUp, jRight > jLeft
      // iMid might equals iUp but never euqals iDown
      int iMid = iUp + (iDown - iUp) / 2;
      int jMid = jLeft + (jRight - jLeft) / 2;
      if (target > matrix[iMid][jMid])  return helper(matrix, iUp, iDown, jMid + 1, jRight, target) || helper(matrix, iMid + 1, iDown, jLeft, jRight, target);
      if (target < matrix[iMid][jMid]) return helper(matrix, iUp, iDown, jLeft, jMid - 1, target) || helper(matrix, iUp, iMid - 1, jLeft, jRight, target);
      return true;
    }
}
