import java.sql.SQLOutput;
import java.util.Scanner;

public class library {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int countOfBook = 0 ;
        String[] nameOfBook = new String[100];
        String[] numberOfBook = new String[100];
        program :
        while(true){
            System.out.println("---------------------------------");
            System.out.println("            Librarian            ");
            System.out.println("---------------------------------");
            System.out.println("What do you want : ");
            System.out.println("1. add book \n2. view all book \n3. search a book\n4. close a program");
            System.out.print("Enter Your choice : ");
            int choice = input.nextInt();
            switch (choice){
                case 1 :
                    System.out.print("Enter name the book : ");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.print("Enter the number of book : ");
                    String number = input.next();
                    if (searchBook(nameOfBook,name,countOfBook))
                        System.out.println("The book is already exit ");
                    else {
                        nameOfBook[countOfBook] = name ;
                        numberOfBook[countOfBook] = number ;
                        countOfBook++;
                        System.out.println("add book successfully");
                    }
                    break ;
                case 2 :
                    viewAllBook(countOfBook, nameOfBook, numberOfBook);
                    break ;
                case 3 :
                    System.out.print("Enter the name of book : ");
                    input.nextLine();
                    String nameB = input.nextLine();
                    System.out.println(searchBook(nameOfBook, nameB,countOfBook) ? "found it " : "not found");
                    break ;
                case 4 :
                    break program;
            }
        }

    }

    private static void viewAllBook(int countOfBook, String[] nameOfBook, String[] numberOfBook) {
        if (countOfBook ==0)
            System.out.println("No exist any book , add book to show it ");
        for (int i = 0; i < countOfBook; i++) {
            System.out.printf("%d. %s %s \n",(i+1), nameOfBook[i], numberOfBook[i]);
        }
    }

    public static boolean searchBook(String[] book, String name , int countOfBook){
        for (int i = 0; i < countOfBook; i++) {
            if (book[i].equals(name))
                return true ;
        }
        return false;
    }
}
