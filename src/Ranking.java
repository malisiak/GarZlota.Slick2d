import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.IOException;

/**
 * Created by Martyna on 28.12.2015.
 */
public class Ranking extends Scenery {

    // image object
    Image crown;


    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        //  object initialization from abstract class Scenery
        initialization(gc);

        // image initialization
        crown = new Image("graph/korona.png");
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

        //text on the screen
        g.setColor(Color.white);
        g.setFont(font.chooseFont(50));
        g.drawString("RANKING", Main.WIDTH/2 -160 , Main.HEIGHT/2  -210);

        g.drawImage(crown, 300f, 250f);
        g.setFont(font.chooseFont(30));
        g.drawString("Najlepszy wynik: ", 445f, 270f);

        g.drawString("Najlepszy wynik z 1-ego poziomu:  " , 265f, 370f);
        SaveReadFile.read();

        g.drawString("Najlepszy wynik z 2-ego poziomu:  ", 265, 440f);


    }

    @Override
    public int getID() {
        return 1;
    }
}
