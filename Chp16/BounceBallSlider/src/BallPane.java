import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class BallPane extends Pane{
    public final double radius = 20;
    private double x = radius, y = radius;
    private double dx = 1, dy = 1;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;

    public BallPane(){
        circle.setFill(Color.RED);
        getChildren().add(circle);

        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void play(){
        animation.play();
    }

    public void pause(){
        animation.pause();
    }

    public void increaseSpeed(){
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed(){
        animation.setRate(
            animation.getRate() > 0 ? animation.getRate() - 0.1 : 0
        );
    }
    
    public DoubleProperty rateProperty(){
        return animation.rateProperty();
    }

    public void changeColor(){
        double redC = Math.random();
        double greenC = Math.random();
        double blueC = Math.random();

        circle.setFill(Color.color(redC, greenC, blueC));
    }

    protected void moveBall(){
        //Check boundaries
        if(x < radius || x > getWidth() - radius){
            dx *= -1; //Change ball move direction
            changeColor(); //Changes ball colour
        }
        if(y < radius || y > getHeight() - radius){
            dy *= -1; //Change ball move direction
            changeColor(); //Changes ball colour
        }

        //Adjust ball position
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}