class Main {

    public static void main(String argvs[]){


      Solution slt = new Solution();

      int n = 1;
      int k = 1;
      ListNode[] nodes = new ListNode[n];

      for(int i = 0 ; i < n ; i++){
        nodes[i] = new ListNode(i);
        if(i >0)  nodes[i - 1].next = nodes[i];
      }
      ListNode thisNode = slt.reverseKGroup(nodes[0], k);
      while(thisNode != null){
        System.out.println(thisNode.val);
        thisNode = thisNode.next;
      }

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
