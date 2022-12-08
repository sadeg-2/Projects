package MyProject;

import java.util.Scanner;

public class GG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a month number: ");
        int monthNumber = input.nextInt();
        System.out.print("Input a year : ");
        int year = input.nextInt();
        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
        String name_of_month = "";
        int numberOfDays = 0 ;
        switch (monthNumber) {
            case 1:
                name_of_month = "January";
                numberOfDays = 31 ;
                break;
            case 2:
                name_of_month = "February";
                numberOfDays = (isLeapYear)? 29 : 28 ;
                break;
            case 3:
                name_of_month = "March";
                numberOfDays = 31 ;
                break;
            case 4:
                name_of_month = "April";
                numberOfDays = 30 ;
                break;
            case 5:
                numberOfDays = 31 ;
                name_of_month= "May";
                break;
            case 6:
                numberOfDays = 30 ;
                name_of_month = "June";
                break;
            case 7:
                numberOfDays = 31 ;
                name_of_month = "July";
                break;
            case 8:
                numberOfDays = 31 ;
                name_of_month = "August";
                break;
            case 9:
                numberOfDays = 30 ;
                name_of_month = "September";
                break;
            case 10:
                numberOfDays = 31 ;
                name_of_month = "October";
                break;
            case 11:
                numberOfDays = 30 ;
                name_of_month = "November";
                break;
            case 12:
                numberOfDays = 31 ;
                name_of_month = "December";
                break;
            default:
                name_of_month = "Invalid month.";
                break;
        }
        System.out.printf("Expected Output :%s 2016 has %d days",name_of_month,numberOfDays);
    }

}
