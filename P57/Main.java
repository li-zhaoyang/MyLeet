import java.util.*;
class Main {
    public static void main(String argvs[]){


      //String s = "       -2147483648awetgewyert";
      int n = -2147483648;
      int x = -1;
      int a = 126851231;
      int b = 3;
      //int x=-2147447412;
      //int[] height = {1,2,5,4,5};
      String s1 = "asdfgXXafgd";
      String s2 = "XasdgX";
      String[] strs = {"eat","tea","tan","ate","nat","bat"};
      int[] nums = {3,2,1,0,4};
      //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
      //int[][] matrix = {{ 5, 1, 9,11, 6}, { 2, 4, 8,10, 7}, {13, 3, 6, 7, 8}, {15,14,12,16, 9}, {1, 2, 3, 4, 5}};
      // int[][] matrix = {{1,2}, {3,4}};
      // for(int i =0 ;i<matrix.length; i++){
      //   for(int j = 0; j<matrix[i].length; j++){
      //     System.out.print(matrix[i][j]);
      //   }
      //   System.out.println("");
      // }
      Solution slt = new Solution();
      int target = 3;


      //57
      //System.out.println(s.length()+"");
      List<Interval> intervals = new ArrayList<Interval>();
      intervals.add(new Interval(1,5));
      // intervals.add(new Interval(8,10));
      // intervals.add(new Interval(15,18));
      // intervals.add(new Interval(22,26));
      // intervals.add(new Interval(27, 31));
      // intervals.add(new Interval(41, 45));

      //System.out.println(slt.merge(intervals));
      List<Interval> intervalsMerged = slt.insert(intervals, new Interval(-1,0));
      for(int i = 0 ; i < intervalsMerged.size(); i++){
        System.out.print(intervalsMerged.get(i).start + " ");
        System.out.println(intervalsMerged.get(i).end);
      }
      // for(int i =0 ;i<matrix.length; i++){
      //   for(int j = 0; j<matrix[i].length; j++){
      //     System.out.print(matrix[i][j]+" ");
      //   }
      //   System.out.println("");
      // }



    }
}
