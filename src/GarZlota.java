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
 * Created by Martyna on 28.12.2015.
 */
public class GarZlota extends Game {

    Image bird;
    boolean ifClicked = false;

    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {

        /*
        object initialization from abstract class Game
        Parameters: GameCointainer, stateID
         */
        initialization (gc);



    }



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

        // responsible for changing variable => rainbow's movement
        rainbowMovedEffect = rainbowMovedEffect - 8;
        if (rainbowMovedEffect < 150) {
            rainbowMovedEffect = 1000;
        }

        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed(sbg,gc, Mouse.getX(), Mouse.getY());
            //{
           //     ifClicked = true;
           // }
          //  else {ifClicked = false;}
        }




    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

        drawObject(g, rainbowMovedEffect, Main.garZlota.getID());
        spacePressed();
        //drawLeprechanum(ifJump);


        if(clicked){

            gameContainer.pause();
            drawWindow (g);
        }


    }
    //the enter method is called whenever you transition into the state; restart parameters
    public void enter (GameContainer c, StateBasedGame g){
      restartGame();
    }


    @Override
    public int getID(){return 2;}



}
