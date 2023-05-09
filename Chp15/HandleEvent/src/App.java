import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class App extends Application{
    @Override
    public void start(Stage primaryStage){

        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Button btOK = new Button("Ok");
        Button btCancel = new Button("Cancel");
        OkHandlerClass handler1 = new OkHandlerClass();
        btOK.setOnAction(handler1);
        CancelHandlerClass handler2 = new CancelHandlerClass();
        btCancel.setOnAction(handler2);
        pane.getChildren().addAll(btOK,btCancel);


        Scene scene = new Scene(pane,200,250);
        primaryStage.setTitle("HandleEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class OkHandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent arg0) {
            System.out.println("Ok button clicked");
        }
    }

    class CancelHandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent arg0){
            System.out.println("Cancel button clicked");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}