public class Solution {
    public void connect(TreeLinkNode root) {
      if(root == null)  return;
      TreeLinkNode thisInLayer = root;
      while(true){
        TreeLinkNode nextLayerLeft = findNextLayerFirst(thisInLayer);
        if(nextLayerLeft == null) return;
        while(thisInLayer != null){
          TreeLinkNode nextT = findRightInNextLayer(thisInLayer);
          if(thisInLayer.left != null){
            if(thisInLayer.right != null){
              thisInLayer.left.next = thisInLayer.right;
              if(nextT == null) break;
              thisInLayer.right.next = findChild(nextT);
              thisInLayer = nextT ;
              continue;
            }
            if(nextT == null) break;
            thisInLayer.left.next = findChild(nextT);
            thisInLayer = nextT ;
            continue;
          }
          if(thisInLayer.right != null){
            if(nextT == null) break;
            thisInLayer.right.next = findChild(nextT);
            thisInLayer = nextT ;
            continue;
          }
          if(nextT != null){
            thisInLayer = nextT ;
            continue;
          }
          break;
        }
        thisInLayer = nextLayerLeft;
      }
    }

    public TreeLinkNode findNextLayerFirst(TreeLinkNode tree){
      TreeLinkNode nextLayerLeft = null;
      while(tree != null){
        if(tree.left != null) return tree.left;
        if(tree.right != null)  return tree.right;
        tree = tree.next;
      }
      return null;
    }

    private TreeLinkNode findRightInNextLayer(TreeLinkNode thisInLayer){
      while(thisInLayer.next != null){
        if(thisInLayer.next.left != null) return thisInLayer.next;
        if(thisInLayer.next.right != null)  return thisInLayer.next;
        thisInLayer = thisInLayer.next;
      }
      return null;
    }
    private TreeLinkNode findChild(TreeLinkNode t){
      if(t.left != null)  return t.left;
      return t.right;
    }
}
