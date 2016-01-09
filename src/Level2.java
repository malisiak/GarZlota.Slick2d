import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Martyna on 04.01.2016.
 */
public class Level2 extends Game{


    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {
        /*
        object initialization from abstract class Game
        Parameters: GameCointainer, stateID
         */
        initialization (gc); //!!! zamienic na Main.garzlotagetID

    }



    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        /*
         function responsible for level time
         Parameters: GameContainer, StateBasedGame, delta
          */
        gameTime(gc, sbg, delta, Main.level2.getID());

        /*
         create flying elements from class Elements, remove them when are outside game window, and check collision
         Parameters: int stateID, int delta, StateBasedGame sbg
        */
        createFlyingElements(Main.level2.getID(), delta, sbg);

        // responsible for changing variable => rainbow's movement
        rainbowMovedEffect = rainbowMovedEffect - 8;
        if (rainbowMovedEffect < 150) {
            rainbowMovedEffect = 1000;
        }




    }
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        drawObject(g, rainbowMovedEffect, Main.level2.getID());
        spacePressed();

    }

    //the enter method is called whenever you transition into the state; restart parameters
    public void enter (GameContainer c, StateBasedGame g){
       restartGame();
    }

    public int getID() {
        return 4;
    }


}
