class Solution {
    public int maxArea(int[] height) {
      int MAX = 0;

      int l = height.length;
      int i=0,j=l-1;
      for(;i<j;){
        for(;j>i;){
          int areaIJ = Math.min(height[i],height[j])*(j-i);
          //System.out.println(i+" "+j+" "+areaIJ);
          if(areaIJ>MAX) MAX = areaIJ;
          if(height[i]<height[j]) i++;
          else j--;
        }
      }
      return MAX;

    }
}
