class Solution {
    public String countAndSay(int n) {
      if(n == 0)  return "";
      if(n == 1)  return "1";
      if(n == 2)  return "11";
      int j = 0;
      StringBuffer thisSB = new StringBuffer("");
      String lastS = countAndSay(n-1);
      for(int i = 0 ; i < lastS.length(); i++){
        j = 1;
        if(lastS.length() == i+1){
          thisSB.append(j);
          thisSB.append(lastS.charAt(i));
          break;
        }
        while(lastS.charAt(i) == lastS.charAt(i+1)){
          j++;
          i++;
          if(lastS.length() == i+1) break;
        }
        thisSB.append(j);
        thisSB.append(lastS.charAt(i));
      }
      String s = thisSB.toString();
      return s;


    }
}
