class Solution {
    public String numberToWords(int num) {
      if (num == 0) return new String("Zero");
      StringBuffer sb = new StringBuffer();
      int i = 1000000000;
      while (num >= 1000) {
        if (num / i != 0) {
          sb.append(" ").append(numberToWords(num / i));
          if (i == 1000000000) sb.append(" Billion");
          else if (i == 1000000) sb.append(" Million");
          else if (i == 1000) sb.append(" Thousand");
        }
        num -= (num / i) * i;
        i /= 1000;
      }
      int hundred = num / 100;
      if (hundred != 0){
        sb.append(" ").append(oneDiditInt(hundred));
        sb.append(" Hundred");
      }
      num -= hundred * 100;
      int ten = num / 10;
      if (ten != 0 && ten != 1) sb.append(" ").append(tensOneDigit(ten));
      if (ten == 1) {
        sb.append(" ").append(teens(num));
        return sb.toString().trim();
      }
      num -= ten * 10;
      if (num != 0){
        sb.append(" ").append(oneDiditInt(num));
      }
      return sb.toString().trim();
    }
    private String oneDiditInt(int a) {
      String s = "";
      if (a == 1) s = "One";
      else if (a == 2)  s = "Two";
      else if (a == 3)  s = "Three";
      else if (a == 4)  s = "Four";
      else if (a == 5)  s = "Five";
      else if (a == 6)  s = "Six";
      else if (a == 7)  s = "Seven";
      else if (a == 8)  s = "Eight";
      else if (a == 9)  s = "Nine";
      return s;
    }
    private String tensOneDigit(int a) {
      String s = "";
      if (a == 2)  s = "Twenty";
      else if (a == 3)  s = "Thirty";
      else if (a == 4)  s = "Forty";
      else if (a == 5)  s = "Fifty";
      else if (a == 6)  s = "Sixty";
      else if (a == 7)  s = "Seventy";
      else if (a == 8)  s = "Eighty";
      else if (a == 9)  s = "Ninety";
      return s;
    }
    private String teens(int a) {
      String s = "";
      if (a == 10)  s = "Ten";
      else if (a == 11) s = "Eleven";
      else if (a == 12)  s = "Twelve";
      else if (a == 13)  s = "Thirteen";
      else if (a == 14)  s = "Fourteen";
      else if (a == 15)  s = "Fifteen";
      else if (a == 16)  s = "Sixteen";
      else if (a == 17)  s = "Seventeen";
      else if (a == 18)  s = "Eighteen";
      else if (a == 19)  s = "Nineteen";
      return s;
    }
}
