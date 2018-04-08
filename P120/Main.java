import java.util.*;
class Main {
    public static void main(String argvs[]){
      //String s = "Hello World!";
      int m = 3;
      //int n = 4;
      int k = 3;
      int a = 126851231;
      int b = 3;
      //int x=-2147447412;
      //int[] height = {1,2,5,4,5};
      String s1 = "asdfgXXafgd";
      String s2 = "XasdgX";
      String[] strs = {"asd","as","asdf"};
      int[] arr = {1,2,2,3};
      int target = 29;
      String path = "/home//foo/";
      //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12},{13,14,15}};
      //int[][] matrix = new int[n][n];
      //int[][] matrix = {{ 5, 1, 9,11, 6}, { 2, 4, 8,10, 7}, {13, 3, 6, 7, 8}, {15,14,12,16, 9}, {1, 2, 3, 4, 5}};
      //int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
      //int[][] matrix = {{1,2,3,4,5}, {8,12,13, 15, 18}, {22,28, 29, 31, 33}};
      //int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
      int[] nums =  {1,2,3,4,5,6,7,8};
      ListNode head = new ListNode(nums[0]);
      ListNode lastListNode = head;
      for(int i = 1 ; i <nums.length; i++){
        ListNode thisListNode = new ListNode(nums[i]);
        lastListNode.next = thisListNode;
        lastListNode = thisListNode;
      }
      // Pmt pmt = new Pmt();


      Solution slt = new Solution();

      String s = "25525511035";
      //String s = "101";
      // System.out.println(slt.numDecodings(s));
      // TreeNode t = new TreeNode(1);
      // t.right = new TreeNode(2);
      // t.right.left = new TreeNode(3);
      int n = 10;

      int[][] all= {{-1}, {3, 2}, {-3, 1, -1}};
      List<List<Integer>> triangle = new ArrayList<List<Integer>>();
      for(int i = 0 ; i < all.length; i++ ){
        List<Integer> thisLine = new ArrayList<Integer>();
        for(int j = 0 ; j < all[i].length; j ++){
          thisLine.add(all[i][j]);
        }
        triangle.add(thisLine);
      }
      System.out.println(slt.minimumTotal(triangle));

      // TreeLinkNode t = new TreeLinkNode(10);
      // t.left = new TreeLinkNode(1);
      // t.right = new TreeLinkNode(2);
      // t.left.left = new TreeLinkNode(3);
      // t.left.left.right = new TreeLinkNode(5);
      // t.right.right = new TreeLinkNode(4);
      // t.right.right.right = new TreeLinkNode(6);
      // TreeLinkNode t = new TreeLinkNode(1);
      // t.right = new TreeLinkNode(-9);
      // t.right.right = new TreeLinkNode(8);
      // t.right.right.left = new TreeLinkNode(4);
      // t.right.right.right = new TreeLinkNode(-3);
      // t.right.right.right.left = new TreeLinkNode(-3);
      // t.right.right.right.left.left = new TreeLinkNode(-6);
      // t.right.right.right.left.left.right = new TreeLinkNode(-6);
      // t.right.right.right.left.left.right.left = new TreeLinkNode(-4);
      // t.right.right.right.left.left.right.right = new TreeLinkNode(-9);
      // t.right.right.right.left.left.right.right.left = new TreeLinkNode(6);
      // TreeNode t = new TreeNode(Integer.MIN_VALUE);
      // t.right = new TreeNode(Integer.MAX_VALUE);
      // t.right.left = new TreeNode(Integer.MIN_VALUE);

      // TreeNode ansTree = slt.sortedListToBST(head);
      // slt.connect(t);
      // TreeLinkNode thisInLayer = t.right ;
      //
      // while(thisInLayer != null){
      //   TreeLinkNode nextLayerLeft = slt.findNextLayerFirst(thisInLayer);
      //   while(thisInLayer != null){
      //     System.out.print(thisInLayer.val + " ");
      //     thisInLayer = thisInLayer.next;
      //   }
      //   System.out.println(" ");
      //   thisInLayer = nextLayerLeft;
      // }
      // for( int i = 0 ; i < tL.size(); i++){
        // Mid mid = new Mid();
        // List<Integer> ans = mid.inorderTraversal(t);
        // for(int j = 0 ; j < ans.size(); j++){
        //   System.out.print(ans.get(j) + " ");
        // }
        // System.out.println("");
      // }
      // int numRows = 5;
      // List<List<Integer>> ans = slt.generate(numRows);
      // for(int i = 0 ; i < ans.size(); i++){
      //   for(int j = 0; j < ans.get(i).size(); j++){
      //     System.out.print(ans.get(i).get(j) + " ");
      //   }
      //   System.out.println("");
      // }
      // int rowIndex = 2 ;
      // List<Integer> ans = slt.getRow(rowIndex);
      // for(int i = 0 ; i < ans.size(); i++){
      //   System.out.print(ans.get(i) + " ");
      // }
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
      // //int[][] grid = {{1,2,3,4},{1,1,1,1},{2,3,4,5},{5,4,3,2},{5,5,7,0}};
      // int[][] grid = {{1,2,3,4},{1,1,1,1},{2,3,0,5},{5,4,0,2}};

      // for(int i = 0 ; i <nums.length; i++){
      //   System.out.print(nums[i]+", ");
      // }

      //System.out.println(slt.sortColors(nums));
      // System.out.println("");
      // for(int i = 0 ; i <nums.length; i++){
      //   System.out.print(nums[i]+", ");
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
