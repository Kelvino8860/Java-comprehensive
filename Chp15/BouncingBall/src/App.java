import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class App extends Application{
    @Override
    public void start(Stage primaryStage){
        BallPane ballPane = new BallPane(); //Create a ball pane

        //Pause and resume application
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        //Increase and decrease animation
        ballPane.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP)
                ballPane.increaseSpeed();
            else if(e.getCode() == KeyCode.DOWN)
                ballPane.decreaseSpeed();
        });

        //Create a scene and place it in a stage
        Scene scene = new Scene(ballPane, 250, 150);
        primaryStage.setTitle("BouncingBallControl");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}