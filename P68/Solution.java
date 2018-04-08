import java.util.*;
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
      int L = maxWidth, l = words.length, posInLine = 0, thisLineStartIndex = 0;
      List<String> ans = new ArrayList<String>();
      if(words == null || words.length == 0)  {
        StringBuffer thisNullLineSB = new StringBuffer();
        ans.add(fillUp(thisNullLineSB, L).toString());
        return ans;
      }
      for(int i = 0 ; i < l ; i++){
        if(posInLine + words[i].length() + 1 > L){
          int thisLineWordsNum = i - thisLineStartIndex;
          StringBuffer thisLineSB = new StringBuffer(words[thisLineStartIndex]);
          if(thisLineWordsNum == 0){
            ans.add(fillUp(thisLineSB, L).toString());
            posInLine = 0;
            thisLineStartIndex = i + 1;
            continue;
          }
          if(thisLineWordsNum == 1){
            ans.add(fillUp(thisLineSB, L).toString());
            posInLine = 0;
            thisLineStartIndex = i;
            i--;
            continue;
          }
          char[] shorterItv = new char[(L - posInLine + thisLineWordsNum -1 ) / (thisLineWordsNum - 1)];
          Arrays.fill(shorterItv, ' ');
          for(int j = 0 ; j < thisLineWordsNum - 1; j++){
            if(j < (L - posInLine + thisLineWordsNum -1) % (thisLineWordsNum - 1))  thisLineSB.append(' ');
            thisLineSB.append(shorterItv);
            thisLineSB.append(words[thisLineStartIndex + j + 1]);
          }
          ans.add(thisLineSB.toString());
          posInLine = 0;
          thisLineStartIndex = i;
          i--;
          continue;
        }
        if(posInLine == 0){
          posInLine += words[i].length();
        }
        else posInLine += (1 + words[i].length());
      }
      if(thisLineStartIndex == l) return ans;
      StringBuffer lastLineSB = new StringBuffer(words[thisLineStartIndex]);
      for(int i = thisLineStartIndex + 1; i < l; i ++){
        lastLineSB.append(' ');
        lastLineSB.append(words[i]);
      }
      ans.add(fillUp(lastLineSB, L).toString());
      return ans;
    }

    private StringBuffer fillUp(StringBuffer lastLineSB, int L){
      for( int i = lastLineSB.length(); i < L; i++){
        lastLineSB.append(' ');
      }
      return lastLineSB;
    }
}
