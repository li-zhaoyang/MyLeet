class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
      int lineNumber = searchForLine(matrix, target, 0 ,matrix.length - 1);
      if (lineNumber == -1) return false;
      if (lineNumber == -2) return true;
      return searchInLine(matrix, target, lineNumber, 0, matrix[0].length - 1);
    }

    private int searchForLine(int[][] matrix, int target, int start, int end) {
      if (start == end) return start;
      if (start > end)  return -1;
      int n = matrix[0].length;
      int mid = start + (end - start) / 2;
      if (matrix[mid][0] < target) {
        if (matrix[mid][n - 1] > target)  return mid;
        if (matrix[mid][n - 1] == target) return -2;
        return searchForLine(matrix, target, mid + 1, end);
      }
      if (matrix[mid][0] > target) return searchForLine(matrix, target, start, mid - 1);
      return -2;
    }

    private boolean searchInLine(int [][] matrix, int target, int lineNumber, int start, int end) {
      if (start > end)  return false;
      if (start == end) return matrix[lineNumber][start] == target;
      int mid = start + (end - start) / 2;
      if (matrix[lineNumber][mid] < target) return searchInLine(matrix, target, lineNumber, mid + 1, end);
      if (matrix[lineNumber][mid] > target) return searchInLine(matrix, target, lineNumber, start, mid - 1);
      return true;
    }
}
