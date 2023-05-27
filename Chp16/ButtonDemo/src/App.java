import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
//import javafx.scene.control.ContentDisplay;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

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
