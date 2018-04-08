// import java.util.*;
public class Solution {
    public String reverseWords(String s) {
      if(s == null) return null;
      int l = s.length();
      if(l == 0)  return s;
      char[] charArray = s.toCharArray();
      reverseCharSequenceBetweenIJ(charArray, 0, l);
      int startIndex = -1;
      int charCount = 0;
      for (int i = 0; i < l; i++) {
        if (charArray[i] ==' ') {
          if (startIndex == -1) continue;
          else {
            // charCount++;
            reverseCharSequenceBetweenIJ(charArray, startIndex, i);
            charCount += i - startIndex + 1;
            startIndex = -1;
          }
        } else {
          // charCount++;
          if (startIndex != -1) continue;
          else {
            startIndex = i;
          }
        }
      }
      if (startIndex != -1) {
        reverseCharSequenceBetweenIJ(charArray, startIndex, l);
        charCount += l - startIndex + 1;
      }
      charCount -= 1;
      if (charCount <= 0) return new String();  //if blank
      char[] newCharArray = new char[charCount];
      int newIndex = 0;
      boolean inWord = false;
      for (int i = 0; i < l; i++) {
        if (charArray[i] == ' ') {
          if (inWord) {
            //Attention, if the program trys to add ' ' after last word in new array, it will exceed limit, so we check
            if (newIndex == charCount) break;
            newCharArray[newIndex++] = ' ';
            inWord = false;
          }
        } else {
          newCharArray[newIndex++] = charArray[i];
          inWord = true;
        }
      }
      return new String(newCharArray);
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
