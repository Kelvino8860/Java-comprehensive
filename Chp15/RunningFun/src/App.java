/**
 * (Display a running fan) Write a program that displays a running fan, as shown
 * in Figure 15.35c. Use the Pause, Resume, Reverse buttons to pause, resume,
 * and reverse fan running.
 */

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane paneForFan = new StackPane();
        Group group = new Group();
        BorderPane pane = new BorderPane();
        HBox paneForButtons = new HBox(10);
        paneForButtons.setAlignment(Pos.CENTER);

        //Buttons for controlling fun
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        paneForButtons.getChildren().addAll(btPause,btResume,btReverse);

        Circle circle = new Circle(100,100,100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        //Path for animation
        Circle pathAnim = new Circle(100,100,1);
        pathAnim.setFill(Color.GREY);

        Arc arc1 = new Arc(100,100,80,80,20,40);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.YELLOW);
        arc1.setStroke(Color.BLACK);
        Arc arc2 = new Arc(100,100,80,80,80,40);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.GREEN);
        arc2.setStroke(Color.BLACK);
        Arc arc3 = new Arc(100,100,80,80,140,40);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.ORANGE);
        arc3.setStroke(Color.BLACK);
        Arc arc4 = new Arc(100,100,80,80,200,40);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.PINK);
        arc4.setStroke(Color.BLACK);
        Arc arc5 = new Arc(100,100,80,80,260,40);
        arc5.setType(ArcType.ROUND);
        arc5.setFill(Color.RED);
        arc5.setStroke(Color.BLACK);
        Arc arc6 = new Arc(100,100,80,80,320,40);
        arc6.setType(ArcType.ROUND);
        arc6.setFill(Color.VIOLET);
        arc6.setStroke(Color.BLACK);

        //Set path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(500));
        pt.setPath(pathAnim);
        pt.setNode(group);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        btPause.setOnAction(e -> pt.pause());
        btResume.setOnAction(e -> pt.play());

        /*TO DO */
        btReverse.setOnAction(e -> {
            pathAnim.setRadius(-1);
            pt.play();
        });

        group.getChildren().addAll(pathAnim,arc1,arc2,arc3,arc4,arc5,arc6);
        paneForFan.getChildren().addAll(circle,group);
        pane.setCenter(paneForFan);
        pane.setBottom(paneForButtons);

        Scene scene = new Scene(pane,250,300);
        primaryStage.setTitle("RunningFan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
