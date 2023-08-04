import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class TextFieldProp extends BorderPane implements javafx.event.EventHandler<ActionEvent>{
    
    private TextField tf = new TextField("JavaFX");
    private TextField tfColSize = new TextField();
    private Label lbTextField = new Label("Text Field");
    private Label lbColSize = new Label("Column Size");
    private RadioButton rbLeft = new RadioButton("Left");
    private RadioButton rbCenter = new RadioButton("Center");
    private RadioButton rbRight = new RadioButton("Right");
    private HBox paneForRadioButtons = new HBox();
    private GridPane paneFortf = new GridPane();
    private GridPane paneForColSize = new GridPane();
    private Integer sizeOfCol;
    private Object obj;

    public TextFieldProp(){

        ToggleGroup group = new ToggleGroup();
        rbLeft.setToggleGroup(group);
        rbCenter.setToggleGroup(group);
        rbRight.setToggleGroup(group);
        paneForRadioButtons.getChildren().addAll(rbLeft,rbCenter,rbRight);

        paneForColSize.add(lbColSize, 0, 0);
        paneForColSize.add(tfColSize, 1, 0);
        paneForColSize.setPadding(new Insets(5,5,5,5));
        paneForColSize.setHgap(10);
        paneFortf.add(lbTextField, 0, 0);
        paneFortf.add(tf, 1, 0);
        paneFortf.setPadding(new Insets(5,5,5,5));
        paneFortf.setHgap(10);

        rbLeft.setOnAction(e -> {
            handle(e);
        });
        rbRight.setOnAction(e -> {
            handle(e);
        });
        rbCenter.setOnAction(e -> {
            handle(e);
        });
        tfColSize.setOnAction(e -> {
            handle(e);
        });

        setTop(paneFortf);
        setLeft(paneForRadioButtons);
        setRight(paneForColSize);
    }

    @Override
    public void handle(ActionEvent e){
        obj = e.getSource();

        if(obj == rbLeft){
            tf.setAlignment(Pos.TOP_LEFT);
        }
        else if (obj == rbCenter){
            tf.setAlignment(Pos.CENTER);
        }
        else if (obj == rbRight){
            tf.setAlignment(Pos.TOP_RIGHT);
        }

        if (obj == tfColSize){
            sizeOfCol = Integer.parseInt(tfColSize.getText());
            tf.setPrefColumnCount(sizeOfCol);
        }
    }
}
