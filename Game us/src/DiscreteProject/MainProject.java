package DiscreteProject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainProject implements Initializable {

    @FXML
    Label yearName;
    @FXML
    Label monthName;
    @FXML
    Label sun;//0
    @FXML
    Label mon;//1
    @FXML
    Label tue;//2
    @FXML
    Label wed;//3
    @FXML
    Label thu;//4
    @FXML
    Label fri;//5
    @FXML
    Label sat;//6

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "FxmlCalender.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String [] days = Calendar.getDay(CalenderControl.yearN,CalenderControl.monthN);
        yearName.setText(CalenderControl.yearN+"");
        monthName.setText(Calendar.getMonthName(CalenderControl.monthN));
        sun.setText(days[0]);
        mon.setText(days[1]);
        tue.setText(days[2]);
        wed.setText(days[3]);
        thu.setText(days[4]);
        fri.setText(days[5]);
        sat.setText(days[6]);
    }
}
