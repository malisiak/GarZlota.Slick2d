import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Martyna on 28.12.2015.
 */
public class Ranking extends Scenery {


    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        //  object initialization from abstract class Scenery
        initialization(gc);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        // check if mouse pressed on the 'button'
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed(sbg, Mouse.getX(), Mouse.getY(), "Ranking");
        }
        else{}
        // System.out.println(mouse);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        // draw elements from abstract class Scenery
        drawScenery(g);
        // draw buttons
        drawButton(g,"WYJDZ", 290, 630);
        drawButton(g,"MENU", 585, 630);
        drawButton(g,"GRAJ", 880, 630);
    }

    @Override
    public int getID() {
        return 1;
    }
}
