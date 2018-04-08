// import java.util.*;
public class Solution {
    public String reverseWords(String s) {
      if(s == null) return null;
      int l = s.length();
      if(l == 0)  return s;
      char[] charArray = s.toCharArray();
      reverseCharSequenceBetweenIJ(charArray, 0, l);
      int startIndex = 0;
      for (int i = 0; i < l; i++) {
        if (charArray[i] ==' ') {
            reverseCharSequenceBetweenIJ(charArray, startIndex, i);
            startIndex = i + 1;
        }
      }
      reverseCharSequenceBetweenIJ(charArray, startIndex, l);
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
