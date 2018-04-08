class Solution {
    public boolean wordPattern(String pattern, String str) {
      if (pattern == null || str == null)  return false;
      if (pattern.length() == 0 && str.length() == 0) return true;
      if (pattern.length() == 0 || str.length() == 0) return false;
      String[] words = str.split(" ");
      if (pattern.length() != words.length) return false;
      HashMap<Character, String> map = new HashMap<Character, String>();
      HashMap<String, Character> reverseMap = new HashMap<String, Character>();
      for (int i = 0; i < pattern.length(); i++) {
        if (map.containsKey(pattern.charAt(i))) {
          if (!map.get(pattern.charAt(i)).equals(words[i])) return false;
        } else {
          map.put(pattern.charAt(i), words[i]);
        }
        if (reverseMap.containsKey(words[i])) {
          if (reverseMap.get(words[i]) != pattern.charAt(i)) return false;
        } else {
          reverseMap.put(words[i], pattern.charAt(i));
        }
      }
      return true;
    }
}
