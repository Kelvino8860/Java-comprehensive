import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.control.ContentDisplay;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;;

public class App extends Application {

    protected Text text = new Text(50,50,"JavaFx Programming");

    protected BorderPane getPane(){

        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Left", new ImageView("media/left.gif"));
        //btLeft.setContentDisplay(ContentDisplay.RIGHT);
        Button btRight = new Button("Right", new ImageView("media/right.gif"));
       // btRight.setContentDisplay(ContentDisplay.RIGHT);
        paneForButtons.getChildren().addAll(btLeft,btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color:green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        //Add check boxes and set text fonts 
        Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);

        text.setFont(fontNormal);

        VBox paneForCheckBoxes = new VBox(20);
        paneForCheckBoxes.setPadding(new Insets(5,5,5,5));
        paneForCheckBoxes.setStyle("-fx-border-color:green");

        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalic = new CheckBox("Italic");
        paneForCheckBoxes.getChildren().addAll(chkBold,chkItalic);
        pane.setRight(paneForCheckBoxes);

        EventHandler<ActionEvent> handler = e -> {
            if(chkBold.isSelected() && chkItalic.isSelected()){
                text.setFont(fontBoldItalic);
            }
            else if(chkBold.isSelected()){
                text.setFont(fontBold);
            }
            else if(chkItalic.isSelected()){
                text.setFont(fontItalic);
            }
            else{
                text.setFont(fontNormal);
            }
        };

        //Add radio buttons to change text color
        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5,5,5,5));
        paneForRadioButtons.setStyle("-fx-border-width:2px; -fx-border-color:green");

        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");
        paneForRadioButtons.getChildren().addAll(rbRed,rbBlue,rbGreen);
        pane.setLeft(paneForRadioButtons);

        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbBlue.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        //Add a text field to change text
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5,5,5,5));
        paneForTextField.setStyle("-fx-border-color:green");
        paneForTextField.setLeft(new Label("Enter a new message: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);
        pane.setTop(paneForTextField);

        //Handle events
        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        rbRed.setOnAction(e -> {
            if(rbRed.isSelected()){
                text.setFill(Color.RED);
            }
        });

        rbBlue.setOnAction(e -> {
            if(rbBlue.isSelected()){
                text.setFill(Color.BLUE);
            }
        });

        rbGreen.setOnAction(e -> {
            if(rbGreen.isSelected()){
                text.setFill(Color.GREEN);
            }
        });

        tf.setOnAction(e -> text.setText(tf.getText()));

        return pane;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
