import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class App extends Application{
    @Override
    public void start(Stage primarStage){

        Pane pane = new Pane();
        Text text = new Text(20,20,"Programing is fun");
        pane.getChildren().addAll(text);

        text.setOnMouseDragged(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
        });

        Scene scene = new Scene(pane,300,100);
        primarStage.setTitle("MouseEventDemo");
        primarStage.setScene(scene);
        primarStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}
