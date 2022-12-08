import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlGame.fxml"));
        Scene scene = new Scene(root, 650, 350);
        stage.setTitle("Game (^_^)");
        stage.setScene(scene);
        stage.show();
    }

}
