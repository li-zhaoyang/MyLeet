// import java.util.*;
public class Solution {
    public String reverseWords(String s) {
      if(s == null) return null;
      int l = s.length();
      if(l == 0)  return s;
      char[] charArray = s.toCharArray();
      reverseCharSequenceBetweenIJ(charArray, 0, l);
      int startIndex = -1;
      int charCount = 0, wordCount = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) ==' ') {
          if (startIndex == -1) continue;
          else {
            wordCount++;
            reverseCharSequenceBetweenIJ(charArray, startIndex, i);
            startIndex = -1;
          }
        } else {
          charCount++;
          if (startIndex != -1) continue;
          else {
            startIndex = i;
          }
        }
      }
      if (startIndex != -1) {
        wordCount++;
        reverseCharSequenceBetweenIJ(charArray, startIndex, l);
      }


      return new String(charArray);
    }

    public void reverseCharSequenceBetweenIJ(char[] charArray, int i, int j) {
      j--;
      while (i < j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        i++;
        j--;
      }
    }
}
