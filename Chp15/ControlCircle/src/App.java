import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

public class App extends Application{

        CirclePane circlePane = new CirclePane();
    
    @Override
    public void start(Stage primaryStage){

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hbox.getChildren().addAll(btEnlarge,btShrink);

        btEnlarge.setOnAction(e -> circlePane.enlarge());
        btShrink.setOnAction(e -> circlePane.shrink());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hbox);
        BorderPane.setAlignment(hbox, Pos.CENTER);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();

        circlePane.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY)
                  circlePane.enlarge();
            else if(e.getButton() == MouseButton.SECONDARY)
                  circlePane.shrink();
        });

        circlePane.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP)
            {
              circlePane.enlarge();
            }
            else if(e.getCode() == KeyCode.DOWN)
            {
              circlePane.shrink();
            }
        });
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}

class CirclePane extends StackPane{

    Circle circle = new Circle(50);

    public CirclePane(){
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void enlarge(){
        circle.setRadius(circle.getRadius() + 2);
    }
    public void shrink(){
        circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());
    }
}