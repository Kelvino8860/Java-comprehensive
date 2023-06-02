/**
 * Write a program that displays the color of a circle as 
 * red when the mouse button is pressed and as blue when the 
 * mouse button is released.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();

        Circle circle = new Circle(100,100,50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("ChangeColorUsingMouse");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMousePressed(e -> {
            circle.setFill(Color.RED);
        });

        pane.setOnMouseReleased(e -> {
            circle.setFill(Color.BLUE);
        });
    }
}
