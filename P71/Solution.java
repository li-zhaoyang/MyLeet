import java.util.*;
class Solution {
    public String simplifyPath(String path) {
      List<String> dirList = new LinkedList<String>();
      int depth = 0;
      for(int i = 0; i < path.length(); ){
        if(path.charAt(i) == '/'){
          i++;
          continue;
        }
        int j = i+1;
        for(; j< path.length(); j++){
          if(path.charAt(j) == '/')  break;
        }
        String dirName = path.substring(i,j);
        if(dirName.compareTo("..") == 0){
          if(depth > 0){
            dirList.remove(dirList.size()-1);
            depth--;
          }
          i = j;
          continue;
        }
        if(dirName.compareTo(".") == 0){
          i = j;
          continue;
        }
        dirList.add(dirName);
        depth++;
        i = j;
      }
      StringBuffer sb = new StringBuffer("/");
      for(int i = 0; i < depth; i++){
        sb.append(dirList.get(i));
        if(i != depth-1)  sb.append("/");
      }
      return  sb.toString();
    }
}
