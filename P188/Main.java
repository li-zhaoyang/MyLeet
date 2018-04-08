import java.util.*;
class Main {

    public static void main(String argvs[]){


      Solution slt = new Solution();
      // 188
      int k = 2;
      int[] prices = {1,2,4,2,5,7,2,4,9,0};
      System.out.println(slt.maxProfit(k, prices));
      // //174
      // int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
      // System.out.println(slt.calculateMinimumHP(dungeon));
      // //146
      // LRUCache cache = new LRUCache(2);
      // System.out.println(cache.get(1));
      // cache.put(1, 1);
      // cache.put(2, 2);
      // System.out.println(cache.get(1));      // returns 1
      // cache.put(3, 3);    // evicts key 2
      // System.out.println(cache.get(2));       // returns -1 (not found)
      // cache.put(4, 4);    // evicts key 1
      // System.out.println(cache.get(1));       // returns -1 (not found)
      // System.out.println(cache.get(3));       // returns 3
      // System.out.println(cache.get(4));       // returns 4
      // //135
      // int[] ratings = {1,2};
      // System.out.println(slt.candy(ratings));
      // //132
      // String s = "aabaasaf";
      // System.out.println(slt.minCut(s));
      // //128
      // int[] nums = {100,2,39,300, 5,20,4,70,3};
      // System.out.println(slt.longestConsecutive(nums));
      // //126
      // String beginWord = "leet";
      // String endWord = "code";
      // String[] wordArr = {"lest","leet","lose","code","lode","robe","lost"};
      // List<String> wordList = Arrays.asList(wordArr);
      // List<List<String>> ans = slt.findLadders(beginWord, endWord, wordList);
      // List<List<String>> ans1 = slt.findLadders(beginWord, "log", wordList);
      //
      // for(int i = 0 ; i < ans.size(); i++){
      //   for(int j = 0; j < ans.get(i).size(); j ++){
      //     System.out.print(ans.get(i).get(j)+" ");
      //   }
      //   System.out.println("");
      // }
      // for(int i = 0 ; i < ans1.size(); i++){
      //   for(int j = 0; j < ans1.get(i).size(); j ++){
      //     System.out.print(ans.get(i).get(j)+" ");
      //   }
      //   System.out.println("");
      // }
      //124
      // TreeNode[] nodes = new TreeNode[20];
      // for(int i = 0 ; i < 20; i ++){
      //   nodes[i] = new TreeNode(i);
      // }
      // TreeNode nodesMinus1 =  new TreeNode(-1);
      // nodes[1].left = nodesMinus1;
      // nodes[1].right = nodes[3];
      // nodesMinus1.right = nodes[2];
      // nodes[2].left = nodes[12];
      // nodes[2].right = nodes[18];
      // System.out.println(slt.maxPathSum(nodes[1]));
      // //123
      // int[] prices = {1,2,4,2,5,7,2,4,9,0};
      // System.out.println(slt.maxProfit(prices));
      // //115
      // System.out.println(slt.numDistinct("ABACDCE", "ACE"));
      // //98
      // TreeNode[] tree = new TreeNode[20];
      // for(int i = 0 ; i < 20 ; i++){
      //   tree[i] = new TreeNode(i);
      // }
      // tree[3].left = tree[5];
      // // tree[3].left = tree[2];
      // // tree[3].right = tree[4];
      // // tree[2].left = tree[1];
      // //
      // tree[3].right = tree[8];
      // // tree[8].left = tree[6];
      // // tree[8].right = tree[12];
      // //
      // // tree[6].right = tree[7];
      // //
      // // tree[12].left = tree[10];
      // // tree[12].right = tree[14];
      // //
      // // tree[10].left = tree[9];
      // // tree[10].right = tree[11];
      // //
      // //
      // // tree[14].left = tree[13];
      // // tree[14].right = tree[17];
      // // tree[17].left = tree[16];
      // slt.recoverTree(tree[3]);
      // slt.recoverTree(tree[3]);

      // //87
      // String s1 = "great";
      // String s2 = "grate";
      // System.out.println(slt.isScramble(s1, s2));
      // //85
      // // char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
      // char[][] matrix = {{'1','0'},{'0', '1'}};
      // System.out.println(slt.maximalRectangle(matrix));
      // //84
      // int[] heights = {2,1,5,6,2,3};
      // System.out.println(slt.largestRectangleArea(heights));
      // //76
      // System.out.println(slt.minWindow("adfadsesg", "dfs"));
      // 72
      // System.out.println(slt.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically"));
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
