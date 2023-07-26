import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(5);
        pane.setHgap(5);

        //Labels
        Label lblDecimal = new Label("Decimal");
        Label lblHex = new Label("Hex");
        Label lblBinary = new Label("Binary");

        //TextFields
        TextField tfDecimal = new TextField();
        TextField tfHex = new TextField();
        TextField tfBinary = new TextField();

        pane.add(lblDecimal, 0, 0);
        pane.add(tfDecimal, 1, 0);
        pane.add(lblHex, 0, 1);
        pane.add(tfHex, 1, 1);
        pane.add(lblBinary, 0, 2);
        pane.add(tfBinary, 1, 2);

        Convert obj = new Convert();
        tfDecimal.setOnAction(e ->{
            obj.setValue(tfDecimal.getText(), 10);
            tfHex.setText(obj.getHex());
            tfBinary.setText(obj.getBinary());
            tfBinary.setEditable(false);
            tfHex.setEditable(false);
        });

        tfHex.setOnAction(e -> {
            obj.setValue(tfHex.getText(), 16);
            tfDecimal.setText(obj.getDecimal());
            tfBinary.setText(obj.getBinary());
            tfBinary.setEditable(false);
            tfDecimal.setEditable(false);
        });

        tfBinary.setOnAction(e -> {
            obj.setValue(tfBinary.getText(), 2);
            tfDecimal.setText(obj.getDecimal());
            tfHex.setText(obj.getHex());
            tfHex.setEditable(false);
            tfDecimal.setEditable(false);
        });

        Scene scene = new Scene(pane, 250, 130);
        primaryStage.setTitle("NumberConverter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class Convert
    {
        private String value;
        private int decimal;

        public void setValue(String value, int radix)
        {
            this.value = value;
            decimal = Integer.parseInt(value, radix);
        }
        public String getDecimal()
        {
            return (String.valueOf(decimal));
        }
        public String getHex()
        {
            return (Integer.toHexString(decimal));
        }
        public String getBinary()
        {
            return (Integer.toBinaryString(decimal));
        }
    }
}
