import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *  Menu - first scene of game
 */
public class Menu extends Scenery {


    /**
     * initialize object
     * @param gc - The container holing this game
     * @param sbg - StateBasedGame object
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        //  object initialization from abstract class Scenery
        initialization(gc);
    }

    /**
     * change param per delta
     * @param gc  The container holing this game
     * @param sbg StateBasedGame sbg
     * @param delta  The amount of time thats passed since last update in milliseconds
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        // check if mouse pressed on the 'button'
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed(sbg, Mouse.getX(), Mouse.getY(), "Menu");
        }
        else{}
    }

    /**
     * draw elements
     * @param gc The container holing this game
     * @param sbg StateBasedGame sbg
     * @param g Graphics object
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        // draw elements from abstract class Scenery
        drawScenery(g);
        // draw buttons
        drawButton(g,"WYJDZ", 290, 630);
        drawButton(g,"RANKING", 565, 630);
        drawButton(g,"GRAJ", 880, 630);

        // text on the screen
        g.setFont(font.chooseFont(50));
        g.setColor(Color.white);
        g.drawString("GAR ZLOTA", Main.WIDTH/2 -170 , Main.HEIGHT/2  -210);

        g.setFont(font.chooseFont(30));
        g.drawString("Pomoz krasnalowi zdobyc jak najwieksza ", 300f, 220f);
        g.drawString("ilosc zlota, by zapelnic caly gar!", 365f, 255f);
        g.drawString("By zbierac monety skacz krasnalem", 330f, 305f);
        g.drawString("przyciskajac klawisz spacji.", 395f, 340f);
        g.drawString("Wypatruj 4-listnych koniczyn,", 375f, 390f);
        g.drawString("ale unikaj tych z 3 listkami!", 393f, 425f);
        g.drawString("Uwazaj na zderzenie z ptakiem,", 363f, 470f);
        g.drawString(" ktore spowoduje koniec gry!", 375f, 505f);

        g.setColor(Color.orange);
        g.setFont(font.chooseFont(40));
        g.drawString("P O W O D Z E N I A !", Main.WIDTH/2 -240 , 555f);
    }

    /**
     * return
     * @return
     */
    @Override
    public int getID() {
        return 0;
    }
}
