import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class App extends Application{
    @Override
    public void start(Stage primarStage){

        Text text = new Text(40,40,"Programming is fun");
        Pane pane = new Pane(text);

        Button btUp = new Button("UP");
        Button btDown = new Button("Down");
        Button btRight = new Button("Right");
        Button btLeft = new Button("Left");
        HBox hbox = new HBox(btUp,btDown,btRight,btLeft);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane(pane);
        borderPane.setBottom(hbox);

        btUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                text.setY(text.getY() >= 15 ? text.getY() - 10 : 10);
            }
        });

        btDown.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                text.setY(text.getY() < pane.getHeight() - 20 ? text.getY() + 5 : pane.getHeight() - 20);
            }
        });

        btRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                text.setX(text.getX() < pane.getWidth() - 125 ? text.getX() + 5 : pane.getWidth() - 125);
            }
        });

        btLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                text.setX(text.getX() >= 5 ? text.getX() - 5 : text.getX());
            }
        });

        Scene scene = new Scene(borderPane, 400,350);
        primarStage.setTitle("AnonymousHandlerDemo");
        primarStage.setScene(scene);
        primarStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}
