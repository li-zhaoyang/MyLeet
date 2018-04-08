class Solution {
    public String intToRoman(int num) {
      int i=0,j=0;
      int[] nums={0,0,0,0,0,0,0};
      char[] c = {'M','D','C','L','X','V','I'};
      //StringBuffer sb = new StringBuffer("");
      StringBuffer[] s = new StringBuffer[7];
      for(i=0;i<7;i++){
        s[i] = new StringBuffer("");
      }
      String all = new String("");

      int devided = 1000;
      for(i=0;i<7;){
        nums[i] = num/devided;
        num = num-nums[i]*devided;
        if(i%2==0 && i<6){
          if(num*10/devided==9){
            nums[i+1]=0;
            //num[i+2]=0;
            s[i+1].append(c[i+2]);
            s[i+1].append(c[i]);
            i+=2;
            devided/=10;
            num-= 9*devided;
            continue;
          }
          if(num*10/devided ==4){
            nums[i+1]=0;
            //num[i+2]=0;
            s[i+2].append(c[i+2]);
            s[i+2].append(c[i+1]);
            i+=2;
            devided/=10;
            num-= 4*devided;
            continue;
          }
        }
        if(i%2==0) devided/=2;
        else devided/=5;
        i++;
      }


      for(i=0;i<7;i++){
        for(j=0;j<nums[i];j++){
          s[i].append(c[i]);
        }
      }


      for(i=0;i<7;i++){
        all.append(s[i]);
      }

      return all;

    }
}
