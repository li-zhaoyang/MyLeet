import java.util.*;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      List<Integer> ans = new ArrayList<Integer>();
      if (nums == null || nums.length == 0 || k == 0) return ans;
      int n = nums.length;
      HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
      List<Integer>[] buckets = new List[n + 1];
      for (int num: nums)
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
      for (int key: countMap.keySet()) {
        int thisCount = countMap.get(key);
        if (buckets[thisCount] == null) {
          buckets[thisCount] = new ArrayList<Integer>();
        }
        buckets[thisCount].add(key);
      }
      for (int i = n; i > 0; i--) {
        if (buckets[i] == null) continue;
        boolean needBreak = false;
        for (int j = 0; j < buckets[i].size(); j++) {
          ans.add(buckets[i].get(j));
          if (ans.size() == k) {
            needBreak = true;
            break;
          }
        }
        if (needBreak) break;
      }
      return ans;
    }

}
