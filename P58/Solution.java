class Solution {
    public int lengthOfLastWord(String s) {
      boolean counting = false;
      int count = 0;
      for(int i = s.length()-1 ; i >= 0 ; i--){
        if(counting){
          if(s.charAt(i) == ' ')  return count;
          count++;
          continue;
        }
        if(s.charAt(i) != ' ')  {
          counting = true;
          count++;
        }
      }
      return count;

    }
}
