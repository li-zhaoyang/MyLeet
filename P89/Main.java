import java.util.*;
class Main {
    public static void main(String argvs[]){
      //String s = "Hello World!";
      int m = 3;
      int n = 3;
      int k = 3;
      int a = 126851231;
      int b = 3;
      //int x=-2147447412;
      //int[] height = {1,2,5,4,5};
      String s1 = "asdfgXXafgd";
      String s2 = "XasdgX";
      String[] strs = {"asd","as","asdf"};
      int[] arr = {1,2,2,3};
      int target = 7;
      String path = "/home//foo/";
      //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12},{13,14,15}};
      //int[][] matrix = new int[n][n];
      //int[][] matrix = {{ 5, 1, 9,11, 6}, { 2, 4, 8,10, 7}, {13, 3, 6, 7, 8}, {15,14,12,16, 9}, {1, 2, 3, 4, 5}};
      //int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
      //int[][] matrix = {{1,2,3,4,5}, {8,12,13, 15, 18}, {22,28, 29, 31, 33}};
      //int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
      int[] nums =  {3,3,3,4,5,5,5,6,6,7,1,1,1,2};
      // for(int i = 0 ; i <nums.length; i++){
      //   nums[i] = i+1;
      // }
      // Pmt pmt = new Pmt();
      Solution slt = new Solution();
      List<Integer> hhh = slt.grayCode(n);

      for(int i = 0 ; i < hhh.size(); i++){
        System.out.print(hhh.get(i) + " ");
        System.out.println("");
      }
      char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
      String word = "ABCB";

      // int[][] matrix = slt.generateMatrix(n);
      //
      // for(int i =0 ;i<matrix.length; i++){
      //   for(int j = 0; j<matrix[i].length; j++){
      //     System.out.print(matrix[i][j]+"\t");
      //   }
      //   System.out.println("");
      // }


      //System.out.println(matrix);
      //System.out.println(s.length()+"");

      // int[][] grid = {{1,2,3,4},{1,1,1,1},{2,3,0,5},{5,4,0,2}};
      //
      // int[] nums1 = {1,2,3,3,4,4,5,8,220,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
      // int[] nums2 = {2,3,3,3,4,5,7,8,18,19};
      // slt.merge(nums1, 9 ,nums2,2);
      // for(int i = 0 ; i <nums1.length; i++){
      //   System.out.print(nums1[i]+" ");
      // }
      //System.out.println(matrix);
      // for(int i =0 ;i<matrix.length; i++){
      //   for(int j = 0; j<matrix[i].length; j++){
      //     System.out.print(matrix[i][j]+" ");
      //   }
      //   System.out.println("");
      // }

    }
}
