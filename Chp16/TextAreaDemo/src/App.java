import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        //Declare and create a description pane
        DescriptionPane descriptionPane = new DescriptionPane();

        //Set the text, image, and title in the descriptionPane
        descriptionPane.setTitle("Canada");
        String description = "The Canadian national flag ...";
        descriptionPane.setImageView(new ImageView("media/ca.gif"));
        descriptionPane.setDescription(description);

        //Create a scene and place in the stage
        Scene scene = new Scene(descriptionPane, 450, 200);
        primaryStage.setTitle("TextAreaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
