class Solution {
    public int compareVersion(String version1, String version2) {
      String[] splittedVersion1s = version1.split("\\.");
      String[] splittedVersion2s = version2.split("\\.");
      int l1 = splittedVersion1s.length, l2 = splittedVersion2s.length;
      int versionLevelI1, versionLevelI2;
      for( int i = 0 ; ; i++ ){
        if(i == l1){
          if(i == l2) return 0;
          for(int j = i ; j < l2 ; j++ ){
            if(Integer.parseInt(splittedVersion2s[j]) != 0) return -1;
          }
          return 0 ;
        }
        if(i == l2){
          for(int j = i ; j < l1 ; j++ ){
            if(Integer.parseInt(splittedVersion1s[j]) != 0) return 1;
          }
          return 0;
        }
        versionLevelI1 = Integer.parseInt(splittedVersion1s[i]);
        versionLevelI2 = Integer.parseInt(splittedVersion2s[i]);
        if(versionLevelI1 > versionLevelI2) return 1;
        if(versionLevelI1 < versionLevelI2) return -1;
      }
    }


}
