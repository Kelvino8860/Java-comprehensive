import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;
import javafx.geometry.Pos;

public class App extends Application{

    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage){
        
        //Create UI
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("Anual Interest Rate"), 0, 0);
        pane.add(tfAnnualInterestRate, 1, 0);
        pane.add(new Label("Number of Years"), 0, 1);
        pane.add(tfNumberOfYears, 1, 1);
        pane.add(new Label("Loan Amount"), 0, 2);
        pane.add(tfLoanAmount, 1, 2);
        pane.add(new Label("Monthly Payment"), 0, 3);
        pane.add(tfMonthlyPayment, 1, 3);
        pane.add(new Label("Total Payment"), 0, 4);
        pane.add(tfTotalPayment, 1, 4);
        pane.add(btCalculate, 1, 5);

        //Set properties
        pane.setAlignment(Pos.CENTER);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        //Process Event
        btCalculate.setOnAction(e -> calculateLoanPayment());

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400,250);
        primaryStage.setTitle("LoanCalculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        App.launch(args);
    }
    public void calculateLoanPayment(){

        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int years = Integer.parseInt(tfNumberOfYears.getText());
        double loanAmount = Double.parseDouble(tfLoanAmount.getText());

        double monthlyIntrest = interest / 1200;
        double monthlyAmount = (loanAmount * monthlyIntrest) / (1 - 
        (1 / Math.pow(1 + monthlyIntrest, years * 12)));

        double totalPayment = monthlyAmount * years * 12;

        tfMonthlyPayment.setText(String.format("$%.2f", monthlyAmount));
        tfTotalPayment.setText(String.format("$%.2f", totalPayment));
    }
}