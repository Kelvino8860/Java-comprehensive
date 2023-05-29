import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Graphics extends GridPane{
    
    private Label initialLabel = new Label("Initial Velocity(m/s)");
    private TextField initialField = new TextField();
    private Label accelerationLabel = new Label("Acceleration(m/s^2)");
    private TextField accelerationField = new TextField();
    private Label timeLabel = new Label("Time(s)");
    private TextField timeField = new TextField();
    private Label finalLabel = new Label("Final Velocity(m/s)");
    private TextField finaField = new TextField();
    private Button calcButton = new Button("Calculate");

    private Calculate calculate = new Calculate();

    public Graphics(){
        setAlignment(Pos.CENTER);
        setPadding(new Insets(12,12,12,12));
        setHgap(5);
        setVgap(5);

        add(initialLabel, 0, 0);
        add(initialField, 1, 0);
        add(accelerationLabel, 0, 1);
        add(accelerationField, 1, 1);
        add(timeLabel, 0, 2);
        add(timeField, 1, 2);
        add(finalLabel, 0, 3);
        add(finaField, 1, 3);
        add(calcButton, 1, 4);
        GridPane.setHalignment(calcButton, HPos.RIGHT);

        calcButton.setOnAction(e -> calcEvent());
    }

    public void calcEvent(){

        double velocity = Double.parseDouble(initialField.getText());
        double acceleration = Double.parseDouble(accelerationField.getText());
        double time = Double.parseDouble(timeField.getText());

        calculate.setInitialVelocity(velocity);
        calculate.setAcceleration(acceleration);
        calculate.setTime(time);
         
        String finalVelocity = String.valueOf(calculate.calculator());
        finaField.setText(finalVelocity);
    }
}
