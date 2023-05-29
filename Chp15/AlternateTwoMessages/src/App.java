/**
 * (Alternate two messages) Write a program to display the text Welcome to
 * java and LearningJavaFX alternately with a mouse click.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        BorderPane borderPane = new BorderPane();
        Pane pane = new Pane();
        Text text = new Text("Welcome to java");
        text.setX(100);
        text.setY(100);
        text.setFill(Color.GREEN);

        pane.getChildren().add(text);
        borderPane.setCenter(pane);

        Scene scene = new Scene(borderPane, 250,200);
        primaryStage.setTitle("AlternateTwoMessages");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseClicked(e -> {
            if(text.getText().equals("Welcome to java")){
                text.setText("LearningJavaFX");
                text.setFill(Color.RED);
            }
            else if(text.getText().equals("LearningJavaFX")){
                text.setText("Welcome to java");
                text.setFill(Color.GREEN);
            }
        });
    }
}
