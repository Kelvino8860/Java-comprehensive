/**
 * (Enter and display a string) Write a program that receives a string 
 * from the keyboard and displays it on a pane. The Enter key signals the end of a string.
 * Whenever a new string is entered, it is displayed on the pane.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private String str;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        StringBuilder sb = new StringBuilder();
        Text text = new Text();
        pane.getChildren().add(text);
        text.setX(100);
        text.setY(100);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("EnterDisplaysString");
        primaryStage.setScene(scene);
        primaryStage.show();
        text.requestFocus();

        pane.setOnKeyTyped(e -> {
            sb.append(e.getCharacter());
        });
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                str = sb.toString();
                text.setText(str);
            }
        });
    }
}
