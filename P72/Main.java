import java.util.*;
class Main {

    public static void main(String argvs[]){


      Solution slt = new Solution();
      //72
      System.out.println(slt.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically"));
      // //68
      // // String[] words = {"Ts", "is", "an", "exdkjfskdsssample", "off", "text", "jation."};
      // String[] words = {};
      // int L = 0;
      // List<String> ans = slt.fullJustify(words, L);
      // for(int i = 0 ; i < ans.size();  i ++){
      //   System.out.println(ans.get(i));
      // }
      // //51
      // List<List<String>> ans = slt.solveNQueens(8);
      // System.out.println(ans.size() );
      // for(int i = 0 ; i < ans.size() ; i ++){
      //   for(int j = 0 ; j < ans.get(i).size(); j++){
      //     System.out.println(ans.get(i).get(j));
      //   }
      //   System.out.println("");
      // }
      // //45
      // int[] nums = {2,3,1,1,4};
      // System.out.println(slt.jump(nums));
      // //44
      //
      // // System.out.println(slt.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
      // System.out.println(slt.isMatch("x", "*?*"));


      // //42
      // // int[] height = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
      // // int[] height = {1,1,1,3,1,3,3,1,1};
      // // int[] height = {5,4,1,3};
      // // int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
      // int[] height = {9,6,9,1,0};
      // System.out.println(slt.trap(height));
      //

      //37
      // char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
      // slt.solveSudoku(board);
      // for(int i = 0 ; i < board.length ; i ++){
      //   for(int j = 0 ; j < board[i].length ; j++){
      //     System.out.print(board[i][j] + " ");
      //   }
      //   System.out.println("");
      // }
      //37 soduko

      // //32
      //
      // String s = ")()(((())))(";
      // System.out.println(slt.longestValidParentheses(s));
      // //30
      // String s = "sdfgasdfoobarsdgbarfooseg";
      // String[] words = {"foo", "bar"};
      // List<Integer> ans = slt.findSubstring(s, words);
      //
      // for(int i = 0 ; i < ans.size() ; i ++){
      //     System.out.println(ans.get(i));
      //
      // }
      // int n = 1;
      // int k = 1;
      // ListNode[] nodes = new ListNode[n];
      //
      // for(int i = 0 ; i < n ; i++){
      //   nodes[i] = new ListNode(i);
      //   if(i >0)  nodes[i - 1].next = nodes[i];
      // }
      // ListNode thisNode = slt.reverseKGroup(nodes[0], k);
      // while(thisNode != null){
      //   System.out.println(thisNode.val);
      //   thisNode = thisNode.next;
      // }

      //String s = "       -2147483648awetgewyert";
      // int n = 2;
      // //int x=-2147447412;
      // //int[] height = {1,2,5,4,5};
      // //String s = "XXX";
      // String[] strs = {"asd","as","asdf"};
      // int[] l1 = {1,3,4,5};
      // int[] l2 = {-1,2,3,6};
      // ListNode headL1= new ListNode(0), lastListNodeL1 = new ListNode(0);
      // for(int i=0;i<l1.length;i++){
      //   ListNode thisListNode = new ListNode(l1[i]);
      //   if(i==0)  headL1 = thisListNode;
      //   else  lastListNodeL1.next = thisListNode;
      //   lastListNodeL1 = thisListNode;
      // }
      // ListNode headL2= new ListNode(0), lastListNodeL2 = new ListNode(0);
      // for(int i=0;i<l2.length;i++){
      //   ListNode thisListNode = new ListNode(l2[i]);
      //   if(i==0)  headL2 = thisListNode;
      //   else  lastListNodeL2.next = thisListNode;
      //   lastListNodeL2 = thisListNode;
      // }


      // ListNode thisListNode = head;
      // while(true){
      //   System.out.println(thisListNode.val);
      //   if(thisListNode.next == null) break;
      //   thisListNode = thisListNode.next;
      // }




      //int target = 1;

      //System.out.println(s.length()+"");
      //System.out.println(slt.removeNthFromEnd(arr,target));
    }
}
