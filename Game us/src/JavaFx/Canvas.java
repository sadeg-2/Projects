package JavaFx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Canvas extends Application {
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Group root = new Group();
//        root.getChildren().add(new Circle(10,10,5));
//        Scene scene = new Scene(root,600,600);
//        final int [] size = {10,10};
//        scene.setOnMouseDragged(event -> {
//                root.getChildren().setAll(new Circle(size[0]+=2,size[1]+=2,10));
//        });
//
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
    //Canvas
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        root.getChildren().add(new NumbersTextField());
        Scene scene = new Scene(root,600,600);

        final Color[] c = {Color.CYAN};
        final int[] size = {5};

        scene.setOnMouseDragged(event ->{
                    //System.out.println("mouse click detected! "+event.getSceneX() + " " + event.getScreenX());
                    root.getChildren().add(new Circle(event.getSceneX(),event.getSceneY(),size[0],c[0]));
            }
        );

        scene.setOnMouseClicked(event -> {
            new AudioClip(Sounds.HIT_WALL).play();
            Rectangle x = new Rectangle(event.getSceneX()-25,event.getSceneY()-25,50,50);
            x.setFill(c[0]);

            root.getChildren().add(x);
        });
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.R) {
                c[0] = Color.RED;
            }
            if (e.getCode() == KeyCode.B) {
                c[0] = Color.BLUE;
            }
            if (e.getCode() == KeyCode.G) {
                c[0] = Color.GREEN;
            }
            if (e.getCode() == KeyCode.C) {
                root.getChildren().clear();
            }
            if(e.getCode() == KeyCode.UP)
                size[0]+=2 ;
            if(e.getCode() == KeyCode.DOWN)
                size[0]-=2 ;
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
//
class NumbersTextField extends TextField {
    public  NumbersTextField(){
        setOnKeyPressed((e)->{
            if (e.getCode().isDigitKey() || e.getCode() == KeyCode.BACK_SPACE){
                setEditable(true);
            }else{
                setEditable(false);
            }
        });
    }
}
