public class Solution {
    public void connect(TreeLinkNode root) {
      if(root == null)  return;
      if(root.left == null) return;
      root.left.next = root.right;
      TreeLinkNode thisInLayer = root.left;
      while(true){
        if(thisInLayer.left == null){
          return;
        }
        TreeLinkNode nextLayerLeft = thisInLayer.left;
        while(thisInLayer != null){
          thisInLayer.left.next = thisInLayer.right;
          if(thisInLayer.next != null){
            thisInLayer.right.next = thisInLayer.next.left;
          }
          thisInLayer = thisInLayer.next;
        }
        thisInLayer = nextLayerLeft;
      }
    }
}
