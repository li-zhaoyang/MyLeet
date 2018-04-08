import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public boolean checkExist(List<List<Integer>> all, int a,int b, int c){
      for(int i=0;i<all.size();i++){
        boolean notSame = false;
        if(all.get(i).get(0) != a || all.get(i).get(1) != b || all.get(i).get(2) != c){
          notSame=true;
        }
        if(notSame) continue;
        return true;
      }
      return false;
    }
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> all = new ArrayList<List<Integer>>();
      int a=0;
      int b=0;
      int c=0;
      boolean first = true;
      for(int i=0;i<nums.length-2;i++){
        int j=i+1;
        int k=nums.length-1;
        while(j<k){
          if(nums[i]+nums[k]+nums[j]==0){
            if(!first){
              if(a==nums[i] && b==nums[j] && c==nums[k]){
                k--;
                j++;
                continue;
              }
              a=nums[i];
              b=nums[j];
              c=nums[k];
            }
            if(first){
              first = false;
              a=nums[i];
              b=nums[j];
              c=nums[k];
            }
            if(!checkExist(all,nums[i],nums[j],nums[k])){
              List<Integer> thisL = new ArrayList<Integer>();
              thisL.add(nums[i]);
              thisL.add(nums[j]);
              thisL.add(nums[k]);
              all.add(thisL);
            }
            k--;
            j++;
          }
          if(nums[j]+nums[k]>-nums[i]){
            k--;
          }
          if(nums[j]+nums[k]<-nums[i]){
            j++;
          }
        }
      }

      return all;



    }
}
