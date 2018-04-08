class Solution {
    public int findIntegers(int num) {
       StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
       int n = sb.length();
       int a[] = new int[n];
       int b[] = new int[n];
       a[0] = 1;
       b[0] = 1;
       for (int i = 1; i < n; i++) {
         a[i] = a[i - 1] + b[i - 1];
         b[i] = a[i - 1];
       }
       int sum = a[n - 1] + b[n - 1];
       for (int i = 1; i < n; i++) {
         if (sb.charAt(i - 1) == '1' && sb.charAt(i) == '1')  break;
         if (sb.charAt(i - 1) == '0' && sb.charAt(i) == '0') sum -= b[n - i - 1];
       }
       return sum;
    }
}
