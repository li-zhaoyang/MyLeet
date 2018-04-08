import java.util.*;
class Main {
    public static void main(String argvs[]){
      Solution slt = new Solution();
      //343
      int n = 10;
      System.out.println(slt.integerBreak(n));
      // //338
      // int num = 5;
      // int[] ans = slt.countBits(num);
      // for (int num1: ans) {
      //   System.out.println(num1);
      // }
      // //322
      // int[] coins = {1, 2, 5};
      // int amount = 6;
      // System.out.println(slt.coinChange(coins, amount));
      // //321
      // int[] nums1 = {6, 7, 5};
      // int[] nums2 = {4, 8, 1};
      // int k = 3;
      // int[] ans = slt.maxNumber(nums1, nums2, k);
      // for (int num: ans)
      //   System.out.println(num);
      // //300
      // int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
      // System.out.println(slt.lengthOfLIS(nums));
      // //299
      // String secret = "1807";
      // String guess = argvs[0];
      // System.out.println(slt.getHint(secret, guess));
      // //297
      // TreeNode[] treeNodes = new TreeNode[10];
      // for (int i = 0; i < 10; i++) {
      //   treeNodes[i] = new TreeNode(i);
      // }
      // treeNodes[5].left = treeNodes[3];
      // treeNodes[3].left = treeNodes[2];
      // treeNodes[3].right = treeNodes[4];
      // treeNodes[2].left = treeNodes[0];
      // treeNodes[0].right = treeNodes[1];
      // treeNodes[5].right = treeNodes[8];
      // treeNodes[8].right = treeNodes[9];
      // treeNodes[8].left = treeNodes[6];
      // treeNodes[6].right = treeNodes[7];
      // Codec codec = new Codec();
      // String serialized = codec.serialize(treeNodes[6]);
      // TreeNode deserializedRoot = codec.deserialize(serialized) ;
      // System.out.println(deserializedRoot.val);
      // System.out.println(deserializedRoot.right.val);
      // System.out.println();
      // 295
      // int[] nums = {1, 8, 2, 7, 4, 9, 3, 6, 5};
      // MedianFinder mf = new MedianFinder();
      // for (int i = 0 ; i < nums.length; i++) {
      //   mf.addNum(nums[i]);
      //   System.out.println(mf.findMedian());
      // }
      // //287
      // int[] nums = {1, 3, 4, 2, 2};
      // System.out.println(slt.findDuplicate(nums));
      // //284
      // ArrayList<Integer> list = new ArrayList<Integer>();
      // for (int i = 0 ; i < 10; i++) {
      //   list.add(i);
      // }
      // PeekingIterator myPI = new PeekingIterator(list.iterator());
      // //282
      // System.out.println(slt.addOperators("005", 5));
      // //279
      // System.out.println(slt.numSquares(8));
      // //278
      // System.out.println(slt.firstBadVersion(2));
      // //273
      // int num = Integer.MAX_VALUE;
      // System.out.println(slt.numberToWords(num));
      // //241
      // String s = "2+3*8+9*6";
      // System.out.println(slt.diffWaysToCompute(s));
      // //239
      // int[] nums = {1,3,-1,-3,5,3,6,7};
      // int k = 3;
      // int[] ans = slt.maxSlidingWindow(nums, k);
      // for (int i = 0; i < ans.length; i++) {
      //   System.out.println(ans[i]);
      // }
      // //238
      // int[] nums = {2, 3, 4};
      // int[] ans = slt.productExceptSelf(nums);
      // for (int i = 0; i < ans.length; i ++) {
      //   System.out.println(ans[i]);
      // }
      // //236
      // TreeNode[] treeNodes = new TreeNode[10];
      // for (int i = 0; i < 10; i++) {
      //   treeNodes[i] = new TreeNode(i);
      // }
      // treeNodes[5].left = treeNodes[3];
      // treeNodes[3].left = treeNodes[2];
      // treeNodes[3].right = treeNodes[4];
      // treeNodes[2].left = treeNodes[0];
      // treeNodes[0].right = treeNodes[1];
      // treeNodes[5].right = treeNodes[8];
      // treeNodes[8].right = treeNodes[9];
      // treeNodes[8].left = treeNodes[6];
      // treeNodes[6].right = treeNodes[7];
      // System.out.println(slt.lowestCommonAncestor(treeNodes[5], treeNodes[1], treeNodes[1]).val);
      // System.out.println(slt.lowestCommonAncestor(null, null, null));
      // // //234
      // ListNode[] lns = new ListNode[10];
      // for (int i = 0 ;i < 2; i ++) {
      //   if (i > 1)  lns[i] = new ListNode(1 - i);
      //   else lns[i] = new ListNode(i);
      //   if (i > 0) lns[i - 1].next = lns[i];
      // }
      //
      // System.out.println(slt.isPalindrome(lns[0]));
      // //231
      // System.out.println(slt.isPowerOfTwo(32));
      // //230
      // TreeNode[] treeNodes = new TreeNode[10];
      // for (int i = 0; i < 10; i++) {
      //   treeNodes[i] = new TreeNode(i);
      // }
      // treeNodes[5].left = treeNodes[3];
      // treeNodes[3].left = treeNodes[2];
      // treeNodes[3].right = treeNodes[4];
      // treeNodes[2].left = treeNodes[0];
      // treeNodes[0].right = treeNodes[1];
      // treeNodes[5].right = treeNodes[8];
      // treeNodes[8].right = treeNodes[9];
      // treeNodes[8].left = treeNodes[6];
      // treeNodes[6].right = treeNodes[7];
      // for (int i = 0; i < 10; i++) {
      //   System.out.println(slt.kthSmallest(treeNodes[5], i + 1));
      // }
      // System.out.println(slt.kthSmallest(treeNodes[6], 2));
      // //228
      // int[] nums1 = {0,1,2,4,5,7};
      // int[] nums2 = {0,2,3,4,6,8,9};
      // int[] nums3 = {1};
      // System.out.println(slt.summaryRanges(nums3));
      // //227
      // String s = "10921/33 +22 - 99 /5/4";
      // System.out.println(slt.calculate(s));
      // System.out.println(10921/33 +22 - 99 /5/4);
      // //220
      // System.out.println(slt.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
      // System.out.println(slt.combinationSum3(3, 9));
      // //215
      // int[] nums = {3, 3, 3, 3, 3};
      // System.out.println(slt.findKthLargest(nums, 5));
      // // //214
      // String s = "cbabcaa";
      // System.out.println(slt.shortestPalindrome(s));
      // //212
      // char[][] board = {{'a', 'b'}, {'c', 'd'}};
      // String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
      // System.out.println(slt.findWords(board, words));
      // //211
      // WordDictionary trie = new WordDictionary();
      // trie.addWord("helloworld");
      // trie.addWord("hhhhhworld");
      // System.out.println("search:" + trie.search("helloworld"));
      // System.out.println("search:" + trie.search(".e.lowo..."));
      // System.out.println("search:" + trie.search("h..h.....d"));
      // System.out.println("search:" + trie.search("lkjdshfsdkj"));
      // System.out.println("search:" + trie.search(""));
      // // System.out.println("startsWith:" + trie.startsWith(""));
      // // System.out.println("startsWith:" + trie.startsWith("he"));
      // // System.out.println("startsWith:" + trie.startsWith("helloworld"));
      // // System.out.println("startsWith:" + trie.startsWith("helloworldsgdd"));
      // // System.out.println("startsWith:" + trie.startsWith("helo"));
      // trie.addWord("");
      // System.out.println("search:" + trie.search(""));
      // System.out.println("startsWith:" + trie.startsWith(""));
      // //206
      // ListNode[] lns = new ListNode[10];
      // for (int i = 0; i < 10; i++) {
      //   lns[i] = new ListNode(i);
      //   if (i != 0) lns[i - 1].next = lns[i];
      // }

      // lns[9].val = 6;
      // ListNode thisNode = slt.reverseList(lns[7]);
      // System.out.println();
      // while (thisNode != null) {
      //   System.out.print(thisNode.val + " ");
      //   thisNode = thisNode.next;
      // }
      // System.out.println();
      // //205
      // System.out.println(slt.isIsomorphic("aa", "ab"));
      // //204
      // System.out.println(slt.countPrimes(3));
      // //203
      // ListNode[] lns = new ListNode[10];
      // for (int i = 0; i < 10; i++) {
      //   lns[i] = new ListNode(i);
      //   if (i != 0) lns[i - 1].next = lns[i];
      // }
      // lns[5].val = 6;
      // lns[7].val = 6;
      // lns[8].val = 6;
      // // lns[9].val = 6;
      // ListNode thisNode = slt.removeElements(lns[6], 6);
      // System.out.println();
      // while (thisNode != null) {
      //   System.out.print(thisNode.val + " ");
      //   thisNode = thisNode.next;
      // }
      // System.out.println();

      // //202
      // System.out.println(slt.isHappy(11));
      // //201
      // int m = (int) Math.pow(2, 31);
      // int n = (int) Math.pow(2, 31) - 2;
      // System.out.println(slt.rangeBitwiseAnd(m, n));
      // //198
      // int[] nums = {1,2,3,4,4,5,6,8};
      // System.out.println( slt.rob(nums) );
      // //190
      // System.out.println(slt.hammingWeight(8));
      // //189
      // int[] nums ={1,2};
      // int k = 3;
      // slt.rotate(nums,k);
      // for( int num: nums) System.out.println(num);
      //187
      // String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
      // String s = "AAAAACCCCC";
      // String s = "AAAAAAAAAAAA";
      // List<String> ans = slt.findRepeatedDnaSequences(s);
      // for(int i = 0 ; i < ans.size() ; i ++){
      //   System.out.println(ans.get(i));
      // }
      // //179
      // int[] nums = {0,0};
      // System.out.println(slt.largestNumber(nums));
      // //173
      // TreeNode[]  nodes = new TreeNode[11];
      // for(int i = 0 ; i < 11 ; i ++){
      //   nodes[i] = new TreeNode(i);
      // }
      // nodes[6].left = nodes[2];
      // nodes[6].right = nodes[7];
      // nodes[2].left = nodes[1];
      // nodes[2].right = nodes[4];
      // nodes[4].left = nodes[3];
      // nodes[4].right = nodes[5];
      // nodes[7].right = nodes[9];
      // nodes[9].left = nodes[8];
      // BSTIterator i = new BSTIterator(nodes[6]);
      // while (i.hasNext()) System.out.println(i.next());

      // //172
      // System.out.println(slt.trailingZeroes(88));
      // //171
      // System.out.println(slt.titleToNumber("YZ"));
      // //169
      // int[] nums = {1,1,2,2,3,3,3,3};
      // System.out.println(slt.majorityElement(nums));
      // //168
      // for(int i = 1 ;i < 29; i++) System.out.println(slt.convertToTitle(i));
      // //166
      // int numerator =  1, denominator = 17;
      // System.out.println(slt.fractionToDecimal(numerator, denominator));
      // // //165
      // String version1 = "1";
      // String version2 = "1.0";
      // System.out.println(slt.compareVersion(version1, version2));
      // //164
      // int[] nums = {2, 99999999 };
      // System.out.println(slt.maximumGap(nums));

      // //162
      // int[] nums = {1};
      // System.out.println(slt.findPeakElement(nums));
      //156
      // ListNode[] nodes = new ListNode[10];
      // for( int i = 0 ; i < 10 ; i++){
      //   nodes[i] = new ListNode(i);
      //   if( i >= 7 )  nodes[i - 1].next = nodes[i];
      // }
      //
      // nodes[0].next = nodes[1];
      // nodes[1].next = nodes[2];
      // nodes[2].next = nodes[3];
      // nodes[3].next = nodes[6];
      // nodes[4].next = nodes[5];
      // nodes[5].next = nodes[6];
      // ListNode ans = slt.getIntersectionNode(nodes[3], nodes[1]);
      // if(ans == null){
      //   System.out.println("null");
      // }else{
      //   System.out.println(ans.val);
      // }

      // //155
      // MinStack myMinStack = new MinStack();
      // myMinStack.push(214783646);
      // myMinStack.push(214783646);
      // myMinStack.push(214783647);
      // System.out.println(myMinStack.top());
      // myMinStack.pop();
      // System.out.println(myMinStack.getMin());
      // myMinStack.pop();
      // System.out.println(myMinStack.getMin());
      // myMinStack.pop();
      // myMinStack.push(214783647);
      // System.out.println(myMinStack.top());
      // System.out.println(myMinStack.getMin());
      // myMinStack.push(214783647);
      // System.out.println(myMinStack.top());
      // System.out.println(myMinStack.getMin());
      // myMinStack.pop();
      // System.out.println(myMinStack.getMin());
      // //153 154
      // int[] nums = {2,2,3,3,3, 1};
      // System.out.println(slt.findMin(nums));
      // // //152
      // int[] nums = {2,3,-2,4};
      // System.out.println( slt.maxProduct(nums) );
      // //151
      // String s = "  ";
      // System.out.println(slt.reverseWords(s)+"...");

      //150
      // // String[] operands = {"2", "1", "+", "3", "*"};
      // // String[] operands = {"4", "13", "5", "/", "+"};
      // String[] operands = {"99", "5", "1", "2", "+", "4", "*", "+", "3", "-","/"};
      // // String[] operands = {"0","3","/"};

      // System.out.println(slt.evalRPN(operands));
      //
      // //147 148
      // ListNode head = new ListNode(0);
      // ListNode thisListNode = head;
      // int[] nums = {1,8,6,3,5,22,9,4,534};
      // for(int i = 0 ; i < nums.length ; i ++){
      //   thisListNode.next = new ListNode(nums[i]);
      //   thisListNode = thisListNode.next;
      // }
      // head = slt.sortList(head);
      // while(head != null){
      //   System.out.println(head.val);
      //   head = head.next;
      // }
      // //144 145
      // TreeNode t = new TreeNode(0);
      // t.left = new TreeNode(1);
      // t.right = new TreeNode(2);
      // t.left.left = new TreeNode(3);
      // t.left.right = new TreeNode(4);
      // t.left.left.left = new TreeNode(7);
      // t.left.left.right = new TreeNode(8);
      // t.right.left = new TreeNode(5);
      // t.right.right = new TreeNode(6);
      // List<Integer> ans= slt.postorderTraversal(t);
      // for(int i = 0 ; i < ans.size() ; i ++ ){
      //   System.out.println(ans.get(i));
      // }

      // //143
      // ListNode head = new ListNode(0);
      // ListNode thisListNode = head;
      // for(int i = 0 ; i < 2; i ++){
      //   thisListNode.next = new ListNode(i+1);
      //   thisListNode = thisistNode.next;
      // }
      // slt.reorderList(head);
      // while(head != null){
      //   System.out.println(head.val);
      //   head = head.next;
      // }
      // // 142
      // ListNode head = new ListNode(0);
      // ListNode thisListNode = head;
      // for(int i = 0 ; i < 7; i ++){
      //   thisListNode.next = new ListNode(i+1);
      //   thisListNode = thisListNode.next;
      // }
      // head.next.next.next = head.next;
      // System.out.println(slt.detectCycle(head).val);
      // // 141
      // ListNode head = new ListNode(0);
      // ListNode thisListNode = head;
      // for(int i = 0 ; i < 0; i ++){
      //   thisListNode.next = new ListNode(i+1);
      //   thisListNode = thisListNode.next;
      // }

      // head.next.next.next = head.next;
      // System.out.println(slt.hasCycle(head));
      // //139 140
      // String s = "leetleetcode";
      // List<String> stringList = new ArrayList<String>();
      // stringList.add("leet");
      // stringList.add("le");
      // stringList.add("et");
      // stringList.add("code");
      // List<String> ans = slt.wordBreak(s, stringList);
      // for(int i = 0 ; i < ans.size(); i++){
      //   System.out.println(ans.get(i));
      // }

      // // 138
      //
      // RandomListNode[] nodes = new RandomListNode[4];
      // for(int i = 0 ; i < 4 ; i ++){
      //   nodes[i] = new RandomListNode(i);
      //   if(i>0) nodes[i-1].next = nodes[i];
      // }
      // RandomListNode head = nodes[0];
      // nodes[0].random = nodes[3];
      // nodes[1].random = nodes[0];
      // nodes[2].random = null;
      // nodes[3].random = nodes[3];
      // head = slt.copyRandomList(nodes[0]);
      // for(int i = 0 ; i < 4 ; i ++){
      //   System.out.print(i+": ");
      //   if(head.random != null){
      //     System.out.print(head.random.label);
      //   }else{System.out.print("null");}
      //   System.out.println("");
      //   head = head.next;
      // }




      // //136,137
      // int [] nums = {1,1,1,2,2,2,3,3,3,5,5,5,6,6};
      // System.out.println(slt.singleNumber(nums));
      // //134
      // int[] gas = {1,2,3,4,5};
      // int[] cost = {5,4,3,2,1};
      // System.out.println(slt.canCompleteCircuit(gas,cost));
      // 133
      // UndirectedGraphNode[] nodes = new UndirectedGraphNode[3];
      // for(int i = 0 ; i < 3 ; i ++){
      //   nodes[i] = new UndirectedGraphNode(i);
      // }
      //
      // nodes[0].neighbors.add(nodes[1]);
      // nodes[0].neighbors.add(nodes[2]);
      // nodes[1].neighbors.add(nodes[2]);
      // nodes[2].neighbors.add(nodes[2]);
      //
      //
      // UndirectedGraphNode ans = slt.cloneGraph(nodes[0]);
      // for(int i = 0 ; i < ans.neighbors.size(); i++){
      //   System.out.print(ans.neighbors.get(i).label +": ");
      //   for(int j = 0 ; j < ans.neighbors.get(i).neighbors.size(); j++){
      //     System.out.print(ans.neighbors.get(i).neighbors.get(j).label);
      //   }
      //   System.out.println();
      // }

      // //131
      // String s = "aabababsbabab";
      // List<List<String>> ans = slt.partition(s);
      // for(int i = 0 ; i < ans.size(); i++){
      //   for(int j = 0; j < ans.get(i).size(); j++){
      //     System.out.print(ans.get(i).get(j) + " ");
      //   }
      //   System.out.println("");
      // }
      // //129
      // char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
      // slt.solve(board);
      // for(int i = 0 ; i < board.length ; i ++ ){
      //   for(int j = 0 ; j < board[i].length; j++){
      //     System.out.print(board[i][j] + " ");
      //   }
      //   System.out.println("");
      // }
      // // 128
      // TreeNode t = new TreeNode(0);
      // t.left = new TreeNode(0);
      // t.right = new TreeNode(2);
      // t.left.left = new TreeNode(0);
      // t.left.left.right = new TreeNode(5);
      // t.right.right = new TreeNode(4);
      // t.right.right.right = new TreeNode(6);
      // //127
      // String beginWord = "hit";
      // String endWord = "cog";
      // List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
      // String beginWord = "a";
      // String endWord = "c";
      // List<String> wordList = Arrays.asList("a","b","c");
      //System.out.println(slt.sumNumbers(t));

      // String s = "....CP";
      //String s = "101";
      // System.out.println(slt.numDecodings(s));
      // TreeNode t = new TreeNode(1);
      // t.right = new TreeNode(2);
      // t.right.left = new TreeNode(3);
      // int n = 10;
      // int[] prices = {7, 1, 5, 3, 6, 4};
      // System.out.println(slt.isPalindrome(s));

      // int[][] all= {{-1}, {3, 2}, {-3, 1, -1}};
      // List<List<Integer>> triangle = new ArrayList<List<Integer>>();
      // for(int i = 0 ; i < all.length; i++ ){
      //   List<Integer> thisLine = new ArrayList<Integer>();
      //   for(int j = 0 ; j < all[i].length; j ++){
      //     thisLine.add(all[i][j]);
      //   }
      //   triangle.add(thisLine);
      // }
      // System.out.println(slt.minimumTotal(triangle));

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
