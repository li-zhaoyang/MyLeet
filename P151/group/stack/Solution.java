import java.util.*;
public class Solution {
    public String reverseWords(String s) {
      if(s == null) return null;
      int l = s.length();
      if(l == 0)  return s;
      int startIndex = -1;
      Stack<String> stringStack = new Stack<String>();
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) ==' ') {
          if (startIndex == -1) continue;
          else {
            stringStack.push(s.substring(startIndex, i));
            startIndex = -1;
          }
        } else {
          if (startIndex != -1) continue;
          else {
            startIndex = i;
          }
        }
      }
      if (startIndex != -1) stringStack.push(s.substring(startIndex));
      StringBuffer sb = new StringBuffer();
      boolean start = true;
      while (!stringStack.isEmpty()) {
        String word = stringStack.pop();
        if(start){
          sb.append(word);
          start = false;
        }
        else sb.append(" ").append(word);
      }
      return sb.toString();
    }
}
