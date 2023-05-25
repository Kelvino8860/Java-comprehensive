/**
 * (Create a simple calculator) Write a program to perform addition, subtraction,
 * multiplication, and division, as shown in Figure 15.27a.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    ControlGraphics cg = new ControlGraphics();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        Scene scene = new Scene(cg, 700,100);
        primaryStage.setTitle("SimpleCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}