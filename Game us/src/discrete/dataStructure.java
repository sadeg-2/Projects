package discrete;

import java.util.Arrays;
import java.util.Scanner;

public class dataStructure {
    
    public static void main(String[] args) throws Exception {
        System.out.println("  Q 1 ");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of X : ");
        int x = input.nextInt();
        multiplication(x);
        System.out.print("Enter the value of Y : ");
        int y = input.nextInt();
        multiplication(y);
        System.out.println("\n Q 2 ");
        findSingleElement(1,1,2,2,3,3,4,4,5);
    }
    private static void multiplication(int x) {
        long multiplication = 1 ;
        for (int i = 1; i <= x; i += 2) {
            multiplication *= i ;
        }
        System.out.println("the multiplication of " + x + " is " +multiplication);
    }

    private static void findSingleElement(int... x) {
        int left = 0, right = x.length - 1, mid = x.length / 2;
        int index_symbol = 0;
        while (left < right) {
            System.out.println("times");
            if (x[mid] == x[mid + 1] && mid % 2 == 0 || (x[mid] == x[mid - 1] && mid % 2 != 0)) {
                left = mid + 1;//5
            } else
                right = mid - 1;
            mid = (right - left) / 2 + left;
            boolean b = x.length - 1 != mid && x[mid + 1] != x[mid];
            if (b && (mid == 0 || (mid == left))) {
                if (mid != 0 && x[mid - 1] == x[mid]) {
                    index_symbol = mid + 1;
                    break;
                }
                index_symbol = mid;
                break;
            } else if (left == mid && left == right) {
                System.out.println("No Single Number");
                System.exit(0);
            } else
                index_symbol = right;
        }
        System.out.println("the number is : " + x[index_symbol]);
    }


    public static int findWeezyNumber2(int[] array) throws Exception{
        int hare = 0;
        int tortoise = 0;

        do {
            tortoise = array[tortoise];
            System.out.println("t "+tortoise);
            hare = array[hare];
            System.out.println( "h1 "+hare);
            hare = array[hare];
            System.out.println("h2 "+hare);
        } while (hare != tortoise);

        tortoise = 0;
        while (tortoise != hare) {
            tortoise = array[tortoise];
            hare = array[hare];
            System.out.println("t " + tortoise);
            System.out.println("h " + hare);
        }

        return tortoise;
    }
    public static int findWeezyNumber1(int[] array) {
        int weezy =1;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]==array[j]){
                    weezy=array[i];
                }
            }
        }
        return weezy;

    }
    private static int findWeezyNumber(int... arr) {
        for (int i = 0; i < arr.length -1 ; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    return arr[i];
            }
        }
        return 0 ;
    }

    static int check(int []arr , int k){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k)
                return i ;
        }
        return -1 ;
    }

    static boolean checkForPositiveProduct(int... arr){

        for(int i= 0; i< arr.length; i++){
            if(arr[i] % 2 == 0) return true;
        }

        return false;
    }

}
