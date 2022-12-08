package LibrarySystem;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemLibrary {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library("Sadeg", "Sadeg5005");
        library.addBook("1234", "The Earth", "Jone");
        library.addBook("2345", "loop ", "kamel");
        library.addBook("3456", "The Science", "Saed");
        library.addUser("Sameer", "2356");
        library.addUser("Sadeg", "5678");

        String librarianText = "-------------------------------------\n"
                + "           Welcome " + library.getName_Librarian() + "\n"
                + "-------------------------------------\n"
                + "what do you want to do ? \n"
                + "A-Add Users \n" +
                "B- Add Books \n" +
                "C- issue book for users \n" +
                "D- returned books for user \n" +
                "E- View users \n" +
                "F- View books \n" +
                "G- View Issue books \n" +
                "H- View returned books \n" +
                "I- Remove book \n" +
                "J- Remove User \n" +
                "K- Change Librarian \n" +
                "L- Change bin Librarian \n" +
                "X-Log Out \n";
        char op;
        String idB;
        String nameUser;

        program:
        while (true) {
            System.out.println("Login As A : \nA- Librarian \nB- User/Student\nX- Exit  ");
            System.out.print("Enter Your choice : ");
            char login = Character.toUpperCase(input.next().charAt(0));
            switch (login) {
                case 'A':
                    System.out.print("Enter Your name : ");
                    String name = input.next();
                    System.out.print("Enter your bin : ");
                    String bin = input.next();
                    if (library.getName_Librarian().equals(name) && library.getBin().equals(bin)) {
                        Library:
                        while (true) {
                            System.out.println(librarianText);
                            System.out.print("Enter Your Choice : ");
                            op = input.next().charAt(0);
                            switch (op) {
                                case 'A':
                                    System.out.print("Enter the name of user : ");
                                    String nameU = input.next();
                                    System.out.print("Enter the bin for the user : ");
                                    String binU = input.next();
                                    if (library.addUser(nameU, binU)) {
                                        System.out.println("User added successfully");
                                    } else {
                                        System.out.println("User Already exist");
                                    }
                                    break;
                                case 'B':
                                    System.out.print("Enter the Id for book : ");
                                    idB = input.next();
                                    System.out.print("Enter the name of book : ");
                                    input.nextLine();
                                    String nameOfBook = input.nextLine();
                                    System.out.print("Enter the name of Author : ");
                                    String authorB = input.next();
                                    if (library.addBook(idB, nameOfBook, authorB)) {
                                        System.out.println("Book added successfully");
                                    } else {
                                        System.out.println("Book Id Already exist");
                                    }
                                    break;
                                case 'C':
                                    System.out.print("Enter the id of Book : ");
                                    idB = input.next();
                                    System.out.print("Enter The name of User : ");
                                    nameUser = input.next();
                                    if (library.issuedBook(idB, nameUser)) {
                                        System.out.println("Issue Book added successfully");
                                    } else {
                                        System.out.println("user Name or id of book is not exist");
                                    }
                                    break;
                                case 'D':
                                    System.out.print("Enter the id of book : ");
                                    idB = input.next();
                                    System.out.print("Enter the name of the user : ");
                                    nameUser = input.next();
                                    if (library.entriesReturnBook(idB, nameUser)) {
                                        System.out.println("The book has been returned successfully");
                                    } else {
                                        System.out.println("Id of book or name of user is wrong");
                                    }
                                    break;
                                case 'E':
                                    library.viewUsers();
                                    break;
                                case 'F':
                                    library.viewBooks();
                                    break;
                                case 'G':
                                    library.viewIssuedBook();
                                    break;
                                case 'H':
                                    library.viewReturnedBook();
                                    break;
                                case 'I':
                                    //remove book
                                    System.out.print("Enter the id for the book : ");
                                    idB = input.next();
                                    if (library.removeBook(idB))
                                        System.out.println("Remove Book successfully ");
                                    else
                                        System.out.println("id is wrong so Check the id ");
                                    break;
                                case 'J':
                                    //remove user
                                    System.out.print("Enter the name of user : ");
                                    nameUser = input.next();
                                    if (library.removeUser(nameUser))
                                        System.out.println("Remove user successfully");
                                    else
                                        System.out.println("The name is wrong so check the name of user ");
                                    break;
                                case 'K':
                                    //change librarian
                                    System.out.print("Enter the new name : ");
                                    String libraryName = input.next();
                                    System.out.print("Enter the bin for the librarian : ");
                                    String binL = input.next();
                                    library.setBin(binL);
                                    ;
                                    library.setName_Librarian(libraryName);
                                    break Library;
                                case 'L':
                                    //change bin
                                    System.out.print("Enter the old bin : ");
                                    String oldBin = input.next();
                                    if (oldBin.equals(library.getBin())) {
                                        System.out.print("Enter the new bin : ");
                                        String newBin = input.next();
                                        System.out.print("Enter the new bin again : ");
                                        String newBin2 = input.next();
                                        if (newBin.equals(newBin2)) {
                                            library.setBin(newBin);
                                            System.out.println("Change the bin for the librarian successfully ");
                                            break Library;
                                        } else {
                                            System.out.println("the two bin is not the  same ");
                                        }
                                    } else
                                        System.out.println("the bin that you enter is wrong");
                                    break;
                                case 'X':
                                    op = 'M';
                                    break Library;
                            }
                        }
                    }
                    break;
                case 'B':
                    System.out.print("Enter the name Of user : ");
                    nameUser = input.next();
                    System.out.print("Enter the bin : ");
                    String binUser = input.next();
                    User user = library.getUser(nameUser, binUser);
                    if (user == null) {
                        System.out.println("the name of user or the bin is false ");
                    } else {
                        user:
                        while (true) {
                            System.out.println(getStringUser(nameUser));
                            System.out.print("Enter Your Choice : ");
                            op = input.next().charAt(0);
                            switch (op) {
                                case 'A':
                                    library.showAvailableBook();
                                    break;
                                case 'B':
                                    user.viewIssuedBook();
                                    break;
                                case 'C':
                                    user.viewReturnedBook();
                                    break;
                                case 'D':
                                    System.out.print("Enter the old bin : ");
                                    String oldBin = input.next();
                                    if (oldBin.equals(binUser)) {
                                        System.out.print("Enter the new bin : ");
                                        String newBin = input.next();
                                        System.out.print("Enter the new bin again : ");
                                        String newBin2 = input.next();
                                        if (newBin.equals(newBin2)) {
                                            library.getUser(nameUser, binUser).setBin(newBin);
                                            System.out.println("Change the bin for the user successfully ");
                                            break user;
                                        } else {
                                            System.out.println("the two bin is not the  same ");
                                        }
                                    } else
                                        System.out.println("the bin that you enter is wrong");
                                    break;

                                case 'X':
                                    op = 'M';
                                    break user;

                            }
                        }
                    }
                    break;
                case 'X':
                    break program;
            }

        }
    }

    private static String getStringUser(String userName) {
        return "-------------------------------------\n"
                + "           Welcome " + userName + "\n"
                + "-------------------------------------\n" +
                "what do you want to do ? \n" +
                "A-View Available Books \n" +
                "B- View Issued Book \n" +
                "C- View Returned Book \n" +
                "D- Change bin \n" +
                "X-Log Out ";
    }
}

class Library {
    private String name_Librarian;
    private String bin;
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Book> issue_Book;
    private ArrayList<Book> returned_Book;

    public Library(String name_Librarian, String bin) {
        this.name_Librarian = name_Librarian;
        this.bin = bin;
        books = new ArrayList<>();
        users = new ArrayList<>();
        issue_Book = new ArrayList<>();
        returned_Book = new ArrayList<>();
    }

    public String getName_Librarian() {
        return name_Librarian;
    }

    public String getBin() {
        return bin;
    }

    public boolean addUser(String name, String bin) {
        for (User u : users) {
            if (u.getName().equals(name))
                return false;
        }
        users.add(new User(name, bin));
        return true;
    }

    public boolean addBook(String id, String name, String author) {
        for (Book b : books) {
            if (b.getId().equals(id))
                return false;
        }
        books.add(new Book(id, name, author));
        return true;
    }

    public boolean issuedBook(String id, String nameUser) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                for (User u : users) {
                    if (u.getName().equals(nameUser)) {
                        u.addBook(book);
                        issue_Book.add(book);
                        book.setAvailable(false);
                        book.setNameIssue(nameUser);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean entriesReturnBook(String id, String nameUser) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                for (User u : users) {
                    if (u.getName().equals(nameUser)) {
                        u.returnBook(b);
                        b.setAvailable(true);
                        b.setNameIssue("No one");
                        returned_Book.add(b);
                        issue_Book.remove(b);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void viewUsers() {
        if (users.size() == 0)
            System.out.println("No one");
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void viewBooks() {
        if (books.size() == 0)
            System.out.println(" No exist any book");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void viewIssuedBook() {
        if (issue_Book.size() == 0)
            System.out.println(" No exist any book");
        for (Book b : issue_Book) {
            System.out.println(b);
        }
    }

    public boolean removeBook(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                books.remove(b);
                return true;
            }
        }
        return false;
    }

    public boolean removeUser(String name) {
        for (User e : users) {
            if (e.getName().equals(name)) {
                users.remove(e);
                return true;
            }
        }
        return false;
    }

    public void setName_Librarian(String name_Librarian) {
        this.name_Librarian = name_Librarian;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public void viewReturnedBook() {
        if (returned_Book.size() == 0)
            System.out.println(" No exist any book");
        for (Book b : returned_Book) {
            System.out.println(b);
        }
    }

    public void showAvailableBook() {
        for (Book b : books) {
            if (b.isAvailable())
                System.out.println(b);
        }
    }

    public User getUser(String name, String bin) {
        for (User u : users) {
            if (u.getName().equals(name) && u.getBin().equals(bin))
                return u;
        }
        return null;
    }

}

class Book {
    private String id;
    private String name;
    private String author;
    private String nameIssue;
    private boolean available;

    public Book(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        available = true;
        nameIssue = "No one";
    }

    public String getNameIssue() {
        return nameIssue;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNameIssue(String nameIssue) {
        this.nameIssue = nameIssue;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id= '" + id + '\'' +
                ", name= '" + name + '\'' +
                ", author= '" + author + '\'' +
                ", available= " + ((available) ? "Yes" : "No") +
                ", Issue for =" + nameIssue + '}';
    }
}

class User {
    private String name;
    private String bin;
    private ArrayList<Book> issueBook;
    private ArrayList<Book> returned_Book;

    public User(String name, String bin) {
        issueBook = new ArrayList<>();
        returned_Book = new ArrayList<>();
        this.name = name;
        this.bin = bin;
    }

    public String getName() {
        return name;
    }

    public String getBin() {
        return bin;
    }

    public ArrayList<Book> getIssueBook() {
        return issueBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public void addBook(Book book) {
        issueBook.add(book);
    }

    public void returnBook(Book book) {
        issueBook.remove(book);
        returned_Book.add(book);
    }

    public void viewIssuedBook() {
        if (issueBook.size() == 0)
            System.out.println(" No exist any book");
        for (Book b : issueBook) {
            System.out.println(b);
        }
    }

    public void viewReturnedBook() {
        if (returned_Book.size() == 0)
            System.out.println(" No exist any book");
        for (Book b : returned_Book) {
            System.out.println(b);
        }
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + '}';
    }
}