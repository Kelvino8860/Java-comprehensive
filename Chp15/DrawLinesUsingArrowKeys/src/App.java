import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Draw lines using the arrow keys) Write a program that draws line segments
 * using the arrow keys. The line starts from (100, 100) in the pane and draws
 * toward east, north, west, or south when the right-arrow key, up-arrow key,
 * left-
 * arrow key, or down-arrow key is pressed,
 */

public class App extends Application {

    double bX = 100;
    double bY = 100;
    double eX = 100;
    double eY = 100;
    double bX2, bY2;
    double segments = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();

        Line line = new Line(bX, bY, eX, eY);
        pane.getChildren().add(line);

        line.setOnKeyPressed(e -> {
            if (e.getCode().isArrowKey()) {
                switch (e.getCode()) {
                    case DOWN:
                        bY2 = bY;
                        bY += segments;
                        eY = bY;
                        Line line1 = new Line(bX, bY2, eX, eY);
                        pane.getChildren().add(line1);
                        break;
                    case UP:
                        bY2 = bY;
                        bY -= segments;
                        eY = bY;
                        Line line2 = new Line(bX, bY2, eX, eY);
                        pane.getChildren().add(line2);
                        break;
                    case LEFT:
                        bX2 = bX;
                        bX -= segments;
                        eX = bX;
                        Line line3 = new Line(bX2, bY, eX, eY);
                        pane.getChildren().add(line3);
                        break;
                    case RIGHT:
                        bX2 = bX;
                        bX += segments;
                        eX = bX;
                        Line line4 = new Line(bX2, bY, eX, eY);
                        pane.getChildren().add(line4);
                        break;
                    default:
                        break;
                }
            }
        });

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("DrawLinesUsingArrowKeys");
        primaryStage.setScene(scene);
        primaryStage.show();
        line.requestFocus();
    }
}
