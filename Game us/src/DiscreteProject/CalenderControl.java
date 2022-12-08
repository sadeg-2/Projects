package DiscreteProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CalenderControl {
    @FXML
    TextField year ;
    @FXML
    TextField month ;

    static int yearN;
    static int monthN;
    @FXML
    private Label invalid ;

    public void show(ActionEvent event) throws IOException {
        yearN = Integer.parseInt(year.getText());
        monthN = Integer.parseInt(month.getText());
        if (monthN > 12 || monthN < 0){
            invalid.setText("Invalid month");
        }else{
            Parent root = FXMLLoader.load(getClass().getResource( "MainProject.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }


    }
}
