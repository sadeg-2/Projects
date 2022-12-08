package DataStructure;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class recursion {
    public static void main(String[] ags) {
        //drawRuler(5,5);
//        int[] array = {1,2,3,3,5,5,6,6,8,9,10,11,11,12,13};
//        System.out.println(binarySearch(array,20,0,array.length-1));
//
        //optimal solution
//
//        System.exit(0);
//        int target = 10 ;
//        int left = 0 ;
//        int right = arr.length - 1 ;
//        while (left < right){
//            if (target == arr[left]+arr[right]){
//                System.out.println(left + " " + right);
//                break;
//            }else if (target > arr[left]+arr[right]){
//                left++;
//            }else if(target < arr[left]+arr[right]){
//                right--;
//            }
//        }
//
//        File x = new File("C:\\");
//        System.out.println(diskUsage(new File("E:\\")));
//            char[] a = {'h','e','l','l','o'};
//            char[] b = reverseChar(a);
//        System.out.println("the text after crypt :"+caesarCipher("caesar".toUpperCase(),'p'));
//        int [] arr = {10,7,4,2,1};
//        System.out.println("Day buying , day selling , MaxProfit : "+Arrays.toString(maxProfit(arr)));
        char[] a = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("the array : " + Arrays.toString(a));
        char[] b = reverseChar(a);
        System.out.println("the reverse array :" + Arrays.toString(b));
        int [] arr = {10,5,3,0};
        System.out.println("index min , index max , MaxProfit : "+Arrays.toString(maxProfit(arr)));
        System.out.println(riddle(new int[]{1,2,3,0},4));
        // 7-> 1 6 || 2 5
        // 6 -> 1 5 || 2 4
        //
    }
    public static int riddle (int  [] arr , int k){
        if (k==1)
            return arr[0];
        else {
            int temp = riddle(arr,k-1);
            if (temp <= arr[k-1])
                return temp;
            else
                return arr[k-1];
        }
    }

    public static char[] reverseChar(char[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }


    private static int[] maxProfit(int[] arr) {
        int min = arr[0];
        int indexMin = 0;
        int indexMax = 1;
        int max = arr[1] - arr[0];
        int selectMin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min > max) {
                max = arr[i] - min;
                indexMax = i;
                indexMin = selectMin;
            }
            if (arr[i] < min) {
                selectMin = i;
                min = arr[i];
            }
        }
        return new int[]{indexMin, indexMax, max};
    }

    public static String caesarCipher(String str, char key) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i)))
                temp += (char) ('a' + (str.charAt(i) + Character.toLowerCase(key) - 2 * 'a') % 26);
            else
                temp += (char) ('A' + (str.charAt(i) + Character.toUpperCase(key) - 2 * 'A') % 26);
        }
        return temp;
    }

    public static int findMaxProfit(int[] prices) {
        int min = prices[0];
        int indexOfmin = 0;
        int indexOfmax = 1;
        int max = prices[indexOfmax] - prices[indexOfmin];
        int m = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
                indexOfmax = i;
            }
            if (min > prices[i]) {
                min = prices[i];
                indexOfmin = i;
            }
            //حاولت في الشرط هادى للحالة يلي قولتك اباها ماظبط
            /*/if (max==0){
                if (min-prices[prices.length-1-i] < m) {
                    m = prices[i] - min;
                    System.out.println(min + "m = "+ m);
                    indexOfmax = i;
                }
                if (min > prices[i] && i != prices.length - 1) {
                min = prices[i];
                indexOfmin = i;
                }

            }*/
        }
        System.out.println(indexOfmax + " " + indexOfmin);
        return max;
    }

    static void deleteAllFile(File file, String type) {
        if (file.isFile())
            if (file.getName().endsWith(type)) {
                System.out.println(file.getName() + " is deleted");
                //file.delete();
            }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null)
                return;
            for (int i = 0; i < list.length; i++) {
                File temp = new File(file.getPath() + "\\" + list[i]);
                deleteAllFile(temp, type);
            }
        }
    }

    public static long diskUsage(File root) {
        long total = root.length(); // start with direct disk usage
        if (root.isDirectory()) { // and if this is a directory,
            if (root.list() == null)
                return 0;
            for (String childname : root.list()) { // then for each child
                File child = new File(root, childname); // compose full path to child
                total += diskUsage(child); // add child’s usage to total
            }
        }
        System.out.println(total + "\t" + root); // descriptive output
        return total;
    }

    static void reverse(ArrayList<Integer> array) {
        if (array.size() < 2)
            return;
        Integer temp = array.remove(0);
        reverse(array);
        array.add(temp);
    }

    public static int getFibonacci(int k) {
        if (k == 1 || k == 0)
            return 1;
        return getFibonacci(k - 1) + getFibonacci(k - 2);

    }

    public static boolean binarySearch(int[] array, int target, int low, int high) {
        if (low > high)
            return false;
        else {
            int mid = (low + high) / 2;
            if (array[mid] == target)
                return true;
            else {
                if (array[mid] > target)
                    return binarySearch(array, target, low, mid - 1);
                else
                    return binarySearch(array, target, mid + 1, high);
            }
        }
    }

    public static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0); // draw inch 0 line and label
        for (int j = 1; j <= nInches; j++) {
            drawInterval(majorLength - 1); // draw interior ticks for inch
            drawLine(majorLength, j); // draw inch j line and label
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) { // otherwise, do nothing
            drawInterval(centralLength - 1); // recursively draw top interval
            drawLine(centralLength); // draw center tick line (without label)
            drawInterval(centralLength - 1); // recursively draw bottom interval
        }
    }

    private static void drawLine(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++)
            System.out.print("-");
        if (tickLabel >= 0)
            System.out.print(" " + tickLabel);
        System.out.print("\n");
    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }
}
