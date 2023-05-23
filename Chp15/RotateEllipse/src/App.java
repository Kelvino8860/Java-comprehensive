import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import javafx.animation.Timeline;

public class App extends Application{
    @Override
    public void start(Stage primaryStage){

        BorderPane pane = new BorderPane();
        Pane stPane = new Pane();

        Circle circle = new Circle(125,100,50);
        circle.setFill(Color.WHITESMOKE);
        Ellipse ellipse = new Ellipse(125,100,100,50);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.RED);

        Button bt = new Button("Rotate");

        stPane.getChildren().addAll(circle,ellipse);

        pane.setCenter(stPane);
        pane.setBottom(bt);
        BorderPane.setAlignment(bt, Pos.TOP_CENTER);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(100));
        pt.setPath(circle);
        pt.setNode(ellipse);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("RotateEllipse");
        primaryStage.setScene(scene);
        primaryStage.show();

        bt.setOnAction(e -> pt.play());
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}