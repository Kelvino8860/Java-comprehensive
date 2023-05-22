/**
 * *15.1 (Pick four cards) Write a program that lets the user click the Refresh button to
 * display four cards from a deck of 52 cards, as shown in Figure 15.26a. (See the
 * hint in Programming Exercise 14.3 on how to obtain four random cards.)
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class App extends Application{
    
    private PlayCards playCards = new PlayCards();

    @Override
    public void start(Stage primaryStage){

        BorderPane pane = new BorderPane();
        pane.setCenter(playCards);
        
        Button refresh = new Button("Refresh");
        pane.setBottom(refresh);
        BorderPane.setAlignment(refresh, Pos.TOP_CENTER);

        Scene scene = new Scene(pane,250,200);
        primaryStage.setTitle("PickFourCards");
        primaryStage.setScene(scene);
        primaryStage.show();

        refresh.setOnAction(e -> playCards.fourCards());
    }

    public static void main(String[] args) {
        App.launch(args);
    }
}