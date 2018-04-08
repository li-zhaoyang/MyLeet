import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "";
        while (in.hasNext()) {
            s = in.next();
        }
        String[] numsStr = s.split(":");
        int hour = Integer.parseInt(numsStr[0]) % 12;
        int minute = Integer.parseInt(numsStr[1]);
        double angleHour = (hour + (double) minute / 60.0) * 30;
        double angleMinute = minute * 6;
        java.text.DecimalFormat   df1   = new   java.text.DecimalFormat("#.0");
        double rawAngle = Math.abs(angleHour - angleMinute);
        double angle = rawAngle > 180? 360 - rawAngle: rawAngle;
        String outString = df1.format(angle).toString();
        int l = outString.length();
        if (outString.charAt(l - 1) == '0')
            outString = outString.substring(0, l - 2);
        System.out.println(outString);


    }
}
