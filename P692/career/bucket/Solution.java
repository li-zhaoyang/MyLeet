import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      int n = words.length;
      HashMap<String, Integer> count = new HashMap<String, Integer>();
      for (String word: words) {
        count.put(word, count.getOrDefault(word, 0) + 1);
      }
      ArrayList<String>[] countBuckets = new ArrayList[n];
      for (String s: count.keySet()) {
        int thisCount = count.get(s);
        if (countBuckets[thisCount - 1]  == null) {
           countBuckets[thisCount - 1] = new ArrayList<String>();
        }
        ArrayList<String> thisCountStringList = countBuckets[thisCount - 1];
        thisCountStringList.add(s);
      }
      ArrayList<String> ans = new ArrayList<String>();
      for (int i = n - 1; i >= 0; i--) {
        if (countBuckets[i] == null)  continue;
        Collections.sort(countBuckets[i]);
        for (String s: countBuckets[i]) {
          ans.add(s);
          if (ans.size() == k)  return ans;
        }
      }
      return ans;
    }
}
