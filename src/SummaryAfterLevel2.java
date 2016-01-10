import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Summary after level2
 */
public class SummaryAfterLevel2 extends Scenery {
    // score for level 1
    public static int scoreLevel2 = 0;

    /**
     * initialize object
     *
     * @param gc The container holing this game
     * @param stateBasedGame StateBasedGame object
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {
        //  object initialization from abstract class Scenery
        initialization(gc);

        //image initialization
        imageInitialization(gc);
    }

    /**
     * update param per delta
     *
     * @param gameContainer The container holing this game
     * @param sbg StateBasedGame object
     * @param i The amount of time thats passed since last update in milliseconds
     * @throws SlickException
     */
    public void update(GameContainer gameContainer, StateBasedGame sbg, int i) throws SlickException {
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed(sbg, Mouse.getX(), Mouse.getY(), "SummaryAfterLevel2");
        }
        scoreLevel2 = GameStatus.levelScore();
    }

    /**
     * draw elements
     *
     * @param gc  The container holing this game
     * @param stateBasedGame  StateBasedGame object
     * @param g graphics object
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

        // draw elements from abstract class Scenery
        drawScenery(g);
        // draw buttons
        drawButton(g, "MENU", 480, 630);
        drawButton(g, "WYJDZ", 700, 630);
        g.setColor(Color.white);
        g.setFont(font.chooseFont(40));
        g.drawString("Brawo!", 540f, 125f);
        g.setFont(font.chooseFont(30));
        g.drawString("Udalo Ci sie napelnic gar zlotem!", 370f, 185f);
        g.drawString("Wynik koncowy: " + GameStatus.gameScore(), 480f, 235f);
//        System.out.println("Drugi poziom - punkty: SummaryAfterLevel2 - render: " + SummaryAfterLevel2.scoreLevel2);
        g.drawString("W drugim poziomie zdobyles: " + scoreLevel2, 350f, 290f);
        g.drawString("W drugim poziomie zebrales: ", 350f, 335f);
        g.drawImage(coins, 400f, 390f);
        g.drawString(" " + GameStatus.amountOfCoins, 520f, 390f);
        g.drawImage(clover4, 400f, 475f);
        g.drawString("" + GameStatus.amountOfClover4, 530f, 475f);
        g.drawImage(clover3, 400f, 545f);
        g.drawString("" + GameStatus.amountOfClover3, 530f, 545f);
    }

    /**
     * return scene ID
     *
     * @return
     */
    @Override

    public int getID() {
        return 5;
    }
}
