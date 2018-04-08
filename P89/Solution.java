import java.util.*;
class Solution {
    public List<Integer> grayCode(int n) {
      List<Integer> thisGrayCode = new ArrayList<Integer>();
      if(n == 0) {
        thisGrayCode.add(0);
        return thisGrayCode;
      }
      if(n == 1) {
        thisGrayCode.add(0);
        thisGrayCode.add(1);
        return thisGrayCode;
      }
      List<Integer> nextAns = grayCode(n - 1);
      List<Integer> nextAnsAdd = new ArrayList<Integer>(nextAns);
      for(int i = 0; i < nextAnsAdd.size(); i++){
        nextAnsAdd.set(i, nextAns.get(nextAns.size() - 1 -i) + (int) Math.pow(2, n-1)  );
      }
      thisGrayCode.addAll(nextAns);
      thisGrayCode.addAll(nextAnsAdd);
      return thisGrayCode;

    }
}
