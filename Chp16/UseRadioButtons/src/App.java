import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        Pane paneForText = new Pane();
        Text text = new Text(20,20,"Welcome to Java");
        paneForText.getChildren().add(text);

        HBox paneForRadioButtons = new HBox(20);
        paneForRadioButtons.setPadding(new Insets(5,5,5,5));
        paneForRadioButtons.setAlignment(Pos.CENTER);
        paneForRadioButtons.setStyle("-fx-border-color:pink; -fx-border-width:2px");

        HBox paneForButtons = new HBox(20);
        Button btRight = new Button("Right", new ImageView("image/right.gif"));
        Button btLeft = new Button("Left", new ImageView("image/left.gif"));
        paneForButtons.getChildren().addAll(btLeft,btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color:cyan; -fx-border-width:2px");

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbBlack = new RadioButton("Black");
        RadioButton rbOrange = new RadioButton("Orange");
        RadioButton rbGreen = new RadioButton("Green");
        paneForRadioButtons.getChildren().addAll(rbRed,rbYellow,rbBlack,rbOrange,rbGreen);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbBlack.setToggleGroup(group);
        rbOrange.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setTop(paneForRadioButtons);
        pane.setBottom(paneForButtons);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        rbRed.setOnAction(e -> {
            if(rbRed.isSelected()){
                text.setFill(Color.RED);
            }
        });

        rbYellow.setOnAction(e -> {
            if(rbYellow.isSelected()){
                text.setFill(Color.YELLOW);
            }
        });

        rbBlack.setOnAction(e -> {
            if(rbBlack.isSelected()){
                text.setFill(Color.BLACK);
            }
        });

        rbOrange.setOnAction(e -> {
            if(rbOrange.isSelected()){
                text.setFill(Color.ORANGE);
            }
        });

        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()){
                text.setFill(Color.GREEN);
            }
        });

        Scene scene = new Scene(pane,250,200);
        primaryStage.setTitle("UseRadioButtons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
