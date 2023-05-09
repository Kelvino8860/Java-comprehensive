import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class App extends Application{
    @Override
    public void start(Stage primaryStage){

        Group group = new Group();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15,15,15,15));
        group.scaleXProperty().bind(pane.widthProperty().divide(100));
        group.scaleYProperty().bind(pane.heightProperty().divide(100));

        //Verticle lines
        Line lineV1 = new Line(40,40,40,120);
        lineV1.setStroke(Color.BLUE);
        Line lineV2 = new Line(60,40,60,120);
        lineV2.setStroke(Color.BLUE);
        Line lineV3 = new Line(80,40,80,120);
        lineV3.setStroke(Color.BLUE);
        Line lineV4 = new Line(100,40,100,120);
        lineV4.setStroke(Color.BLUE);
        Line lineV5 = new Line(120,40,120,120);
        lineV5.setStroke(Color.BLUE);

        //Horizontal lines
        Line lineH1 = new Line(40,40,120,40);
        lineH1.setStroke(Color.RED);
        Line lineH2 = new Line(40,60,120,60);
        lineH2.setStroke(Color.RED);
        Line lineH3 = new Line(40,80,120,80);
        lineH3.setStroke(Color.RED);
        Line lineH4 = new Line(40,100,120,100);
        lineH4.setStroke(Color.RED);
        Line lineH5 = new Line(40,120,120,120);
        lineH5.setStroke(Color.RED);

        group.getChildren().addAll(lineV1,lineV2,lineV3,lineV4,lineV5,
                                   lineH1,lineH2,lineH3,lineH4,lineH5);

        pane.getChildren().add(group);

        Scene scene = new Scene(pane,200,200);
        primaryStage.setTitle("4X4 GRID");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}
