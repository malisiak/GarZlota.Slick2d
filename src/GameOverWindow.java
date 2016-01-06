import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Martyna on 05.01.2016.
 */
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;


public class GameOverWindow extends Scenery {
    @Override
    public int getID() {
        return 6;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {
        initialization(gc);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

        // draw elements from abstract class Scenery
        drawScenery(g);
        // draw 'buttons'
        drawButton(g,"MENU", 470, 620);
        drawButton(g, "WYJDZ",670 ,620);

        g.setColor(Color.white);
        // set type and size of font
        g.setFont(font.trueTypeFont(font.chooseAwtFont(1, 50)));
        g.drawString("GAME OVER", Main.WIDTH/3 + 30, Main.HEIGHT/2);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame sbg, int i) throws SlickException {
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {

            mousePressed(sbg, Mouse.getX(), Mouse.getY(), "GameOverWindow");
        }
    }
}
