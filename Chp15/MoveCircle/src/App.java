/**
 * (Move a circle using keys) Write a program that moves a 
 * circle up, down, left,or right using the arrow keys.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application {

    private double cX = 100;
    private double cY = 100;
    private final double radius = 50;
    private double cX2,cY2;
    private double segments = 5;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();

        Circle circle = new Circle(cX,cY,radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.GREEN);
        pane.getChildren().add(circle);

        pane.setOnKeyPressed(e -> {
            if(e.getCode().isArrowKey()){
                switch(e.getCode()){
                    case DOWN:
                            cY2 = cY;
                            cY += segments;
                            circle.setCenterX(cX);
                            circle.setCenterY(cY2);
                            break;
                    case UP:
                           cY2 = cY;
                           cY -= segments;
                           circle.setCenterX(cX);
                           circle.setCenterY(cY2);
                           break;
                    case LEFT:
                           cX2 = cX;
                           cX -= segments;
                           circle.setCenterX(cX2);
                           circle.setCenterY(cY);
                           break;
                    case RIGHT:
                           cX2 = cX;
                           cX += segments;
                           circle.setCenterX(cX2);
                           circle.setCenterY(cY);
                           break;
                    default:
                           break;
                }
            }
        });

        Scene scene = new Scene(pane,400,400);
        primaryStage.setTitle("MoveCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
        circle.requestFocus();
    }
}
