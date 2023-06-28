/**
 * (Traffic lights) Write a program that simulates a traffic light. The program lets
 * the user select one of three lights: red, yellow, or green. When a radio but-
 * ton is selected, the light is turned on. Only one light can be on at a time (see
 * Figure 16.37a). No light is on when the program starts.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Group group = new Group();
        Rectangle rectangle = new Rectangle(100,100,100,30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        Circle redCircle = new Circle(120,115,10);
        redCircle.setStroke(Color.BLACK);
        redCircle.setFill(Color.WHITE);
        Circle yellowCircle = new Circle(150,115,10);
        yellowCircle.setStroke(Color.BLACK);
        yellowCircle.setFill(Color.WHITE);
        Circle greenCircle = new Circle(180,115,10);
        greenCircle.setStroke(Color.BLACK);
        greenCircle.setFill(Color.WHITE);
        
        group.getChildren().addAll(rectangle,redCircle,yellowCircle,greenCircle);

        HBox paneForRaddioButtons = new HBox(10);
        paneForRaddioButtons.setAlignment(Pos.CENTER);
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");
        paneForRaddioButtons.getChildren().addAll(rbRed,rbYellow,rbGreen);

        ToggleGroup rbGroup = new ToggleGroup();
        rbRed.setToggleGroup(rbGroup);
        rbYellow.setToggleGroup(rbGroup);
        rbGreen.setToggleGroup(rbGroup);

        BorderPane pane = new BorderPane();
        pane.setCenter(group);
        pane.setBottom(paneForRaddioButtons);

        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()){
                redCircle.setFill(Color.RED);
                yellowCircle.setFill(Color.WHITE);
                greenCircle.setFill(Color.WHITE);
            }
        });
        rbYellow.setOnAction(e -> {
            if(rbYellow.isSelected()){
             redCircle.setFill(Color.WHITE);
             yellowCircle.setFill(Color.YELLOW);
             greenCircle.setFill(Color.WHITE);
            }
        });
        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()){
             redCircle.setFill(Color.WHITE);
             yellowCircle.setFill(Color.WHITE);
             greenCircle.setFill(Color.GREEN);
            }
        });

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("TrafficLights");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
