import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class App extends Application {

    private static final int NUMBER_OF_NATIONS = 7;
    private final static String URL_BASE = "https://liveexample.pearsoncmg.com/common";
    private int currentIndex = 0;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Image[] images = new Image[NUMBER_OF_NATIONS];
        MediaPlayer[] mp = new MediaPlayer[NUMBER_OF_NATIONS];

        //Load images and videos
        for(int i = 0; i < NUMBER_OF_NATIONS; i++){
            images[i] = new Image(URL_BASE + "/image/flag" + i + ".gif");
            mp[i] = new MediaPlayer(new Media(URL_BASE + "/audio/anthem/anthem" + i + ".mp3"));

            Button btPlayPause = new Button("||");
            btPlayPause.setOnAction(e -> {
                if(btPlayPause.getText().equals(">")){
                    btPlayPause.setText("||");
                    mp[currentIndex].play();
                }
                else{
                    btPlayPause.setText(">");
                    mp[currentIndex].pause();
                }
            });

            ImageView imageView = new ImageView(images[currentIndex]);
            ComboBox<String> cboNation = new ComboBox<>();
            ObservableList<String> items = FXCollections.observableArrayList
            ("Denmark", "Germany", "China", "India", "Norway", "UK", "US");
            cboNation.getItems().addAll(items);
            cboNation.setValue(items.get(0));
            cboNation.setOnAction(e -> {
                mp[currentIndex].stop();
                currentIndex = items.indexOf(cboNation.getValue());
                imageView.setImage(images[currentIndex]);
                mp[currentIndex].play();
                btPlayPause.setText("||");
            });

            HBox hBox = new HBox(10);
            hBox.getChildren().addAll(btPlayPause, new Label("Select a nation"), cboNation);
            hBox.setAlignment(Pos.CENTER);

            //Create a pane to hold nodes
            BorderPane pane = new BorderPane();
            pane.setCenter(imageView);
            pane.setBottom(hBox);

            Scene scene = new Scene(pane, 350, 270);
            primaryStage.setTitle("FlagAnthem");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
}
