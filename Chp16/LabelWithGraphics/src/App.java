import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        ImageView us = new ImageView(new Image("media/us.gif"));
        Label lb1 = new Label("US\n50 States", us);
        lb1.setContentDisplay(ContentDisplay.BOTTOM);
        lb1.setStyle("-fx-border-color: green; -fx-border-width: 2");
        lb1.setTextFill(Color.RED);

        Label lb2 = new Label("Circle", new Circle(50,50,25));
        lb2.setContentDisplay(ContentDisplay.TOP);
        lb2.setTextFill(Color.ORANGE);

        Label lb3 = new Label("Rectangle", new Rectangle(10,10,50,25));
        lb3.setContentDisplay(ContentDisplay.RIGHT);

        Label lb4 = new Label("Ellipse", new Ellipse(50,50,50,25));
        lb4.setContentDisplay(ContentDisplay.LEFT);

        Ellipse ellipse = new Ellipse(50,50,50,25);
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITE);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, new Label("JavaFx"));
        Label lb5 = new Label("A pane inside a label", stackPane);
        lb5.setContentDisplay(ContentDisplay.BOTTOM);

        HBox pane = new HBox();
        pane.getChildren().addAll(lb1,lb2,lb3,lb4,lb5);

        Scene scene = new Scene(pane,600,200);
        primaryStage.setTitle("LabelWithGraphics");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
