import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class App extends Application{
    @Override
    public void start(Stage primaryStage){

        Text text = new Text(40,40,"Programming is fun");
        Pane pane = new Pane(text);

        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btRight = new Button("Right");
        Button btLeft = new Button("Left");
        HBox hbox = new HBox(btUp,btDown,btRight,btLeft);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane(pane);
        borderPane.setBottom(hbox);

        //Create and register handlers
        btUp.setOnAction((ActionEvent e) -> {
            text.setY(text.getY() > 15 ? text.getY() - 5 : 10);
        }
        );

        btDown.setOnAction((e) -> {
            text.setY(text.getY() < pane.getHeight() - 25 ? text.getY() + 5 : pane.getHeight() - 25);
        });

        btRight.setOnAction(e -> text.setX(text.getX() < pane.getWidth() - 125 ?
                   text.getX() + 5 : pane.getWidth() - 125));

        btLeft.setOnAction(e -> {
            text.setX(text.getX() > 0 ? text.getX() - 5 : 0);
        });

        //Create a scene and place it in the stage
        Scene scene = new Scene(borderPane,400,350);
        primaryStage.setTitle("LambdaHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}