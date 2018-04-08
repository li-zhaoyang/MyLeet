 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     @Override
     public String toString() {
       if (left == null && right == null) return val + "";
       String leftStr = "*";
       String rightStr = "*";
       if (left != null) leftStr = left.toString();
       if (right != null) rightStr = right.toString();
       StringBuffer sb = new StringBuffer();
       sb.append('(').append(val).append(' ').append(leftStr).append(' ').append(rightStr).append(')');
       return sb.toString();
     }
 }
