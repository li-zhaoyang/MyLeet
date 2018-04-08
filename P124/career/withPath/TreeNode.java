 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     public String print() {
       if (left == null && right == null) return val.toString();
       String leftStr = "*";
       String rightStr = "*";
       if (left != null) leftStr = left.print();
       if (right != null) rightStr = right.print();
       StringBuffer sb = new StringBuffer();
       sb.append('(').append(leftStr).append(' ').append(val).append(' ').append(rightStr).append(')');
       return sb.toString();
     }
 }
