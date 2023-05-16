import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

public class App extends Application{

    private Circle circle = new Circle(60);
    private Rectangle rectangle = new Rectangle(120,120);

    private StackPane pane = new StackPane();

    @Override
    public void start(Stage primaryStage){

        circle.setFill(Color.GRAY);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().addAll(rectangle, circle);

        Scene scene = new Scene(pane, 140, 140);
        primaryStage.setTitle("ResizableCircleRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.widthProperty().addListener(e -> resize());
        pane.heightProperty().addListener(e -> resize());
    }

    public void resize(){

        double length = Math.min(pane.getWidth(), pane.getHeight());
       // System.out.println("Width of pane: " + pane.getWidth() +
         //           "\nHeight of pane: " + pane.getHeight());
        circle.setRadius(length / 2 - 15);
        rectangle.setWidth(length - 30);
        rectangle.setHeight(length - 30);
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}