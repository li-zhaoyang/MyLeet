class Solution {
    public int strStr(String haystack, String needle) {
      boolean success = true;
      for(int i = 0; i < haystack.length() - needle.length() + 1 ; i++){
        success = true;
        for(int j=0; j< needle.length() ; j++){
          if( needle.charAt(j) != haystack.charAt(i+j) ){
            success = false;
          }
        }
        if(success == true) return i;
      }
      return -1;
    }
}
