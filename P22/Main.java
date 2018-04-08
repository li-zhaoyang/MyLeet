import java.util.*;
class Main {
    public static void main(String argvs[]){
      String s = "[[[{}()]]]";
      int n = 3;
      //int x=-2147447412;
      //int[] height = {1,2,5,4,5};
      //String s = "XXX";
      String[] strs = {"asd","as","asdf"};
      int[] arr = {1, 0, -1, 0, -2, 2};
      Solution slt = new Solution();
      int target = 0;
      //System.out.println(s.length()+"");
      //System.out.println(slt.generateParenthesis(n));
      List<String> sL = slt.generateParenthesis(n);
      for(int i=0;i< sL.size();i++){
        System.out.println(sL.get(i));
      }
    }
}
