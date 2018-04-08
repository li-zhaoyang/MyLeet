class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length;
      if(m == 0)  return false;
      int n = matrix[0].length;
      if(n == 0)  return false;
      int row = bsFirstCol(matrix, 0, m-1, target);
      if(row == -1) return false;
      return bs(matrix[row], 0, n-1, target);
    }

    public int bsFirstCol(int[][] matrix, int start, int end, int target){
      if(matrix[start][0] > target) return -1;
      if(matrix[end][0] <= target) return end;
      if(end - start == 1) return start;
      int mid = start + (end - start)/2;
      if(matrix[mid][0] > target)  return  bsFirstCol(matrix, start, mid - 1, target);
      if(matrix[mid][0] < target)  return bsFirstCol(matrix, mid, end, target);
      return mid;
    }

    public boolean bs(int[] row, int start, int end, int target){
      if(row[start] > target) return false;
      if(row[end] < target) return false;
      if(start >= end){
        if(row[start] == target || row[end] == target)  return true;
        return false;
      }
      int mid = start + (end - start)/2;
      if(row[mid] > target) return  bs(row, start, mid -1, target);
      if(row[mid] < target) return  bs(row, mid + 1, end, target);
      return true;
    }
}
