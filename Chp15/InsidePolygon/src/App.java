/**
 * (Geometry: inside a polygon?) Write a program that draws a fixed polygon
 * with points at (30, 10), (60, 30), (50, 70), (35, 35), and (10, 50). When-
 * ever the mouse is moved, display a message indicating whether the mouse
 * point is inside the polygon at the mouse point or outside of it, as shown in
 * Figure 15.29c. To detect whether a point is inside a polygon, use the contains
 * method defined in the Node class.
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private double polygonPoints[][] = {{30,10}, {60,30},{50,70},{35,35},{10,50}};
    ObservableList<Double> list;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Text text = new Text();
        Polygon polygon = new Polygon();
        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.WHITE);
        list = polygon.getPoints();

        for(int i = 0; i < polygonPoints.length; i++){
            list.add(polygonPoints[i][0]);
            list.add(polygonPoints[i][1]);
            }

        pane.getChildren().clear();
        pane.getChildren().addAll(polygon,text);

        pane.setOnMouseMoved(e -> {
            if(polygon.contains(e.getX(), e.getY())){
                text.setText("Mouse inside polygon");
                text.setX(e.getX());
                text.setY(e.getY());
            }
            else{
                text.setText("Mouse outside polygon");
                text.setX(e.getX());
                text.setY(e.getY());
            }
        });

        Scene scene = new Scene(pane,200,100);
        primaryStage.setTitle("InsidePolygon");
        primaryStage.setScene(scene);
        primaryStage.show();
        text.requestFocus();
    }
}
