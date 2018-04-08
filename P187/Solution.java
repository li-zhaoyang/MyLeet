import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      List<String> ansList = new ArrayList<String>();
      if(s == null) return ansList;
      if(s.length() <= 10)  return ansList;
      int thisID = 0;
      for(int i = 0 ; i < 10 ; i ++){
        thisID += getNum(s.charAt(i)) * (int)Math.pow(4, 9-i);
      }
      Set<Integer> iDSet = new HashSet<Integer>();
      List<Integer> ansIDList = new ArrayList<Integer>();
      // Set<String> ans = new HashSet<String>();
      iDSet.add(thisID);
      for( int i = 1 ; i <= s.length() - 10; i++){
        thisID -= getNum(s.charAt( i - 1 )) * (int)Math.pow(4, 9);
        thisID *= 4;
        thisID += getNum(s.charAt( i + 9 ));
        if(iDSet.contains(thisID)){
          ansIDList.add(thisID);
          continue;
        }
        iDSet.add(thisID);
      }

      ansIDList = new ArrayList<Integer>(new HashSet<Integer>(ansIDList));

      for(int i = 0 ; i < ansIDList.size() ; i++){
        thisID = ansIDList.get(i);
        StringBuffer thisSB = new StringBuffer();
        for(int j = 9; j >= 0; j -- ){
          int thisNum = thisID/(int)Math.pow(4,j);
          thisSB.append(getChar(thisNum));
          thisID -= thisNum * (int)Math.pow(4,j);
        }
        ansList.add(thisSB.toString());
      }
      return ansList;

    }

    private int getNum(char c){
      switch(c){
        case 'A' : return 0;
        case 'C' : return 1;
        case 'G' : return 2;
        case 'T' : return 3;
        default :  return -1;
      }
    }

    private char getChar(int n){
      switch(n){
        case 0 : return 'A';
        case 1 : return 'C';
        case 2 : return 'G';
        case 3 : return 'T';
        default :  return ' ';
      }
    }


}
