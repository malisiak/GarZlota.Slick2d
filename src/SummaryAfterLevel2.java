import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Martyna on 05.01.2016.
 */
public class SummaryAfterLevel2 extends Scenery {

    // image object
  /*  private Image coins;
    private Image clover4;
    private Image clover3; */
    // score for level 1
    public static int scoreLevel2;

    @Override
    public void init(GameContainer gc, StateBasedGame stateBasedGame) throws SlickException {
        //  object initialization from abstract class Scenery
        initialization(gc);

        //image initialization
        imageInitialization(gc);


    }
    public void update(GameContainer gameContainer, StateBasedGame sbg, int i) throws SlickException {
        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            mousePressed(sbg, Mouse.getX(), Mouse.getY(), "Summary"); //!!! Zmienic Summary
        }
        else{}

        // set score for level 2
        scoreLevel2 = GameStatus.levelScore();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

        System.out.println("po drugim "+ scoreLevel2);
        // draw elements from abstract class Scenery
        drawScenery(g);
        g.drawString("PODSUMOWANIE PO LEVELU2", 500f, 500f);
        g.drawString("Twoj wynik: " + scoreLevel2, 600f, 600f);
        System.out.println(" level + level" + scoreLevel2+Summary.scoreLevel1);
        System.out.println("z funkcji"+GameStatus.gameScore());
    }

    @Override

    public int getID() {
        return 5;
    }
}
