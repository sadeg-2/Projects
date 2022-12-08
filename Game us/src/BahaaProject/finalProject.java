package BahaaProject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.Array;
import java.util.Scanner;

/**
 *
 * @author bahaa
 */
public class finalProject {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int n = 2 , javaCount = 0,mathCount=0;
        String[] usernameLIn = new String[n];
        String[] passwordLIn = new String[n];
        usernameLIn[0] = "bahaa";
        passwordLIn[0] = "1234";
        usernameLIn[1] = "a";
        passwordLIn[1] = "12345";

        String[] questions = {"which of the following operatore has more precedance in java?",
                "__________ is used to find and fix bugs in the java program",
                "java is a_____ language" , "which data tupe value is returned by all transcondental math function?",
                "which package contains the random class?"};

        String[] answers = {"1./ \n2.+ \n3.-",
                "1.Jre \n2.Jdb \n3.Jdk",
                "1.high level \n2.low level \n3.other",
                "1.int \n2.float \n3.double","1.java.util package \n2.java.lang package \n3.java.awt package"};
        /*for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }*/


        String[] operations = {"*","/","+","-"};


        /*System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\t\t Welcome to task maker \n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ ");
        System.out.println("You are ?? \n a.admin \n b.student \n press q to exit");
        char you = in.nextLine().charAt(0);*/
        boolean x = true ;
        while(x){
            menu();
            char you = in.nextLine().charAt(0);
            switch (you) {
                case 'a' :
                    System.out.println("\t\t********************************\n\t\t\t    Hi Admin\n\t\t********************************");
                    System.out.print("Enter User name : ");
                    String username = in.nextLine();
                    System.out.print("Enter Password : ");
                    String password = in.nextLine();
                    while (!adminlogin(username,password,usernameLIn,passwordLIn)){
                        System.out.println("Wrong user or password !");
                        System.out.println("***************************************");
                        System.out.print("Enter User name : ");
                        username = in.nextLine();
                        System.out.print("Enter Password : ");
                        password = in.nextLine();
                    }
                    boolean adminLogin = true ;
                    while(adminLogin){
                        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\t\t" +
                                " Hi " + username +
                                "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                        System.out.println("a. add an admin \nb.delete an admin \nc.search for an admin \nd.show all admins \ne.add a question \nf.show all qeuestions \nj.delete a qustion \npress q to back");
                        char admin = in.nextLine().charAt(0);
                        switch (admin){
                            case 'a':
                                n++;
                                System.out.print("Enter new user name : ");
                                String NewUsername = in.nextLine();
                                System.out.print("Enter new Password : ");
                                String NewPassword = in.nextLine();

                            /*String[] newArray = new String[usernameLIn.length+1];
                            newArray[0] = NewUsername;
                            for (int i = 1; i < newArray.length; i++) {
                                newArray[i]= usernameLIn[i-1];
                            }*/
                                usernameLIn = newadminUser(usernameLIn , NewUsername);
                                passwordLIn = newadminPassword(passwordLIn , NewPassword) ;
                                System.out.print("admins : ");
                                for (int i = 0; i < usernameLIn.length; i++) {
                                    System.out.print(usernameLIn[i]+"  ");
                                }
                                System.out.print("\nPasswords : ");
                                for (int i = 0; i < passwordLIn.length; i++) {
                                    System.out.print(passwordLIn[i]+"  ");
                                }
                                System.out.println();
                                break ;

                            case 'b':
                                System.out.println("Enter the admin user name : ");
                                String adminusername = in.nextLine();
                                usernameLIn = deleteadmin(usernameLIn , adminusername);
                                System.out.println("The user Exist now is : ");
                                for (int i = 0; i < usernameLIn.length; i++) {
                                    System.out.print(usernameLIn[i]);
                                }
                                System.out.println();

                            case 'c':
                                System.out.print("Enter the admin name : ");
                                String adminName = in.nextLine();
                                for (int i = 0; i < usernameLIn.length; i++) {
                                    if (adminName.equalsIgnoreCase(usernameLIn[i])) {
                                        System.out.println("Yes, "+adminName+" is an admin");
                                        break;}
                                    if (!adminName.equalsIgnoreCase(usernameLIn[i])) {
                                        System.out.println("No, "+adminName+" is not an admin");
                                        break;
                                    }
                                }

                            case 'd' :
                                for (int i = 0; i < usernameLIn.length; i++) {
                                    System.out.print(usernameLIn[i]+" ");}
                                break;

                            case 'e' :
                                System.out.println("Enter a new qusetion : ");
                                String newquestion = in.nextLine();
                                questions = addQuestion(questions,newquestion);
                                for (int i = 0; i < questions.length; i++) {
                                    System.out.println(questions[i]);}
                                break;

                            case 'f' :
                                for (int i = 0; i < questions.length; i++) {
                                    System.out.println(questions[i]);}
                                break;

                            case 'j' :
                                System.out.println("Enter the question number : ");
                                int qNum = Integer.parseInt(in.nextLine());
                                questions = deleteQuestion(questions,qNum);
                                for (int i = 0; i < questions.length; i++) {
                                    System.out.println(questions[i]);}

                                break;

                            case 'q' :
                                adminLogin = false ;
                                break;

                        }
                    }
                    break;
                case 'b':
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\t\t           Hi Student \n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                    System.out.println("a. java exam \nb. math exam \npress q to back ...");
                    char exam = in.next().charAt(0);
                    switch (exam){
                        case 'a' : System.out.println("Welcome to Java exam \nchoose The correct answer : ");
                            for (int i = 0; i < 1 ; i++) {
                                System.out.println((i+1) + "-" + questions[i]);
                                System.out.println(answers[i]);
                                int answer1 = in.nextInt();
                                if (answer1 == 1) {
                                    javaCount++;}

                            }
                            for (int i = 1; i < 2 ; i++) {
                                System.out.println((i+1) + "-" + questions[i]);
                                System.out.println(answers[i]);

                                int answer2 = in.nextInt();
                                if (answer2 == 3) {
                                    javaCount++;}

                            }
                            for (int i = 2; i < 3 ; i++) {
                                System.out.println((i+1) + "-" + questions[i]);
                                System.out.println(answers[i]);

                                int answer3 = in.nextInt();
                                if (answer3 == 1) {
                                    javaCount++;}

                            }
                            for (int i = 3; i < 4 ; i++) {
                                System.out.println((i+1) + "-" + questions[i]);
                                System.out.println(answers[i]);

                                int answer4 = in.nextInt();
                                if (answer4 == 3) {
                                    javaCount++;}

                            }
                            for (int i = 4; i < 5 ; i++) {
                                System.out.println((i+1) + "-" + questions[i]);
                                System.out.println(answers[i]);

                                int answer5 = in.nextInt();
                                if (answer5 == 1) {
                                    javaCount++;}


                            }
                            if (javaCount >= 3) {
                                System.out.println("Congratulation, you passed, Your Score is :" + javaCount);

                            }
                            else System.out.println("Sorry, you failed, Your Score is :" + javaCount);
                            break;

                        case 'b' :
                            System.out.println("Welcome to Math exam");
                            int ans;

                            int num1,num2;



                            for (int i = 0; i < operations.length; i++) {
                                num1 = (int)(Math.random()*10);
                                num2 = (int)(Math.random()*10);
                                System.out.print("How much is : " + num1+operations[i]+num2 + " = ");

                                if (i ==0){


                                    int ans1 = in.nextInt();
                                    ans = num1*num2;
                                    if (ans1==ans)
                                        mathCount++;

                                }

                                else if (i==1){
                                    System.out.print("(without) = ");
                                    ans = num1/num2;
                                    int ans2 = in.nextInt();

                                    if (ans==ans2)
                                        mathCount++;
                                }

                                else if (i==2){

                                    ans = num1+num2;
                                    int ans3 = in.nextInt();
                                    if (ans==ans3)
                                        mathCount++;
                                }

                                else {

                                    ans = num1-num2;
                                    int ans4 = in.nextInt();
                                    if (ans==ans4)
                                        mathCount++;}
                            }
                            if (mathCount>=2)
                                System.out.println("Congratulation, You passed and your score is : " + mathCount);
                            else System.out.println("Sorry, You failed and your score is : " + mathCount);
                            break;

                        default :

                            break ;

                    }
                case 'q' :
                    x = false ;
                    break;
            }

        }


    }
    public static void menu(){
        Scanner in =new Scanner(System.in);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\t\t Welcome to task maker \n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ ");
        System.out.print("You are ?? \n a.admin \n b.student \n press q to exit.....");
    }

    public static boolean adminlogin(String username, String password,String[] usernameLIn,String[] passwordLIn){


        for (int i = 0; i < usernameLIn.length; i++) {
            if (username.equalsIgnoreCase(usernameLIn[i]))
                if (password.equalsIgnoreCase(passwordLIn[i]))
                    return true;


        }
        return false;



    }
    public static String[] newadminUser(String[] arrayu,String newusername){
        String[] newArray = new String[arrayu.length+1];
        newArray[0] = newusername;
        for (int i = 1; i < newArray.length; i++) {
            newArray[i]= arrayu[i-1];

        }
        return newArray;
    }
    public static String[] newadminPassword(String[] arrayu,String newusername){
        String[] newArray = new String[arrayu.length+1];
        newArray[0] = newusername;
        for (int i = 1; i < newArray.length; i++) {
            newArray[i]= arrayu[i-1];

        }
        return newArray;
    }
    public static String[] deleteadmin(String[] arrayu,String username){
        for (int i = 0; i < arrayu.length; i++) {
            if (username.equalsIgnoreCase(arrayu[i])) {
                arrayu[i]= arrayu[arrayu.length-1] ;
                 break;
            }
        }
        String[] temp = new String[arrayu.length-1];
        System.arraycopy(arrayu,0,temp,0,arrayu.length-1);
        return temp;
    }
    public static String[] addQuestion(String array[] ,String newquestion){
        String newArray[]  = new String[array.length+1];
        array[0] = newquestion;
        for (int i = 1; i < newArray.length; i++) {
            newArray[i] = array[i-1];
        }
        return newArray;
    }
    public static String[] deleteQuestion(String[] array,int question){
        for (int i = 0; i < array.length; i++) {
            if (question== i+1) {
                array[i]= null ;
            }
        }
        return array;
    }

}
