import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


/**
 * first level of game
 */
public class GarZlota extends Game {

    /**
     * initialize object
     *
     * @param gc The container holing this game
     * @param stateBasedGame  StateBasedGame object
     * @throws SlickException
     */
    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {

        /**
         * object initialization from abstract class Game
         * Parameters: GameCointainer, stateID
         */
        initialization(gc);
    }

    /**
     * change param per delta
     *
     * @param gc  The container holing this game
     * @param sbg StateBasedGame object
     * @param delta the amount of time thats passed since last update in milliseconds
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        /*
         function responsible for level time
         Parameters: GameContainer, StateBasedGame, delta
          */
        gameTime(gc, sbg, delta, Main.garZlota.getID());
        /*
         create flying elements from class Elements, remove them when are outside game window, and check collision
         Parameters: int stateID, int delta, StateBasedGame sbg
        */
        createFlyingElements(2, delta, sbg);

        /**
         * responsible for changing variable => rainbow's movement
         */
        rainbowMovedEffect = rainbowMovedEffect - 8;
        if (rainbowMovedEffect < 150) {
            rainbowMovedEffect = 1000;
        }
    }

    /**
     * draw elements
     *
     * @param gameContainer The container holing this game
     * @param stateBasedGame stateBasedGame object
     * @param g Graphics object
     * @throws SlickException
     */
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

        drawObject(g, rainbowMovedEffect, Main.garZlota.getID());
        spacePressed();
    }

    /**
     * the enter method is called whenever you transition into the state; restart parameters
     *
     * @param c The container holing this game
     * @param g StateBasedGame object
     */
    public void enter(GameContainer c, StateBasedGame g) {
        restartGame();
    }

    /**
     * return scene ID
     *
     * @return
     */
    @Override
    public int getID() {
        return 2;
    }


}
