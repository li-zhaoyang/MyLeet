import java.util.*;
class Solution {
    public List<String> addOperators(String num, int target) {
      if (num == null || num.length() == 0) return new ArrayList<String>();
      HashMap<Integer, List<Integer>> multiplyRes = new HashMap<Integer, List<Integer>>();
      HashMap<Integer, List<String>> multiplyStr = new HashMap<Integer, List<String>>();
      int l = num.length();
      multiplyHelper(multiplyRes, multiplyStr, 0, l - 1, num);
      List<String> ans = new ArrayList<String>();
      addMinusHelper(ans, multiplyRes, multiplyStr, 0, 0, "", l, target);
      return ans;
    }

    //1. compute all number or multiply answer
    //2. dfs search all plus or minus answer

    private void multiplyHelper(HashMap<Integer, List<Integer>> multiplyRes, HashMap<Integer, List<String>> multiplyStr, int start, int end, String num) {
      int l = num.length();
      int key = start * l + end;
      if (multiplyRes.containsKey(key)) return ;
      multiplyRes.put(key, new ArrayList<Integer>());
      multiplyStr.put(key, new ArrayList<String>());
      if (end == start || num.charAt(start) != '0'){
        int thisNum;
        try {
          thisNum = Integer.parseInt(num.substring(start, end + 1));
          multiplyRes.get(key).add(thisNum);
          multiplyStr.get(key).add(num.substring(start, end + 1));
        } catch (NumberFormatException e) {

        }
      }
      if (start == end) return ;
      for (int i = start; i < end; i++) {
        multiplyHelper(multiplyRes, multiplyStr, start, i, num);
        multiplyHelper(multiplyRes, multiplyStr, i + 1, end, num);
        // int key1 = start * l + i;
        int key2 = (i + 1) * l + end;
        int thisNumLeft;
        if (start == i || num.charAt(start) != '0') {
          try {
            thisNumLeft = Integer.parseInt(num.substring(start, i + 1));
          } catch (NumberFormatException e) {
            continue;
          }
        } else continue;
        String thisStrLeft = num.substring(start, i + 1);
        for (int k = 0; k < multiplyRes.get(key2).size(); k++) {
          int thisNumRight = multiplyRes.get(key2).get(k);
          String thisStrRight = multiplyStr.get(key2).get(k);
          multiplyRes.get(key).add(thisNumLeft * thisNumRight);
          multiplyStr.get(key).add(thisStrLeft + "*" + thisStrRight);
        }
      }
    }

    private void addMinusHelper(List<String> ans, HashMap<Integer, List<Integer>> multiplyRes, HashMap<Integer, List<String>> multiplyStr, int start, int lastAns, String lastStr, int l, int target) {
      if (start == l) {
        if (lastAns == target) ans.add(lastStr);
        return ;
      }
      for (int i = start; i < l; i++) {
        int key = start * l + i;
        for (int j = 0; j < multiplyRes.get(key).size(); j++) {
          int thisNumLeft = multiplyRes.get(key).get(j);
          String thisStrLeft = multiplyStr.get(key).get(j);
          if (start == 0) addMinusHelper(ans, multiplyRes, multiplyStr, i + 1, lastAns + thisNumLeft, thisStrLeft, l, target);
          else addMinusHelper(ans, multiplyRes, multiplyStr, i + 1, lastAns + thisNumLeft, lastStr + "+" + thisStrLeft, l, target);
          if (start != 0) addMinusHelper(ans, multiplyRes, multiplyStr, i + 1, lastAns - thisNumLeft, lastStr + "-" + thisStrLeft, l, target);
        }
      }
    }


}
