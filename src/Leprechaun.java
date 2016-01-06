import javafx.beans.NamedArg;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;


/**
 * Created by Martyna on 29.12.2015.
 */
public class Leprechaun extends Image {

    // variable of Leprechaun position
    private float x;
    private float y;

    // gameStatus object
    GameStatus gameStatus = new GameStatus();

    // konstruktor Leprechaun
    public Leprechaun(float x, float y)throws SlickException{

       super("graph/krasnal.png");

        this.setX(x);
        this.setY(y);


    }

    public void setX(float x){
        this.x=x;
    }

    public void setY(float y){
        this.y=y;
    }

    public float getY(){
        return y;
    }
    public float getX(){
       return x;
   }

    // set and return leprechaun position when space is pressed
    public float jump(float y){
        setY(y);
        return getY();

    }

    // function detect collision by intersects method which takes shapes - that why we have to put imagine in rectangle
    public void checkCollision(Elements e, ArrayList list, int i, StateBasedGame sbg){

        Rectangle r = new Rectangle(e.getX() - e.getWidth()/2, e.getY() - e.getHeight()/2, e.getWidth(), e.getHeight());
        Rectangle l = new Rectangle(this.getX()-this.getWidth()/2, this.getY() - this.getHeight()/2, this.getWidth(), this.getHeight());

        if( l.intersects(r)){
            // collision with bird's elements
            if(e.getResourceReference()=="graph/bird.png"){
                sbg.enterState(Main.gameOverWindow.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
                list.remove(i);
            }
            // collision with another elements
            else {gameStatus.Count( e.getResourceReference()); // getResourceReference() - get element's path
            list.remove(i);
            }

        }

    }


}
