import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.nio.charset.Charset;

public class test {
    public static void main(String[] args) {
//        String[] a = separation("Test#Test#","#");
//        System.out.println(Arrays.toString(a));
//        for (int i = 0; i <= 9; i++) {
//            //   1
//            for (int j = 0; j < 9; j++) {
//                if (i < j) {
//                    System.out.print((9 - i) + " ");
//                } else
//                    System.out.print((9 - j) + " ");
//            }
//            //    2
//            for (int j = 9; j >= 0; j--) {
//                if (i < j) {
//                    System.out.print((9 - i) + " ");
//                } else
//                    System.out.print((9 - j) + " ");
//            }
//            System.out.println();
//        }
//        for (int i = 1; i <= 9; i++) {
//            //  3
//            for (int j = 9; j > 0; j--) {
//                if (i < j) {
//                    System.out.print(j + " ");
//                } else
//                    System.out.print(i + " ");
//            }
//            // 4
//            for (int j = 0; j <= 9; j++) {
//                if (i < j) {
//                    System.out.print(j + " ");
//                } else
//                    System.out.print(i + " ");
//            }
//            System.out.println("");
//        }
//        long totalSeconds = System.currentTimeMillis() / 1000;
//        long currentSeconds = totalSeconds % 60;
//
//        long totalMinutes = totalSeconds / 60;
//        long currentMinute = totalMinutes % 60;
//
//        long totalHour = totalMinutes / 60;
//        long currentHour = totalHour % 24;
//
//        System.out.println(currentHour + " : " + currentMinute + " : " + currentSeconds);
//        System.out.println(Math.ceil(3.4));
        int sount = 0 ;
        for (int i = 1000; i <= 9999; i++) {
            if (i%9 ==0)
                sount++;
        }
        System.out.println(sount);

    }

    public static String[] separation(String str, String regex) {
        for (int i = 0; i < regex.length(); i++) {
            str = str.replaceAll(regex.charAt(i) + "", "8x8" + regex.charAt(i) + "8x8");
        }
        return str.split("8x8");
    }
}
