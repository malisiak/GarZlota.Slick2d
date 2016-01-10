import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Abstract class Game extends BasicGameState
 */
public abstract class Game extends BasicGameState {

    /**
     * responsible for rainbow moving
     */
    int rainbowMovedEffect = 1200;

    /**
     * background object
     */
    protected Background background;

    /**
     * rainbow object
     */
    protected Rainbow rainbow;

    /**
     * leprechaun object
     */
    protected Leprechaun leprechaun;

    /**
     * object input resposnisble for detecting key pressed or mouse clicked etc
     */
    Input input;

    /**
     * collection
     */
    protected ArrayList<Elements> elements;
    /**
     * random object
     */
    protected Random random;
    /**
     * panel object
     */
    protected Panel panel;

    /**
     * boolean object
     */
    static boolean clicked = false;

    /**
     * keep sum of delta
     */
    int timePassed = 0;

    /**
     * Function is responsible for object's initialization
     *
     * @param gc - The container holing this game
     * @throws SlickException
     */
    public void initialization(GameContainer gc) throws SlickException {

        /**
         * background initialization
         */
        background = new Background();

        /**
         * rainbow initialization
         */
        rainbow = new Rainbow();
        /**
         * leprechaun initialization; arguments - position: x,y
         */
        leprechaun = new Leprechaun(200f);

        /**
         * collection initialization
         */
        elements = new ArrayList<Elements>();
        /**
         * random initialization
         */
        random = new Random();
        /**
         * input initialization
         */
        input = gc.getInput();
        /**
         * input initialization
         */
        panel = new Panel();

    }

    /**
     * function enable start new game and reset parameters
     */
    public void restartGame() {
        GameStatus.amountOfClover3 = 0;
        GameStatus.amountOfClover4 = 0;
        GameStatus.amountOfCoins = 0;
        GameStatus.gameTime = 0;
        GameStatus.score = 0;
        elements = new ArrayList<Elements>();
    }

    /**
     * Function changes scene if level is end
     *
     * @param gc   The container holing this game
     * @param sbg StateBasedGame object
     * @param delta  the amount of time thats passed since last update in milliseconds
     * @param stateID  define which scene
     */
    public void gameTime(GameContainer gc, StateBasedGame sbg, int delta, int stateID) {

        if (GameStatus.gameTime(delta)) {

            if (stateID == Main.garZlota.getID()) {
                 /*
           * Function changes scene
            *Parameters: sceneID, disappear old scene effect, appear new scene effect
             */
                sbg.enterState(Main.summary.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            } else if (stateID == Main.level2.getID()) {

                try {

                    System.out.println();
                    SaveReadFile.Save();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                sbg.enterState(Main.summaryAl2.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));

            }
        }
    }

    /**
     * create flying elements from class Elements, remove them when are outside game window, and check collision
     *
     * @param sceneID  the digit, which define which scene uses this method
     * @param delta  the amount of time thats passed since last update in milliseconds
     * @param sbg StateBasedGame object
     * @throws SlickException
     */
    public void createFlyingElements(int sceneID, int delta, StateBasedGame sbg) throws SlickException {

        timePassed = timePassed + delta + 50;

        /**
         * create new elements per about 2sek
         */
        if (timePassed > (1300 + random.nextInt(1000))) {

            timePassed = 0;

            /**
             * add new random imagine to collection from class Elements
             *Parameters: String path (is draw by Element's function - choose(int i)), element's position x, element's position y
             */
            if (sceneID == Main.garZlota.getID() && clicked == false) {
                elements.add(new Elements(Elements.choose(random.nextInt(10)), Main.WIDTH, (Main.HEIGHT / 3.45f + random.nextInt(60))));
            } else if (sceneID == Main.level2.getID()) {

                elements.add(new Elements(Elements.choose(random.nextInt(12)), Main.WIDTH, (Main.HEIGHT / 3.45f + random.nextInt(60))));
            }
        }


        /**
         * responsible for element's movement in x position
         */
        for (Elements element : elements) {
            if (clicked) {
                Elements.stopElement(element, element.getX());
            } else {
                Elements.moveElement(element, sceneID);
            }

        }

        /**
         * remove elements, which are invisible and check collision between leprechaun and elements
         */
        for (int i = elements.size() - 1; i >= 0; i--) {

            Elements e = elements.get(i);

            if (e.getX() < (0 - e.getWidth() / 2)) {
                elements.remove(i);
            }
            leprechaun.checkCollision(e, elements, i, sbg);

        }
    }

    /**
     * draw object on the scene
     *
     * @param g  Graphics object
     * @param j digit responsible for rainbow movement
     * @param stateID the digit, which define which scene uses this method
     * @throws SlickException
     */
    public void drawObject(Graphics g, int j, int stateID) throws SlickException {

        background.draw(0, 0);

        /**
         * draw rainbow
         */
        for (int i = 0; i < rainbow.ARRAY_COLOR.length; i++) {
            /**
             * graphics, int (next curve), int(rainbow's movement)
             */
            g.draw(rainbow.drawRainbow(g, i, j));
        }
        /**
         * draw elements
         */
        for (Elements element : elements) {
            element.draw(element.getX(), element.getY());
        }
        /**
         * draw Panel with points information
         */
        panel.drawPanel(g, GameStatus.amountOfCoins, GameStatus.amountOfClover4, GameStatus.amountOfClover3, stateID);
    }


    /**
     * draw leprechaun depends on key pressed or not
     */
    public void spacePressed() {
        if (input.isKeyDown(Input.KEY_SPACE)) {
            leprechaun.draw(leprechaun.getX(), leprechaun.jump(140f));
        } else {
            /**
             * start animation
             */
            leprechaun.start();
            leprechaun.setY(360);
            leprechaun.draw(leprechaun.getX(), leprechaun.getY());
        }
    }

}// end class Game
