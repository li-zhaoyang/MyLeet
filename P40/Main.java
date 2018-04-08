class Main {
    public static void main(String argvs[]){
      //String s = "       -2147483648awetgewyert";
      int n = 10;
      int a = 126851231;
      int b = 3;
      //int x=-2147447412;
      //int[] height = {1,2,5,4,5};
      String s1 = "asdfgXXafgd";
      String s2 = "XasdgX";
      String[] strs = {"asd","as","asdf"};
      int[] arr = {1,1,1};
      Solution slt = new Solution();
      int target = 2;
      String[] boardS = {".87657321","2........","3........","4........","5........","6........","7........","8........","9........"};
      // // char [][] board= new char[9][9];
      // // for(int i = 0; i < boardS.length ; i++){
      // //   for(int j = 0 ; j < boardS[i].length(); j++){
      // //     board[i][j] = boardS[i].charAt(j);
      // //   }
      // }


      //System.out.println(s.length()+"");
      //System.out.println(slt.nextPermutation(arr));
      System.out.println(slt.combinationSum2(arr,target));
      //System.out.println( slt.countAndSay(n) );

    }
}
