import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;

public class ControlGraphics extends BorderPane{

    private CalculationsClass cs = new CalculationsClass();
    private double num11;
    private double num22;
    private double ans;
    private String str;
    HBox hBox1 = new HBox(5);
    Label val1 = new Label("Number 1: ");
    TextField num1 = new TextField();
    Label val2 = new Label("Number 2: ");
    TextField num2 = new TextField();
    Label val3 = new Label("Result: ");
    TextField ansField = new TextField();
    HBox hBox2 = new HBox(5);
    Button addBtn = new Button("Add");
    Button subtractBtn = new Button("Subtract");
    Button multiplyBtn = new Button("Multiply");
    Button divideBtn = new Button("Divide"); 

    public ControlGraphics(){

        hBox1.getChildren().addAll(val1,num1,val2,num2,val3,ansField);
        hBox2.getChildren().addAll(addBtn,subtractBtn,multiplyBtn,divideBtn);

        setCenter(hBox1);
        setBottom(hBox2);
        BorderPane.setAlignment(hBox2, Pos.TOP_CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);

        addBtn.setOnAction(e -> {
            callCalculator();
            ans = cs.addNums();
            str = String.valueOf(ans);
            ansField.setText(str);
        });

        subtractBtn.setOnAction(e -> {
            callCalculator();
            ans = cs.subtractNums();
            str = String.valueOf(ans);
            ansField.setText(str);
        });

        multiplyBtn.setOnAction(e -> {
            callCalculator();
            ans = cs.multiplyNums();
            str = String.valueOf(ans);
            ansField.setText(str);
        });

        divideBtn.setOnAction(e -> {
            callCalculator();
            ans = cs.divideNums();
            str = String.valueOf(ans);
            ansField.setText(str);
        });
    }

    public void callCalculator(){

        num11 = Double.parseDouble(num1.getText());
        num22 = Double.parseDouble(num2.getText());
        cs.setNum1(num11);
        cs.setNum2(num22);
    }
}
