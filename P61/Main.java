import java.util.*;
class Main {
    public static void main(String argvs[]){
      //String s = "Hello World!";
      int n = 6;

      int a = 126851231;
      int b = 3;
      //int x=-2147447412;
      //int[] height = {1,2,5,4,5};
      String s1 = "asdfgXXafgd";
      String s2 = "XasdgX";
      String[] strs = {"asd","as","asdf"};
      int target = 3;
      //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12},{13,14,15}};
      //int[][] matrix = new int[n][n];
      //int[][] matrix = {{ 5, 1, 9,11, 6}, { 2, 4, 8,10, 7}, {13, 3, 6, 7, 8}, {15,14,12,16, 9}, {1, 2, 3, 4, 5}};
      //int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
      //int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
      // int[] nums =  new int[n];
      // for(int i = 0 ; i <nums.length; i++){
      //   nums[i] = i+1;
      // }
      // Pmt pmt = new Pmt();
      // List<List<Integer>> ans = pmt.permute(nums);
      // for(int i = 0 ; i < ans.get(k-1).size(); i++){
      //   System.out.print(ans.get(k-1).get(i));
      //   System.out.println("");
      // }
      Solution slt = new Solution();
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
      ListNode head = new ListNode(0);
      int[] arr = {1,2,3, 4, 5};
      int k = 2;
      ListNode thisListNode = head;
      for(int i = 0 ; i < arr.length; i++){
        thisListNode.next = new ListNode(arr[i]);
        thisListNode = thisListNode.next;
      }
      head = head.next;

      thisListNode = slt.rotateRight(head,k);
      for(int i = 0 ; i < arr.length; i++){
        System.out.println(thisListNode.val);
        thisListNode = thisListNode.next;
      }

      //System.out.println(slt.rotateRight(head,k));
      // for(int i =0 ;i<matrix.length; i++){
      //   for(int j = 0; j<matrix[i].length; j++){
      //     System.out.print(matrix[i][j]+" ");
      //   }
      //   System.out.println("");
      // }

    }
}
