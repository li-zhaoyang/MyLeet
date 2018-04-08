class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
      int top = Math.min(D, H);
      int bottom = Math.max(B, F);
      int left = Math.max(A, E);
      int right = Math.min(C, G);
      int overlap = 0;
      if (top > bottom && right > left) overlap = (top - bottom) * (right - left);
      return  (D - B) * (C - A) + (H - F) *(G - E) - overlap;
    }
}
