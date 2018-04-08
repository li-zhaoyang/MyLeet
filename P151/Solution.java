import java.util.*;
public class Solution {
    public String reverseWords(String s) {
      if(s == null) return null;
      int l = s.length();
      if(l == 0)  return s;
      String[] words = s.trim().split(" +");
      String temp ;
      l = words.length;
      for(int i = 0 ; i < l/2; i++){
        temp = words[i];
        words[i] = words[l - i - 1];
        words[l - i - 1] = temp;
      }
      //
      //
      // char[] chars = s.toCharArray();
      // char c;
      // for(int i = 0 ; i < l/2 ; i++){
      //   c = chars[i];
      //   chars[i] = chars[l-i-1];
      //   chars[l - i - 1] = c;
      // }
      // String ans = new String(chars);
      // String[] words = ans.trim().split(" +");
      StringBuffer sb = new StringBuffer();
      boolean start = true;
      for(String word: words){
        if(start){
          sb.append(word);
          start = false;
          continue;
        }
        sb.append(" ").append(word);
        // System.out.println(word);
      }
      return sb.toString();
    }
}
