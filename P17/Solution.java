import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList();
      for(int i =0 ;i<digits.length(); i++){
        List<String> thisTemp = new ArrayList();
        //System.out.println(lettersInNum(digits.charAt(i)).length);
        for(int j=0; j<lettersInNum(digits.charAt(i)).length ; j++){
          if(result.size() == 0){
            thisTemp.add( Character.toString(lettersInNum(digits.charAt(i))[j]) );
          }
          else{
            for(int k=0; k<result.size(); k++){
              //System.out.println("here!");
              thisTemp.add(result.get(k) + lettersInNum(digits.charAt(i))[j]);
            }
          }

        }
        result = new ArrayList(thisTemp);;
        thisTemp.clear();

      }
      return result;

    }
    public char[] lettersInNum(char numS){
      int num = numS-'0';
      if( num == 2 ){
        char[] ans = {'a', 'b', 'c'};
        return ans;
      }
      else if(num == 3){
        char[] ans = {'d', 'e', 'f'};
        return ans;
      }
      else if(num == 4){
        char[] ans  = {'g','h','i'};
        return ans;
      }
      else if(num == 5 ){
        char[] ans  = {'j','k','l'};
        return ans;
      }
      else if(num == 6){
        char[] ans  = {'m','n','o'};
        return ans;
      }
      else if(num == 7){
        char[] ans  = {'p','q','r','s'};
        return ans;
      }
      else if(num == 8){
        char[] ans  = {'t','u','v'};
        return ans;

      }
      else if(num == 9){
        char[] ans  = {'w','x','y','z'};
        return ans;
      }
      else{
        char[] ans  = {};
        return ans;
      }

    }
}
