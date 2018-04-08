import java.util.*;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      List<Integer> ans = new ArrayList<Integer>();
      if (nums == null || nums.length == 0 || k == 0) return ans;
      HashMap<Integer, List<Integer>> countToIntListMap = new HashMap<Integer, List<Integer>>();
      List<Integer> countList = new ArrayList<Integer>();
      Arrays.sort(nums);
      int count = 0;
      int l = nums.length;
      for (int i = 0; i < l; i++) {
        if (i != 0 && nums[i] != nums[i - 1]) {
          addNumCountToListAndMap(nums[i - 1], count, countList, countToIntListMap);
          count = 1;
        } else {
          count++;
        }
      }
      addNumCountToListAndMap(nums[l - 1], count, countList, countToIntListMap);
      Collections.sort(countList);
      Collections.reverse(countList);
      for (int i = 0; i < countList.size(); i++) {
        if (i > 0 && countList.get(i) == countList.get(i - 1)) continue;
        List<Integer> thisCountNumsList = countToIntListMap.get(countList.get(i));
        boolean breakThis = false;
        for (int j = 0; j < thisCountNumsList.size(); j++) {
          ans.add(thisCountNumsList.get(j));
          if (ans.size() == k) {
            breakThis = true;
            break;
          }
        }
        if (breakThis)  break;
      }
      return ans;
    }

    private void addNumCountToListAndMap(int num, int count, List<Integer> countList, HashMap<Integer, List<Integer>> countToIntListMap) {
      if (!countToIntListMap.containsKey(count)) {
        List<Integer> thisCountList = new ArrayList<Integer>();
        thisCountList.add(num);
        countToIntListMap.put(count, thisCountList);
      } else {
        countToIntListMap.get(count).add(num);
      }
      countList.add(count);
    }
}
