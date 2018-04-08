import java.util.*;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      List<Integer> ans = new ArrayList<Integer>();
      if (nums == null || nums.length == 0 || k == 0) return ans;
      int n = nums.length;
      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> (b.getValue() - a.getValue()));
      HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
      for (int num: nums) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
      }
      for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
        pq.offer(entry);
      }
      for (int i = 0; i < k; i++) {
        ans.add(pq.poll().getKey());
      }
      return ans;
    }

}
