import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> bracketLists = new ArrayList();
      if(n==0) return bracketLists;
      if(n==1){
        bracketLists.add("()");
        return bracketLists;
      }
      Stack stack = new Stack();
      return writeS(bracketLists,stack,n);
    }
    List<String> writeS(List<String> bracketLists, Stack stack, int n){
      if(n == 0){
        List<String> thisBracketLists = new ArrayList();
        StringBuffer s = new StringBuffer(),a = new StringBuffer(")");
        for(int i =0;i<stack.size();i++){
          s.append(a);
        }
        for(int i =0;i<bracketLists.size();i++){
          thisBracketLists.add(bracketLists.get(i)+s);
        }
        return thisBracketLists;
      }
      if(stack.empty()){
        stack.push(1);
        List<String> thisBracketLists = new ArrayList();
        if(bracketLists.size()==0){
          thisBracketLists.add("(");
        }
        else{
          for(int i=0;i<bracketLists.size();i++){
            thisBracketLists.add(bracketLists.get(i)+"(");
          }
        }
        return writeS(thisBracketLists,stack,n-1);
      }
      else{
        Stack thisStack = (Stack)stack.clone();
        stack.push(1);
        List<String> thisBracketLists1 = new ArrayList();
        for(int i=0;i<bracketLists.size();i++){
          thisBracketLists1.add(bracketLists.get(i)+"(");
        }
        List<String> thisToAdd1 = writeS(thisBracketLists1,stack,n-1);
        thisStack.pop();
        List<String> thisBracketLists2 = new ArrayList();
        for(int i=0;i<bracketLists.size();i++){
          thisBracketLists2.add(bracketLists.get(i)+")");
        }
        List<String> thisToAdd2 = writeS(thisBracketLists2,thisStack,n);
        thisToAdd1.addAll(thisToAdd2);
        return thisToAdd1;
      }
    }
}
