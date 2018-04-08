import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {
      if(nums == null)  return "";
      if(nums.length == 0)  return "";
      List<String> stringsOfNums = new ArrayList<String>();
      for(int num : nums){
        stringsOfNums.add(num + "");
      }
      Collections.sort(stringsOfNums,new SortForBigger());
      StringBuffer ansSB = new StringBuffer();
      for(int i = stringsOfNums.size() - 1; i >= 0 ; i--){
        ansSB.append(stringsOfNums.get(i));
      }
      if(ansSB.charAt(0) == '0') return "0";
      return ansSB.toString();
    }
    class SortForBigger implements Comparator<String>{
    // Used for sorting in ascending order of
    // roll number
      public int compare(String a, String b){
        String s1 = a + b;
        String s2 = b + a;
        return s1.compareTo(s2);
      }
    }

}
