import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class App extends Application{
    @Override
    public void start(Stage primaryStage){
        //Create a pane
        Pane pane = new Pane();

        //Create a rectange
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        rectangle.setFill(Color.ORANGE);

        //Create a circle
        Circle circle = new Circle(125,100,50);
        circle.setStyle("-fx-stroke:black; -fx-fill:white;");

        //Add circle and rectangle
        pane.getChildren().addAll(circle,rectangle);

        //Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(400));
        pt.setPath(circle);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play(); //Start animation

        circle.setOnMousePressed(e -> pt.pause());
        circle.setOnMouseReleased(e -> pt.play());

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("PathTransitionDemo");
        primaryStage.setScene(scene);
        primaryStage.show(); //Display the stage
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}
