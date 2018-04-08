Class Solution {
  public int minArea(char[][] image, int x, int y) {
    if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) return false;
    int m = image.length, n = image[0].length;
    int left = findMostLeft(image, 0, y);
    int right = findMostRight(image, y, n - 1);
    int up = findMostUp(image, 0, x);
    int down = findMostDown(image, x, m - 1);
    return (right - left + 1) * (down - up + 1);
  }

  private int findMostLeft(char[][] image, int startCol, int endCol) {
    if (startCol == endCol) return startCol;
    int midCol = startCol + (endCol - startCol) / 2;
    if (thisColHasBlack(image, midCol, 0, image.length)) return findMostLeft(image, startCol, midCol);
    return findMostLeft(image, midCol + 1, endCol);
  }

  private int findMostRight(char[][] image, int startCol, int endCol) {
    if (startCol == endCol) return startCol;
    if (startCol + 1 == endCol) {
      if (thisColHasBlack(image, endCol, 0, image.length)) return endCol;
      return startCol;
    }
    int midCol = startCol + (endCol - startCol) / 2;
    if (thisColHasBlack(image, midCol, 0, image.length)) return findMostRight(image, midCol, endCol);
    return findMostLeft(image, startCol, midCol - 1);
  }

  private int findMostUp(char[][] image, int startRow, int endRow) {
    if (startRow == endRow) return startRow;
    int midRow = startRow + (endRow - startRow) / 2;
    if (thisRowHasBlack(image, midRow, 0, image[0].length)) return findMostUp(image, startRow, midRow);
    return findMostUp(image, midRow + 1, endRow);
  }

  private int findMostDwon(char[][] image, int startRow, int endRow) {
    if (startRow == endRow) return startRow;
    if (startRow + 1 == endRow) {
      if (thisRowHasBlack(image, endRow, 0, image[0].length)) return endRow;
      return startRow;
    }
    int midRow = startRow + (endRow - startRow) / 2;
    if (thisRowHasBlack(image, midRow, 0, image[0].length)) return findMostDown(image, midRow, endRow);
    return findMostUp(image, startRow, midRow - 1);
  }


  private boolean thisRowHasBlack(char[][] image, int rowNumber, int start, int end) {
    for (int j = start; j < end; j++) {
      if (image[rowNumber][j] == '1') return true;
    }
    return false;
  }

  private boolean thisColHasBlack(char[][] image, int colNumber, int start, int end) {
    for (int i = start; i < end; i++) {
      if (image[j][colNumber] == '1') return true;
    }
    return false;
  }

}
