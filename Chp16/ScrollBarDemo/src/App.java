import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollBar;
import javafx.geometry.Orientation;
import javafx.scene.layout.Pane;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Text text = new Text(20,20,"JavaFX Programming");

        ScrollBar sbHorizontal = new ScrollBar();
        ScrollBar sbVertical = new ScrollBar();
        sbVertical.setOrientation(Orientation.VERTICAL);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setRight(sbVertical);
        pane.setBottom(sbHorizontal);

        sbHorizontal.valueProperty().addListener(e ->
          text.setX(sbHorizontal.getValue() * paneForText.getWidth() /
            sbHorizontal.getMax()));

        sbVertical.valueProperty().addListener(e ->
          text.setY(sbVertical.getValue() * paneForText.getHeight() /
            sbVertical.getMax()));

        Scene scene = new Scene(pane, 400, 170);
        primaryStage.setTitle("ScrollBarDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
