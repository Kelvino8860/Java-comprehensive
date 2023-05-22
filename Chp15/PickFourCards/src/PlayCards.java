import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class PlayCards extends GridPane {
    
    private Image[] image = new Image[54];
    private int i,j,k,l,m;

    public PlayCards(){

        for(i = 0; i < 54; i++){
            String num = String.valueOf(i + 1);
            image[i] = new Image("card/" + num + ".png");
        }

        fourCards();
    }
    public void fourCards(){

        boolean sameValue = false;

        do{

            j = (int)(Math.random()*54);
            k = (int)(Math.random()*54);
            l = (int)(Math.random()*54);
            m = (int)(Math.random()*54);

            if((j == k) || (j == l) || (j == m) || (k == l) || (k == m) ||
                 (l == m)){

                    sameValue = false;
                 }
            else{

                sameValue = true;
            }
        
        }while(!sameValue);

        setHgap(5);
        setAlignment(Pos.CENTER);
        add(new ImageView(image[j]), 0, 0);
        add(new ImageView(image[k]), 1, 0);
        add(new ImageView(image[l]), 2, 0);
        add(new ImageView(image[m]), 3, 0);
    }
}
