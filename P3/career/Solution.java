class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s == null || s.length() == 0) return 0;
      int l = s.length();
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      int max = 0;
      int start = 0, end = 0;
      for (; end < l; end++) {
        if (map.containsKey(s.charAt(end))) {
          start = Math.max(start, map.get(s.charAt(end)) + 1);
        }
        map.put(s.charAt(end), end);
        max = Math.max(max, end - start + 1);
      }
      return max;
    }
}
