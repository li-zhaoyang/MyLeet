import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      HashMap<Integer, List<StringBuffer>> triedAns = new HashMap<Integer, List<StringBuffer>>();
      List<String> ans = new ArrayList<String>();
      helperBreak( s, wordDict,  triedAns, 0);
      for(int i = 0 ; i < triedAns.get(0).size(); i++){
        ans.add(triedAns.get(0).get(i).toString());
      }
      return ans;
    }

    public List<StringBuffer> helperBreak(String s, List<String> wordDict,HashMap<Integer, List<StringBuffer>> triedAns , int pos){
      List<StringBuffer> ansFromThisPos = new ArrayList<StringBuffer>();
      List<StringBuffer> ansFromNextPos = null;
      for(int i = 0 ; i < wordDict.size(); i ++){
        String thisWord = wordDict.get(i);
        int thisLength = thisWord.length();
        int remainLength = s.length() - pos;
        if(remainLength < thisLength) continue;
        if(thisWord.equals(s.substring(pos, pos + thisLength))){
          if(thisLength == remainLength){
            ansFromThisPos.add(new StringBuffer(thisWord));
            continue;
          }
          if(triedAns.containsKey(pos + thisLength)) {
            ansFromNextPos = triedAns.get(pos + thisLength);
          }else{
            ansFromNextPos = helperBreak(s, wordDict, triedAns, pos+thisLength);
          }
          for(int j = 0 ; j < ansFromNextPos.size(); j++){
            ansFromThisPos.add(new StringBuffer().append(thisWord).append(" ").append(ansFromNextPos.get(j)));
          }
        }
      }
      triedAns.put(pos, ansFromThisPos);
      return ansFromThisPos;
    }


}
