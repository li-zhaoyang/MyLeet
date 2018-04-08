import java.util.*;
class Main {
    public static void main(String argvs[]){
      Solution slt = new Solution();
      int[] arr = {1, 2, 3};
      List<List<Integer>> ans = slt.permute(arr);
      for (int i = 0; i < ans.size(); i++) {
        for (int j = 0; j < ans.get(i).size(); j++) {
          System.out.print(ans.get(i).get(j) + " ");
        }
        System.out.println();
      }
      //System.out.println(s.length()+"");
      System.out.println(slt.permute(arr));
      // for(int i =0 ;i<arr.length; i++){
      //   System.out.println(arr[i]);
      // }

    }
}
