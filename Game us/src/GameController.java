import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    String cards[] = {"B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10", "BJ", "BQ", "BK",
            "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DJ", "DQ", "DK",
            "C1", "C2", "C3", "C4", "C6", "C7", "C8", "C9", "C10", "C5", "CJ", "CQ", "CK",
            "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SJ", "SQ", "SK"};
    String myCards[];
    String strRules = "Rules : \n"+
            "1-Choose Cards \n"+
            "2-Remember Your Cards \n"+
            "3-I will show three Group \n and one of these Group have Your Cards \n Choose it \n"+
            "4-Repeat this 3 times and  \n I will tell You Your Cards \n" +
            "5-Have A nice Day (^_^) ";
    @FXML
    private HBox GroupA, GroupB, GroupC;
    int count = 0 ;

    @FXML
    private Button play, a, b, c;

    @FXML
    private Label gA, gB, gC , rules , result;

    @FXML
    private void play() {
        a.setDisable(false);
        b.setDisable(false);
        c.setDisable(false);
        gA.setText("Group A");
        gB.setText("Group B");
        gC.setText("Group C");
        rules.setText("");
        result.setText("");
        shuffleCards(myCards);
        showCards();
        play.setDisable(true);
    }

    @FXML
    private void a() {
        reArrangementCards(myCards, 'A');
        shuffleCards(myCards);
        showCards();
        count++;
        if (count == 3 )
            endGame();
    }

    @FXML
    private void b() {
        reArrangementCards(myCards, 'B');
        shuffleCards(myCards);
        showCards();
        count++;
        if (count == 3 )
            endGame();
    }

    @FXML
    private void c() {
        reArrangementCards(myCards, 'C');
        shuffleCards(myCards);
        showCards();
        count++;
        if (count == 3 )
            endGame();
    }
    private void endGame(){
        MyText text = new MyText(myCards[10]);
        result.setText("Cards is " + text.getText());
        result.setTextFill(text.getColor());
        count = 0 ;
        a.setDisable(true);
        b.setDisable(true);
        c.setDisable(true);
        play.setDisable(false);
        play.setText("Play");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myCards = new String[21];
        for (int i = 0; i < 21; i++) {
            int index = (int) (Math.random() * (52 - i));
            myCards[i] = cards[index];
            cards[index] = cards[51 - i];
            cards[51 - i] = myCards[i];
        }
        showCards();

        a.setDisable(true);
        b.setDisable(true);
        c.setDisable(true);
        gA.setText("");
        gB.setText("");
        gC.setText("");
        rules.setText(strRules);
        result.setText("");

    }

    private void showCards() {
        GroupA.getChildren().clear();
        GroupB.getChildren().clear();
        GroupC.getChildren().clear();
        for (int i = 0; i < 7; i++) {
            MyText text = new MyText(myCards[i]);
            GroupA.getChildren().add(text);
        }

        //  GroupA.getChildren().clear();
        for (int i = 7; i < 14; i++) {
            MyText text = new MyText(myCards[i]);
            GroupB.getChildren().add(text);
        }
        for (int i = 14; i < 21; i++) {
            MyText text = new MyText(myCards[i]);
            GroupC.getChildren().add(text);
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

    public static void shuffleCards(String[] cards) {
        String groupA[] = new String[7];
        String groupB[] = new String[7];
        String groupC[] = new String[7];
        int index = 0;
        for (int i = 0; i < cards.length; i++) {
            if ((i + 3) % 3 == 0) {
                groupA[index] = cards[i];
            } else if ((i + 2) % 3 == 0) {
                groupB[index] = cards[i];
            } else if ((i + 1) % 3 == 0) {
                groupC[index] = cards[i];
                index++;
            }
        }
        for (int i = 0; i < groupA.length; i++) {
            cards[i] = groupA[i];
        }
        for (int i = 0; i < groupB.length; i++) {
            cards[i + 7] = groupB[i];
        }
        for (int i = 0; i < groupC.length; i++) {
            cards[14 + i] = groupC[i];
        }
    }
}

class MyText extends Text {
    String number ;
    public MyText(String number) {//
        this.number = number ;
        setText(" " + number.charAt(1));
        setType(Character.toLowerCase(number.charAt(0)));
        setFont(new Font(20));
        setFill(getColor());

    }

    private void setType(char type) {
        // ♠ ♣ ♥ ♦
        switch (type) {
            case 's':
                setText(getText() + " ♣ ");
                break;
            case 'b':
                setText(getText() + " ♠ ");
                break;
            case 'd':
                setText(getText() + " ♦ ");
                break;
            case 'c':
                setText(getText() + " ♥ ");
                break;
        }
    }
    public  Color getColor(){
        char type = Character.toLowerCase(number.charAt(0));
        switch (type) {
            case 's':
            case 'b':
                return Color.BLACK ;
            case 'd':
            case 'c':
                return Color.RED ;
        }
        return Color.BLACK;
    }
}

