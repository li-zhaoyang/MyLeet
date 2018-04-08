class NumMatrix {
    int[][] matrixSum;
    public NumMatrix(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0] == null){
        matrixSum = new int[0][0];
        return ;
      }
      matrixSum = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          matrixSum[i][j] = j == 0? matrix[i][j] : matrix[i][j] + matrixSum[i][j - 1];
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      int sum = 0;
      if (row1 < 0) row1 = 0;
      if (row2 >= matrixSum.length)  row2 = matrixSum.length - 1;
      if (col1 < 0) col1 = 0;
      if (col2 >= matrixSum[0].length)  col2 = matrixSum[0].length - 1;
      for (int i = row1; i <= row2; i++) {
        sum += col1 == 0 ? matrixSum[i][col2]: matrixSum[i][col2] - matrixSum[i][col1 - 1];
      }
      return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
