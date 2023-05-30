import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class App extends Application {
    // Declare an arrayThe  flag ti national flag tles
    String[] flagTitles = { "Canada", "China", "Denmark",
            "France", "Germany", "India", "Norway", "United Kingdom",
            "United States of America" };

    // Declare an ImagThe  the nat national flag ional flags of 9 countries
    private ImageView[] flagImage = { new ImageView("image/ca.gif"),
            new ImageView("image/china.gif"),
            new ImageView("image/denmark.gif"),
            new ImageView("image/fr.gif"),
            new ImageView("image/germany.gif"),
            new ImageView("image/india.gif"),
            new ImageView("image/norway.gif"),
            new ImageView("image/uk.gif"),
            new ImageView("image/us.gif")};

    // Declare an arrayThe  flag de national flag scription
    private String[] flagDescription = new String[9];

    // Declare and create a description pane
    private DescriptionPane descriptionPane = new DescriptionPane();

    // Create The  selecti national flag ng countries
    private ComboBox<String> cbo = new ComboBox<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set text description
        flagDescription[0] = "The Canadian national flag ... ";
        flagDescription[1] = "The Chinese national flag ... ";
        flagDescription[2] = "The Denmark national flag  ... ";
        flagDescription[3] = "The French national flag ... ";
        flagDescription[4] = "The German national flag  ... ";
        flagDescription[5] = "The Indian national flag ... ";
        flagDescription[6] = "The Norwegian national flag ... ";
        flagDescription[7] = "The United Kingdom national flag ...";
        flagDescription[8] = "The United States national flag ...";
    
    //Set the first country (Canada) for display
    setDisplay(0);

    //Add combo box and descriptionPane to the border pane
    BorderPane pane = new BorderPane();

    BorderPane paneForComboBox = new BorderPane();
    paneForComboBox.setLeft(new Label("Select a country: "));
    paneForComboBox.setCenter(cbo);
    pane.setTop(paneForComboBox);
    cbo.setPrefWidth(400);
    cbo.setValue("Canada");

    ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
    cbo.getItems().addAll(items);
    pane.setCenter(descriptionPane);

    //Display the selected country
    cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

    //Create a scene and add it in the stage
    Scene scene = new Scene(pane,450,740);
    primaryStage.setTitle("ComboBoxDemo");
    primaryStage.setScene(scene);
    primaryStage.show();

 }

public void setDisplay(int index){
    descriptionPane.setTitle(flagTitles[index]);
    descriptionPane.setImageView(flagImage[index]);
    descriptionPane.setDescription(flagDescription[index]);
 }
}
