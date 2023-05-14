import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class App extends Application{
    @Override
    public void start(Stage primaryStage)
    {
        Group group = new Group();
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15,15,15,15));
        pane.setAlignment(Pos.CENTER);
        group.scaleXProperty().bind(pane.widthProperty().divide(200));
        group.scaleYProperty().bind(pane.heightProperty().divide(200));

        //All Lines required
        Line line1 = new Line(40,40,40,190);
        Line line2 = new Line(40,40,100,40);
        Line line3 = new Line(100,40,100,60);
        Line line4 = new Line(110,90,130,120);
        Line line5 = new Line(90,90,70,120);
        Line line6 = new Line(100,100,100,130);
        Line line7 = new Line(100,130,120,150);
        Line line8 = new Line(100,130,80,150);

        //Head and Stand
        Circle head = new Circle(100,80,20);
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);
        Arc stand = new Arc(40,200,20,20,0,180);
        stand.setType(ArcType.OPEN);
        stand.setStroke(Color.BLACK);
        stand.setFill(Color.WHITE);

        group.getChildren().addAll(line1,line2,line3,line4,line5,line6,line7,
                                   line8,head,stand);

        pane.getChildren().add(group);

        Scene scene = new Scene(pane,200,200);
        primaryStage.setTitle("HangMan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}
