/**Write two programs, such that one displays the
 * mouse position when the mouse button is clicked (see Figure 15.28a), and the
 * other displays the mouse position when the mouse button is pressed and ceases
 * to display it when the mouse button is released.*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Text text = new Text("");
        pane.getChildren().add(text);

        Scene scene = new Scene(pane,250, 200);
        primaryStage.setTitle("DisplayMousePosition");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMousePressed(e -> {
            double x = e.getScreenX();
            double y = e.getScreenY();
            String mousePos = "(" + x + ", " + y + ")";
            text.setText(mousePos);
            text.setX(x);
            text.setY(y);
            //System.out.println(mousePos);
        });

        pane.setOnMouseReleased(e -> {
            text.setText("");
        });
    }
}
