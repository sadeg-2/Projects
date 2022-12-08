
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        String cards[] = {"A1", "A2", "A3", "A4", "A5", "A6", "A7",
                          "B1", "B2", "B3", "D4", "D5", "D6", "D7",
                          "C1", "C2", "C3", "C4", "A5", "C6", "C7"};
        
        System.out.print("Let's Start the game :) \r");
        Thread.sleep(2000);
        System.out.println("Now I Show cards and You Will Choice One Cards And After 3 loops \n" +
                "I will till you What you are choice :) ,\nAre You ready ?(Y/N) ");
        char start = input.next().charAt(0);
        if (start == 'N'){
            System.out.println("Ok , Good Bye :(");
            System.exit(0);
        }
        System.out.println("this is cards (^_^) \n choice your card and save it in your brain :  ");
        System.out.println(strCards(cards));
        Thread.sleep(2000);
        System.out.println("+------------------------------+");
        System.out.println("");

        for (int i = 0; i < 3; i++) {
            System.out.printf("Loop number %d \n ",i+1);
            printGroupCards(cards);
            System.out.println("+------------------------------+");
            System.out.println("In any Group Your Cards ?(A/B/C)");
            char cGroup = input.next().charAt(0);
            reArrangementCards(cards,cGroup);
            shuffleCards(cards);

            Thread.sleep(1000);
        }
        System.out.println("Ok , I Know You are wait me to show your Cards\n" +
                "So Your Card is : " + cards[10]);

    }
    public static String strCards (String[] cards){
        String card = "" ;
        for (int i = 0; i < cards.length; i++) {
            if ((i+1)%7==0)
                card += cards[i] + '\n' ;
            else
                card+= cards[i] + " , ";
        }
        return card ;
    }

    public static void printGroupCards(String cards[]) {
        System.out.println();
        System.out.println("This is the Cards : ");
        for (int i = 0; i < 3; i++) {
            System.out.printf("this is a Group %c \n", (i + 'A'));
            for (int j = 7 * i; j < 7 * (i + 1); j++) {
                System.out.print(cards[j] + " ");
            }
            System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        }
    }

    public static String[] reArrangementCards(String[] cards, char choice) {
        int index = Character.toUpperCase(choice) - 'A';
        for (int i = 0; i < 7; i++) {
            String temp = cards[7 + i];
            cards[7 + i] = cards[(index * 7) + i];
            cards[(index * 7) + i] = temp;
        }
        return cards;
    }

    public static void shuffleCards(String [] cards){
        String groupA [] = new String[7];
        String groupB [] = new String[7];
        String groupC [] = new String[7];
        int index = 0 ;
        for (int i = 0; i < cards.length; i++) {
            if ((i+3)%3 == 0){
                groupA[index] = cards[i];
            }
            else if((i+2)%3 == 0){
                groupB[index] = cards[i];
            }
            else if((i+1)%3 == 0){
                groupC[index] = cards[i];
                index++;
            }
        }
        for (int i = 0; i < groupA.length; i++) {
            cards[i] = groupA[i];
        }
        for (int i = 0; i < groupB.length; i++) {
            cards[i+7] = groupB[i];
        }
        for (int i = 0; i < groupC.length; i++) {
            cards[14+i]= groupC[i];
        }
    }
}
