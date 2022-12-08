package DiscreteProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalenderGui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FxmlCalender.fxml"));
        Scene scene = new Scene(root, 572, 420);
        stage.setTitle("Calender (^_^)");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
