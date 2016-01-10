
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;

/**
 * create leprechaun
 */
public class Leprechaun extends Animation {

    // variable of Leprechaun position
    private float x;
    private float y;

    // gameStatus object
    GameStatus gameStatus = new GameStatus();

    /**
     * constructor Leprechaun
     *
     * @param x - x position
     * @throws SlickException
     */

    public Leprechaun(float x) throws SlickException {

        /**
         *Parameters:
         * frames - The sprite sheet containing the frames
         *duration - The duration each frame should be displayed for
         */
        super(new SpriteSheet("graph/krasnalSzkicPommm.png", 150, 245), 420);

        this.setX(x);

    }

    /**
     * set x position
     * @param x - x position
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * set y position
     * @param y - y position
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * return y position
     * @return
     */
    public float getY() {
        return y;
    }


    /**
     * return x position
     * @return
     */
    public float getX() {
        return x;
    }

    /**
     * set and return leprechaun position when space is pressed
     *
     * @param y - y position
     * @return
     */
    public float jump(float y) {
        stop();
        setY(y);
        return getY();

    }

    /**
     * function detect collision by intersects method which takes shapes - that why we have to put imagine in rectangle
     *
     * @param e - object from class Elements
     * @param list - ArrayList object
     * @param i - index number from arraylist
     * @param sbg - StateBasedGame
     */
    public void checkCollision(Elements e, ArrayList list, int i, StateBasedGame sbg) {

        Rectangle r = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());
        Rectangle l = new Rectangle(this.getX(), this.getY() + 20, this.getWidth() - 40, this.getHeight() - 30);

        if (l.intersects(r)) {
            // collision with bird's elements
            if (e.getResourceReference() == "graph/bird.png") {
                sbg.enterState(Main.gameOverWindow.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
                list.remove(i);
            }
            // collision with another elements
            else {
                gameStatus.Count(e.getResourceReference()); // getResourceReference() - get element's path
                list.remove(i);
            }
        }
    }
}
