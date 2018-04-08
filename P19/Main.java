class Main {

    public static void main(String argvs[]){
      //String s = "       -2147483648awetgewyert";
      int n = 2;
      //int x=-2147447412;
      //int[] height = {1,2,5,4,5};
      //String s = "XXX";
      String[] strs = {"asd","as","asdf"};
      int[] arr = {1,2,3,4,5};
      ListNode head= new ListNode(0), lastListNode = new ListNode(0);
      for(int i=0;i<arr.length;i++){
        ListNode thisListNode = new ListNode(arr[i]);
        if(i==0)  head = thisListNode;
        else  lastListNode.next = thisListNode;
        lastListNode = thisListNode;
      }
      ListNode thisListNode = head;
      while(true){
        System.out.println(thisListNode.val);
        if(thisListNode.next == null) break;
        thisListNode = thisListNode.next;
      }
      Solution slt = new Solution();

      thisListNode = slt.removeNthFromEnd(head,n);
      while(true){
        System.out.println(thisListNode.val);
        if(thisListNode.next == null) break;
        thisListNode = thisListNode.next;
      }




      //int target = 1;

      //System.out.println(s.length()+"");
      //System.out.println(slt.removeNthFromEnd(arr,target));
    }
}
