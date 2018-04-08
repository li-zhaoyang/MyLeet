import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
      List<Integer> list = new ArrayList(nums.length);
      HashMap<Integer,Integer> mHashMap = new HashMap<Integer, Integer>();
      for(int num:nums){
        if(!mHashMap.containsKey(num)){
          mHashMap.put(num,1);
        }else{
          if(mHashMap.get(num) == 2){  mHashMap.remove(num);}
          else{ mHashMap.put(num,mHashMap.get(num)+1); }
        }
      }
      Iterator it = mHashMap.keySet().iterator();
      while (it.hasNext()) {
          return (int) it.next();
          //it.remove(); // avoids a ConcurrentModificationException
        }
      return -1;
    }
}
