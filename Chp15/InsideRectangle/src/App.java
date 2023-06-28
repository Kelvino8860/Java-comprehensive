/*
 * (Geometry: inside a rectangle?) Write a program that draws a fixed rectangle
 * centered at (80, 50) with width 100 and height 30. Whenever the mouse is
 * moved, display a message indicating whether the mouse point is inside the rec-
 * tangle at the mouse point or outside of it, as shown in Figure 15.29b. To detect
 * whether a point is inside a polygon, use the contains method defined in the
 * Node class.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Text text = new Text();
        Rectangle rectangle = new Rectangle(80,50,100,30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        pane.getChildren().addAll(rectangle,text);

        pane.setOnMouseMoved(e -> {
            if(rectangle.contains(e.getX(), e.getY())){
                text.setText("Mouse point is inside the rectangle");
                text.setX(e.getX());
                text.setY(e.getY());
               }
               else{
                text.setText("Mouse point is outside the rectangle");
                text.setX(e.getX());
                text.setY(e.getY());
               }
        });

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("InsideRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
        text.requestFocus();
    }
}
