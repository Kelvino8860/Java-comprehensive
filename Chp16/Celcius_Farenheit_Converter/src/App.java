import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    private TempCalculator calc = new TempCalculator();
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10);
        pane.setHgap(10);
        
        Label lbCelcius = new Label("Celcius");
        Label lbFarenheit = new Label("Farenheit");
        TextField tfCelcius = new TextField();
        TextField tfFarenheit = new TextField();

        pane.add(lbCelcius, 0, 0);
        pane.add(tfCelcius, 1, 0);
        pane.add(lbFarenheit, 0, 1);
        pane.add(tfFarenheit, 1, 1);

        tfCelcius.setOnAction(e -> {
            calc.convertString(tfCelcius.getText());
            tfFarenheit.setText(calc.getFarenheit());
            tfFarenheit.setEditable(false);
        });
        tfFarenheit.setOnAction(e -> {
            calc.convertString(tfFarenheit.getText());
            tfCelcius.setText(calc.getCelcius());
            tfCelcius.setEditable(false);
        });

        Scene scene = new Scene(pane, 270, 100);
        primaryStage.setTitle("Celcius/Fareinheit Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class TempCalculator{

        private Double value;
        private Double temp;

        public void convertString(String value){
            this.value = Double.parseDouble(value);
            System.out.println(value);
        }
        public String getCelcius()
        {
            temp = (value - 32) * 5 / 9;
            return String.valueOf(temp);
        }
        public String getFarenheit()
        {
            temp = (value * 9 / 5) + 32;
            return String.valueOf(temp);
        }
    }
}
