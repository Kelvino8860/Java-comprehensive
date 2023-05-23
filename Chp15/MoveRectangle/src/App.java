import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;

public class App extends Application{

    Rectangle rect = new Rectangle(100,100,10,10);

    @Override
    public void start(Stage primaryStage){
        
        Pane pane = new Pane();
        HBox hBox = new HBox(10);
        BorderPane borderPane= new BorderPane();

        rect.setStroke(Color.BLACK);
        rect.setFill(Color.BLUE);
        pane.getChildren().add(rect);

        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        hBox.getChildren().addAll(btLeft,btRight,btUp,btDown);
        hBox.setAlignment(Pos.CENTER);

        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

        Scene scene = new Scene(borderPane,250,200);
        primaryStage.setTitle("MoveRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();

        btLeft.setOnAction(e -> {

            double endY = rect.getX();
            Line line = new Line(rect.getX(), rect.getY(), borderPane.getWidth() - 20,
                endY);
            PathTransition pt = new PathTransition();
            pt.setDuration(Duration.millis(1000));
            pt.setPath(line);
            pt.setNode(rect);
            pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

            if(rect.getX() == borderPane.getWidth() - 20)
               pt.stop();
            else
               pt.play();
        });

        btRight.setOnAction(e -> {
            rect.setX(rect.getX() < borderPane.getWidth() - 20 ? rect.getX() + 5 : 
            borderPane.getWidth() - 20);
        });

        btUp.setOnAction(e -> {
            rect.setY(rect.getY() > 0 ? rect.getY() - 5 : 0);
        });

        btDown.setOnAction(e -> {
            rect.setY(rect.getY() < borderPane.getHeight() - 39 ? rect.getY() + 5 :
             borderPane.getHeight() - 39);
        });
    }
    public static void main(String[] args) {
        App.launch(args);
    }
}