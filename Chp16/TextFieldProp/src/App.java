import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    TextFieldProp obj1 = new TextFieldProp();
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        pane.getChildren().add(obj1);

        Scene scene = new Scene(pane, 430, 100);
        primaryStage.setTitle("TextFieldProperty");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
