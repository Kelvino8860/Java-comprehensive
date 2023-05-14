import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class App extends Application{
    @Override
    public void start(Stage primaryStage){

        Group group = new Group();
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);
        group.scaleXProperty().bind(pane.widthProperty().divide(300));
        group.scaleYProperty().bind(pane.heightProperty().divide(300));

        Polyline polyline = new Polyline();
        polyline.setStroke(Color.BLACK);
        polyline.setFill(Color.WHITE);
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.0125;
        for(int i = -100; i <= 100; i++)
        {
            list.add(i + 200.0);
            list.add(scaleFactor * i * i * i);
        }

        group.getChildren().addAll(polyline);
        pane.getChildren().add(group);

        Scene scene = new Scene(pane,250,200);
        primaryStage.setTitle("CUBE FUNCTION");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}
