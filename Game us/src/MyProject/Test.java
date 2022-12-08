package MyProject;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Lottery
        /*
        int num = (int)(10 + Math.random()*90);
        //98
        int guess1 = num/10;
        int guess2 = num%10;

        System.out.print("Enter Your Guess Number : ");
        int answer = input.nextInt();

        int user1 = answer/10;
        int user2 = answer%10;

        if (num == answer){
            System.out.println("You win 10,000");
        }else if (guess1 == user2 && guess2==user1){
            System.out.println("You win 5,000");
        }else if(guess1== user1 || guess1==user2 || guess2==user1 || guess2 == user2){
            System.out.println("You win 1,000");
        }else{
            System.out.println("You Lose ");
        }
        System.out.println("the number is " + num);
        */

        // Subtraction Quiz
        /*
        int num1 = (int)(Math.random()*50) ;// 40
        int num2 = (int)(Math.random()*50) ;// 50

        if (num1 < num2){
            int temp = num2 ;
            num2 = num1 ;
            num1 = temp ;
        }
        System.out.print(num1 +"-" + num2 + "? ");
        int answer = input.nextInt();

        if (answer == (num1 - num2)){
            System.out.println("Excellent ");
        }else{
            System.out.println("the true answer is " + (num1 - num2));
        }
        */

        // Methods in Math Class
        /*
        System.out.println(Math.sin(Math.toRadians(30)));
        System.out.println(Math.tan(Math.toRadians(0)));
        System.out.println(Math.toDegrees(Math.asin(0.5)));
        System.out.println(Math.PI + " " + Math.E);
        System.out.println(Math.exp(0));
        System.out.println(Math.log(Math.E));
        System.out.println(Math.log10(1));
        System.out.println(Math.pow(125,1/3.0));
        System.out.println(Math.ceil(5.0000000001));
        System.out.println(Math.floor(5.999999999));
        System.out.println(Math.rint(5.5));
        System.out.println(Math.round(5.5));
        System.out.println(Math.max(5,8));
        System.out.println(Math.min(5.0,2));
        System.out.println(Math.abs(-5));
        System.out.println((int)(Math.random()*50 + 50));
        System.out.println((int)(Math.random()*50));
        */


        //Switch Case
        /*
        int num = 5 ;
        switch (num) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Invalid value");
                break;
        }
        */

    }
}
