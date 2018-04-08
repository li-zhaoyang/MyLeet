class Solution {
    public String longestCommonPrefix(String[] strs) {
      int n = strs.length;
      if(n==0) return "";
      if(n==1) return strs[0];
      boolean end = false;
      char charCMP =' ';
      int i=0;
      for(i=0;;i++){
        if(i == strs[0].length() ) break;
        charCMP = strs[0].charAt(i);
        for(int j=1;j<n;j++){
          if(i == strs[j].length()){
            end = true;
            break;
          }
          if(strs[j].charAt(i) != charCMP){
            end = true;
            break;
          }
        }
        if(end) break;
      }

      return strs[0].substring(0,i);

    }
}
