import java.util.*;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      List<String> ans = new ArrayList<String>();
      if (words == null || words.length == 0 || k == 0) return ans;
      int l = words.length;
      ArrayList<String>[] buckets = new ArrayList[l + 1];
      for (int i = 0; i <= words.length; i++)  buckets[i] = new ArrayList<String>();
      HashMap<String, Integer> count = new HashMap<String, Integer>();
      for (String word: words)  count.put(word, count.getOrDefault(word, 0) + 1);
      for (String word: count.keySet()) buckets[count.get(word)].add(word);
      for (int i = l; i >= 0; i--) {
        Collections.sort(buckets[i]);
        for (String word: buckets[i]) {
          ans.add(word);
          if (ans.size() == k)  return ans;
        }
      }
      return ans;
    }
}
