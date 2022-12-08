package Course2;

import java.util.Date;
import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int random = 5 ;

        System.out.print("Enter the Gussy number (1 to 10 ) : ");
        int number = input.nextInt();
        if (number == random){
            System.out.println("Unbelievable you got it!");
        }else if (Math.abs(random - number) == 1){
            System.out.println("Oops , it's very soon!");
        }else if (Math.abs(random - number) ==2){
            System.out.println("It's soon!");
        }else{
            System.out.println("It's too far!");
        }


//        int n;
//        do {
//            System.out.print("Enter number (n!=5) : ");
//            n = input.nextInt();
//            System.out.println("n = " + n);
//        }while (n != 5);

//        for (int i = 0; i < 5; i++) {
//            System.out.print(i+"-");
//            for (int j = 0; j < 5; j++) {
//                if (i<j)
//                    System.out.print("   ");
//            }
//            for (int j = 0; j < 5; j++) {
//                if (i >= j)
//                    System.out.print(" * ");
//            }
//            System.out.println();
//        }
//        int count = 0 ;
//        while (true){
//            if (count==5){
//                count++;
//                continue;
//            }
//            if (count==10)
//                break;
//            System.out.println(count);
//            count++;
//        }
//        int min = getMin(10,20);
//        System.out.println(min);
//        info("Ahmad");
//        for (int i = 0; i < 3; i++) {
//            System.out.print("Enter Your year BirthDay : ");
//            int yb = input.nextInt();
//            if (getAge(yb) > 0){
//                System.out.println("Your Age is " + getAge(yb));
//            }else{
//                System.out.println("get out its not your year birthday ");
//            }
//
//        }
        //a b c d e
//        double price$ = 3.26 ;
//        System.out.print("Enter Your A count Dollars:  ");
//        double count = input.nextDouble();
//        System.out.println("the cash money in shekel is " + getMoney(price$,count) + " shekel");
//        int min = getMin(5,7);//5
//
//        String message = "Hello , we are want to go to party";
//        String deM = decrypt(message);
//        System.out.println(deM);
//        String inM = incrypt(deM);
//        System.out.println(inM);
//        int [] array = {5,8,9,3,6,5,4,7};
//        int[] array2 = new int[array.length];
//        System.arraycopy(array,1,array2,1,array.length-1);
//        //Arrays.sort(array);
//        sort(array);
//
//        int index = Arrays.binarySearch(array,8);
//        System.out.println(index);
//        System.out.println(Arrays.toString(array));
//        int max = maxArray(array2d[0]);
//        for (int i = 1; i < array2d.length; i++) {
//            if (maxArray(array2d[i]) > max)
//                max = maxArray(array2d[i]);
//        }
//        System.out.println(max);
//        int[] array = {7,6,7,5,3,2,5,56,5,5,9};
//        int[][] array2d = {{5,3,6,9},{2,3,6,9,10,99},{100,20,30,500}};
//        array2d[1][1] = 5 ;
//        for (int i = 0; i < array2d.length; i++) {
//            sort(array2d[i]);
//        }
//        int[][] copy = new int[array2d.length][];
//        for (int i = 0; i < array2d.length; i++) {
//            copy[i] = copy(array2d[i]);
//        }
//        print2d(copy);
//        System.out.println("*********************************");
//        sorts(array2d);
//        print2d(array2d);
//        System.out.println(5 + " : " + 10);
//        System.out.printf("%-2c : %-2.2f",'a',10.55555555555);


    }

    public static void sorts(int[][] array){
        for (int i = 0; i < array.length; i++) {
            int[] temp = array[i] ;
            int index = i ;
            for (int j = i; j < array.length; j++) {
                if (sum(temp) < sum(array[j])){
                    temp = array[j];
                    index=j;
                }
            }
            // index >> small sum
            // i >> current array
            if (index != i){
                array[index] = copy(array[i]);
                array[i] = copy(temp);
            }
        }
    }
    public static int sum(int[] array){
        int sum = 0 ;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        return sum ;
    }
    public static void print2d(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void counts(int[][] array){
        int size = 0 ;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                size++;
            }
        }
        int[] temp = new int[size];
        int index = 0 ;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                temp[index]=array[i][j];
                index++;
            }
        }
        counts(temp);

    }
    public static void counts(int[] array){
        System.out.println("  N  :  C  ");
        int max = maxArray(array);
        int min = minArray(array);
        for (int i = min ; i <= max; i++) {
            if (count(array,i) != 0){
                System.out.printf("  %d  :  %d  \n",i,count(array,i));
            }
        }
    }
    public static void counts2(int[] array){
        System.out.println("  N  :  C  ");
        sorts(array);
        for (int i = 0; i < array.length; i++) {
            int count = 0 ;
            for (int j = i; j <array.length ; j++) {
                if (i != 0 && array[i]==array[i-1]){
                    break;
                }
                if (array[j] == array[i]){
                    count++ ;
                }
            }
            if (count!=0){
                System.out.printf("  %d  :  %d  \n",array[i],count);
            }

        }
    }
    public static void counts3(int[] array){
        System.out.println("  N  :  C  ");
        for (int i = 0; i < array.length; i++) {
            if (getIndex(array,array[i],i) == -1 ){
                System.out.printf("  %d  :  %d  \n",array[i],count(array,array[i]));
            }
        }
    }
    public static int maxArray(int[]array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i]>max){
                max = array[i];
            }
        }
        return max ;
    }
    public static int minArray(int[]array){
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
    public static int count(int[] array, int k){
        int count = 0 ;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k){
                count++;
            }
        }
        return count ;
    }
    public static int[] copy(int[] array){
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        return temp ;
    }
    public static void sorts(int[] array){
        for (int i = 0; i < array.length; i++) {
            int temp = array[i] ;//2
            int index = i ;//5
            for (int j = i; j < array.length; j++) {
                if (array[j] < temp){
                    temp = array[j] ;
                    index = j ;
                }
            }
            if (index != i){
                array[index] = array[i];
                array[i] = temp ;
            }
        }
    }
    public static int lastIndex(int[] array , int k){
        for (int i = array.length -1; i >=0 ; i--) {
            if (array[i] == k)
                return i ;
        }
        return -1 ;
    }
    public static int getIndex(int[] array , int k, int end){
        for (int i = 0; i < end; i++) {
            if (array[i] == k)
                return i ;
        }
        return -1 ;
    }
    public static int max(int x1 , int x2){
        int max = 0 ;
        if (x1>x2){
            max = x1 ;
        }else {
            max = x2 ;
        }
        return max ;
    }
    public static int max(int x1 , int x2 , int x3){
        return max(x1,max(x2,x3)) ;
    }
    public static void printInfo(String name , int age , String numberPhone){
        System.out.println("Name : " + name + " Age : " + age + " Phone : " + numberPhone);
    }
    public static void sort(int [] array){
        for (int i = 0; i < array.length; i++) {
            int small = array[i];
            int index = i ;
            for (int j = i; j <array.length ; j++) {
                if (small > array[j]){
                    small = array[j];
                    index=j;
                }
            }
            if (index != i){
                int temp = array[i] ;
                array[i] = small ;
                array[index] = temp ;
            }
        }
    }
    public static int search(int[] array , int k){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k)
                return i ;
        }
        return -1 ;
    }
    public static int[] copyArray(int [] array){
        int [] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i] ;
        }
        return temp ;
    }
    public static  void printInf(int age , String name){
        System.out.println("Your Age is " + age + "And Your Name is " + name);
    }
    public static  void printInf(String age , String name){
        System.out.println("Your Age is " + age + "And Your Name is " + name);
    }
    public static void changeData(int[] x ){
        for (int i = 0; i < x.length; i++) {
            x[i] = 2*i+2 ;
        }
    }


    public static double getMoney(double price , double count){
        return price*count;
    }

    public static String decrypt(String text){
        String temp = "" ;
        for (int i = 0; i < text.length(); i++) {
            temp += (char)(text.charAt(i) + 4*i+2);
        }
        return temp ;
    }
    public static String incrypt(String text){
       String temp = "";
        for (int i = 0; i < text.length(); i++) {
            temp += (char)(text.charAt(i) - (4*i+2));
        }
        return temp;
    }


    public static int getAge(int yearBirthDay){
        return new Date().getYear() + 1900 - yearBirthDay ;
    }

    public static int getMin(int x1 , int x2){
        return (x1<x2)? x1:x2 ;
    }

    public static int getMax(int x1 , int x2){
        return (x1>x2)? x1:x2 ;
    }
    public static String reverse(String str){
        String temp = "" ;
        for (int i = str.length() - 1; i >= 0 ; i--) {
            temp += str.charAt(i);
        }
        return temp ;
    }
    public static boolean isPal (String str){
        return str.equals(reverse(str));
    }


    public static void info(String name){
        System.out.println("My name is " + name);
    }
}

