import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * Summary after level1, show result
 */
public class Summary extends Scenery {

    // score for level 1
    public static int scoreLevel1 = GameStatus.levelScore();

    /**
     * initialize object
     *
     * @param gc  The container holing this game
     * @param stateBasedGame  StateBasedGame object
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {

        //  object initialization from abstract class Scenery
        initialization(gc);
        //image initialization
        imageInitialization(gc);
        // set score for level 1
    }
    /**
     * update param per delta
     *
     * @param gameContainer The container holing this game
     * @param sbg StateBasedGame object
     * @param i The amount of time thats passed since last update in milliseconds
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gameContainer, StateBasedGame sbg, int i) throws SlickException {

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed(sbg, Mouse.getX(), Mouse.getY(), "Summary");
        } else {
        }
        // set score for level 1
        scoreLevel1 = GameStatus.levelScore();
    }
    /**
     * draw elements
     *
     * @param gameContainer - The container holing this game
     * @param stateBasedGame - StateBasedGame object
     * @param g Graphics object
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

        // draw elements from abstract class Scenery
        drawScenery(g);
        // set type and size of font
        g.setColor(Color.white);
        g.setFont(font.chooseFont(40));
        g.drawString("Brawo!", 540f, 125f);
        g.setFont(font.chooseFont(30));
        g.drawString("Za toba pierwszy poziom!", 420f, 185f);
        g.drawString("Twoj wynik: " + scoreLevel1, 480f, 235f);
        g.drawString("Zebrales: ", 540f, 290f);
        g.drawImage(coins, 400f, 340f);
        g.drawString(" " + GameStatus.amountOfCoins, 510f, 340f);
        g.drawImage(clover4, 400f, 435f);
        g.drawString("" + GameStatus.amountOfClover4, 510f, 430f);
        g.drawImage(clover3, 400f, 520f);
        g.drawString("" + GameStatus.amountOfClover3, 510f, 520f);
        g.setColor(new Color(31, 147, 255));
        g.drawString(" DALEJ ", 800, 630);
        g.drawRect(792, 627, 148, 45);
    }
    /**
     * return scene ID
     *
     * @return
     */
    @Override
    public int getID() {
        return 3;
    }
}

