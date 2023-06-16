
/**
 * (Geometry: inside a circle?) Write a program that draws a fixed circle centered
 * at (100, 60) with radius 50. Whenever the mouse is moved, display a message
 * indicating whether the mouse point is inside the circle at the mouse point or
 * outside of it,
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private Text text = new Text();
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane pane  = new Pane();
        Circle circle = new Circle(100,60,50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().addAll(circle,text);

        pane.setOnMouseMoved(e -> {

            System.out.println("Mouse moved");
            if((e.getScreenX() >= 50 && e.getScreenX() <= 150) &&
               (e.getScreenY() >= 10 && e.getScreenY() <= 110))
            {
                text.setText("Mouse point is inside the circle");
                text.setX(e.getScreenX());
                text.setY(e.getScreenY());
            }
            else if((e.getScreenX() < 50) || (e.getSceneX() > 150))
            {
                text.setText("Mouse point is outside the circle");
                text.setX(e.getScreenX());
                text.setY(e.getScreenY());
            }
        });

        Scene scene = new Scene(pane,250, 200);
        primaryStage.setTitle("InsideCircle");
        primaryStage.setScene(scene);
        primaryStage.show();

        text.requestFocus();
    }
}
