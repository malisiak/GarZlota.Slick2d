import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * show best result
 */
public class Ranking extends Scenery {

    // image object
    Image crown;

    /**
     * initialize object
     *
     * @param gc  The container holing this game
     * @param sbg  StateBasedGame object
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        //  object initialization from abstract class Scenery
        initialization(gc);

        // image initialization
        crown = new Image("graph/korona.png");
    }

    /**
     * change param per delta
     *
     * @param gc  The container holing this game
     * @param sbg StateBasedGame object
     * @param delta The amount of time thats passed since last update in milliseconds
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        // check if mouse pressed on the 'button'
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed(sbg, Mouse.getX(), Mouse.getY(), "Ranking");
        } else {
        }
    }

    /**
     * draw elements
     *
     * @param gc The container holing this game
     * @param sbg StateBasedGame object
     * @param g Graphic object
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        // draw elements from abstract class Scenery
        drawScenery(g);
        // draw buttons
        drawButton(g, "WYJDZ", 290, 630);
        drawButton(g, "MENU", 585, 630);
        drawButton(g, "GRAJ", 880, 630);

        //text on the screen
        g.setColor(Color.white);
        g.setFont(font.chooseFont(50));
        g.drawString("RANKING", Main.WIDTH / 2 - 160, Main.HEIGHT / 2 - 210);
        g.drawImage(crown, 300f, 250f);
        g.setFont(font.chooseFont(30));

        try {
            SaveReadFile.read();
        } catch (Exception e) {
            System.out.println("Błąd przy odczycie pliku.");
        }
        g.drawString("Najlepszy wynik: " + SaveReadFile.bestTotal, 445f, 270f);
        g.drawString("Najlepszy wynik z 1-ego poziomu: " + SaveReadFile.bestLevel1, 265f, 370f);
        g.drawString("Najlepszy wynik z 2-ego poziomu: " + +SaveReadFile.bestLevel2, 265, 440f);
    }

    /**
     * return scene ID
     *
     * @return
     */
    @Override
    public int getID() {
        return 1;
    }
}
