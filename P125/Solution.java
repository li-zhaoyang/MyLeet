class Solution {
    public boolean isPalindrome(String s) {
      int l = s.length();
      if(l == 0 || l == 1)  return true;
      int start = 0, end = l - 1;
      s = s.toLowerCase();
      System.out.println(s);
      while(true){
        while(!( (s.charAt(start) - 'a' >= 0 && s.charAt(start) - 'a' <= 25) || (s.charAt(start) - '0' >= 0 && s.charAt(start) - '0' <= 9))){
          start++;
          if(start == l)  break;
        }
        while(!( (s.charAt(end) - 'a' >= 0 && s.charAt(end) - 'a' <= 25) || (s.charAt(end) - '0' >= 0 && s.charAt(end) - '0' <= 9)))  {
          end--;
          if(end == 0)  break;
        }
        if(start >= end) break;
        if(s.charAt(start) != s.charAt(end))  return false;
        start++;
        end--;
      }
      return true;
    }
}
