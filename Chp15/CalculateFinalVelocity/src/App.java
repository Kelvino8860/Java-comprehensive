/**
 * (Calculate final velocity) Write a program that prompts the users to enter
 * initial velocity, acceleration, and time to compute final velocity, as shown in
 * Figure 15.27b. (vf = v0 + acceleration * time.)
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private Graphics graphicsClass = new Graphics();
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(graphicsClass, 320,200);
        primaryStage.setTitle("CalculateFinalVelocity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
