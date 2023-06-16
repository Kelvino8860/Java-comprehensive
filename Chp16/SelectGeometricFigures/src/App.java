/**
 * (Select geometric figures) Write a program that draws various figures, as shown
 * in Figure 16.36b. The user selects a figure from a radio button and uses a check
 * box to specify whether it is filled.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane paneForShapes = new Pane();

        Circle circle = new Circle(100,100,50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        Rectangle square = new Rectangle(60,60,100,100);
        square.setStroke(Color.BLACK);
        square.setFill(Color.WHITE);
        Ellipse ellipse = new Ellipse(100,100,80,50);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);

        HBox paneForRadioButtons = new HBox(20);
        paneForRadioButtons.setAlignment(Pos.CENTER);
        CheckBox cbFill = new CheckBox("Fill");

        RadioButton rbCircle = new RadioButton("Circle");
        RadioButton rbSquare = new RadioButton("Square");
        RadioButton rbEllipse = new RadioButton("Ellipse");

        ToggleGroup group = new ToggleGroup();
        rbCircle.setToggleGroup(group);
        rbSquare.setToggleGroup(group);
        rbEllipse.setToggleGroup(group);
        paneForRadioButtons.getChildren().addAll(rbCircle,rbSquare,rbEllipse,cbFill);

        BorderPane pane = new BorderPane();
        pane.setCenter(paneForShapes);
        pane.setBottom(paneForRadioButtons);

        EventHandler<ActionEvent> handler = e -> {
            if(cbFill.isSelected() && rbCircle.isSelected()){
                circle.setFill(Color.PINK);
            }
            else if(cbFill.isSelected() && rbSquare.isSelected()){
                square.setFill(Color.PINK);
            }
            else if(cbFill.isSelected() && rbEllipse.isSelected()){
                ellipse.setFill(Color.PINK);
            }
            else{
                circle.setFill(Color.WHITE);
                square.setFill(Color.WHITE);
                ellipse.setFill(Color.WHITE);
            }
        };

        rbCircle.setOnAction(e -> {
            if(rbCircle.isSelected()){
                cbFill.setSelected(false);
                paneForShapes.getChildren().clear();
                paneForShapes.getChildren().add(circle);
            }
        });
        rbSquare.setOnAction(e -> {
            if(rbSquare.isSelected()){
                cbFill.setSelected(false);
                paneForShapes.getChildren().clear();
                paneForShapes.getChildren().add(square);
            }
        });
        rbEllipse.setOnAction(e -> {
            if(rbEllipse.isSelected()){
                cbFill.setSelected(false);
                paneForShapes.getChildren().clear();
                paneForShapes.getChildren().add(ellipse);
            }
        });

        cbFill.setOnAction(handler);

        Scene scene = new Scene(pane,300,200);
        primaryStage.setTitle("SelectGeometricFigure");
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }
}
