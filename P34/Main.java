class Main {
    public static void main(String argvs[]){
      //String s = "       -2147483648awetgewyert";
      int n = 99;
      int a = 126851231;
      int b = 3;
      //int x=-2147447412;
      //int[] height = {1,2,5,4,5};
      String s1 = "asdfgXXafgd";
      String s2 = "XasdgX";
      String[] strs = {"asd","as","asdf"};
      int[] arr = {2,2,3,3,8,8,8,8,8,9,9};
      Solution slt = new Solution();
      int target = 8;
      //System.out.println(s.length()+"");
      //System.out.println(slt.nextPermutation(arr));
      //System.out.println(slt.searchRange(arr,target));
      arr = slt.searchRange(arr,target);
      for(int i =0 ;i<arr.length; i++){
        System.out.println(arr[i]);
      }

    }
}
