import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class App extends Application{
    @Override
    public void start(Stage primaryStage){
        //Create clock and a label
        ClockPane clock = new ClockPane();
        String timeString = clock.toString();
        Label lblCurrentTime = new Label(timeString);

        //Create an event handler
        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
            lblCurrentTime.setText(clock.toString());
       };

       //Create an animation for running a clock
       Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
       animation.setCycleCount(Timeline.INDEFINITE);
       animation.play();

        //Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        //Create a scene and place it in stage
        Scene scene = new Scene(pane,250,250);
        primaryStage.setTitle("DisplayClock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}