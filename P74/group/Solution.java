class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
      return helperSearch(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean helperSearch(int[][] matrix, int target, int iUp, int iDown, int jLeft, int jRight) {
      int m = matrix.length, n = matrix[0].length;
      if(iUp >= m || jLeft >= n || iDown < 0 || jRight < 0 || iUp > iDown || jLeft > jRight) return false;
      if (iUp == iDown && jLeft == jRight) return matrix[iUp][jLeft] == target;
      int iMid = iUp + (iDown - iUp) / 2, jMid = jLeft + (jRight - jLeft) / 2;
      if (matrix[iMid][jMid] > target) return helperSearch(matrix, target, iMid, iMid, jLeft, jMid - 1) || helperSearch(matrix, target, iUp, iMid - 1, jLeft, jRight);
      if (matrix[iMid][jMid] < target)  return helperSearch(matrix, target, iMid, iMid, jMid + 1, jRight) || helperSearch(matrix, target, iMid + 1, iDown, jLeft, jRight);
      return true;
    }
}
