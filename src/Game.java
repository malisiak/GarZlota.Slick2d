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
 * Created by Martyna on 04.01.2016.
 */
public abstract class Game extends BasicGameState {

    // responsible for rainbow moving
    int rainbowMovedEffect = 1200;

    // background object
    protected Background background;

    // rainbow object
    protected Rainbow rainbow;

    // leprechaun object
    protected Leprechaun leprechaun;

    // object input resposnisble for detecting key pressed or mouse klicked etc
    Input input;

    // collection
    protected ArrayList<Elements> elements;


    protected Random random;

    protected int timePassed;
    // panel object
    protected Panel panel;

    protected Summary summary;

    static boolean clicked = false;

    int timeKeyDown = 0;

    boolean ifJump = false;



    // Function is responsible for object's initialization
    public void initialization (GameContainer gc)throws SlickException {



        // background initialization
        background = new Background();

        //rainbow initialization
        rainbow = new Rainbow();
        // leprechaun initialization; arguments - position: x,y
        leprechaun = new Leprechaun(200, 400);

        // collection initialization
       // elements = new ArrayList<Elements>();
        random = new Random();
        input = gc.getInput();

        panel = new Panel();

    }

    // function enable start new game and reset parameters
    public void restartGame(){
        GameStatus.amountOfClover3 = 0;
        GameStatus.amountOfClover4=0;
        GameStatus.amountOfCoins=0;
        GameStatus.gameTime=0;
        GameStatus.score=0;
        elements = new ArrayList<Elements>();
    }


    public void mousePressed(StateBasedGame sbg, GameContainer gc, int mouseX, int mouseY) {

        // button MENU
        if ((32 < mouseX && mouseX < 40) && (30 < mouseY && mouseY < 84)) {
            System.out.println(" klikasz na mnie");
            // pause the game
             gc.pause();
            //sbg.enterState(Main.menu.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            clicked = true; }

            // button TAK in warnings
           else if ((501 < Mouse.getX() && Mouse.getX() < 588) && (254 < Mouse.getY() && Mouse.getY() < 313)) {

                sbg.enterState(Main.menu.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
                System.out.println(" jestem tu");
            }

            else if ((733 < Mouse.getX() && Mouse.getX() < 813) && (268 < Mouse.getY() && Mouse.getY() < 313)) {

                clicked = false;
                gc.resume();
            }


            // return clicked = false;
        }

    public static void drawWindow(Graphics g){

                Rectangle rect = new Rectangle(Main.WIDTH/2 - 250, Main.HEIGHT/2 - 100, 500, 200);
        GradientFill gf = new GradientFill(Main.WIDTH/2, Main.HEIGHT/2, new Color(31, 147, 255),Main.WIDTH/2, 400, Color.white);

                g.fill(rect, gf);
                g.setColor(Color.white);
                g.drawString("Czy jestes pewny, ze chcesz przejsc do ", Main.WIDTH/2 - 230,Main.HEIGHT/2 - 80);
                g.drawString("MENU? ",Main.WIDTH/2 - 40, Main.HEIGHT/2 - 40);
                Scenery.drawButton(g, "TAK",Main.WIDTH/2 - 130, Main.HEIGHT/2 + 40 );
                Scenery.drawButton(g, "NIE",Main.WIDTH/2 + 100, Main.HEIGHT/2 + 40 );

        System.out.println("x:: " + Mouse.getX() + " y; "+ Mouse.getY());

            }





    public void gameTime(GameContainer gc, StateBasedGame sbg, int delta, int stateID){


        if(GameStatus.gameTime(delta)) {

            /*
            Function changes scene
            Parameters: sceneID, disappear old scene effect, appear new scene effect
             */
            if (stateID == Main.garZlota.getID()) {
                sbg.enterState(Main.summary.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            }
            else if(stateID == Main.level2.getID()){

                try {
                    System.out.println("Do pliku scoreLevel1 " + Summary.scoreLevel1);
                    System.out.println("Do pliku scoreLevel2 " + SummaryAfterLevel2.scoreLevel2);
                    SaveReadFile.Save();
                }
                catch (IOException e){
                    e.printStackTrace();
                }

                sbg.enterState(Main.summaryAl2.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));


            }
        }

    }

    // create flying elements from class Elements, remove them when are outside game window, and check collision
    public void createFlyingElements( int sceneID, int delta, StateBasedGame sbg) throws SlickException{


        timePassed = timePassed + delta +50;

        // create new elements per about 2sek
        if (timePassed > (1300 + random.nextInt(1000))) {

            timePassed = 0;

            /*
            add new random imagine to collection from class Elements
            Parameters: String path (is draw by Element's function - choose(int i)), element's position x, element's position y
             */
            if (sceneID == Main.garZlota.getID() && clicked==false) {
                elements.add(new Elements(Elements.choose(random.nextInt(10)), Main.WIDTH, (Main.HEIGHT / 3.45f + random.nextInt(60))));
            }
            else if (sceneID == Main.level2.getID()){
                elements.add(new Elements(Elements.choose(random.nextInt(12)), Main.WIDTH, (Main.HEIGHT / 3.45f + random.nextInt(60))));

            }
        }

        //!!!!!!!!!!!!!!  10! zamien na zmienna zalezna od poziomu!!!!!!
        // responsible for element's movement in x position
        for (Elements element : elements) {
            if(clicked){
                Elements.stopElement(element, element.getX());
            }
            else {Elements.moveElement(element, sceneID);}

        }

        // remove elements, which are invisible and check collision between leprechaun and elements
        for (int i = elements.size() - 1; i >= 0; i--) {

            Elements e = elements.get(i);

                if (e.getX() < (0 - e.getWidth() / 2)) {
                    elements.remove(i);
                }
                leprechaun.checkCollision(e, elements, i, sbg);



            }
        }

    public void drawObject(Graphics g, int j, int stateID) throws SlickException{

        background.draw(0,0);

        // draw rainbow
        for (int i = 0; i < rainbow.ARRAY_COLOR.length; i++) {
            g.draw(rainbow.drawRainbow(g, i, j)); // graphics, int (next curve), int(rainbow's movement)
        }

        g.setLineWidth(1); // PO CO???

        // draw elements
        for (Elements element : elements) {
            element.draw(element.getX(), element.getY());

        }
        // CO TO ROBI
        for (int i = elements.size() - 1; i >= 0; i--) {
            Elements e = elements.get(i);
        }

        // draw Panel with points information
        panel.drawPanel(g, GameStatus.amountOfCoins, GameStatus.amountOfClover4, GameStatus.amountOfClover3, stateID);

    }

    // draw leprechaun depends on key pressed or not
   /* public boolean spacePressed(int delta) {

        timeKeyDown = timeKeyDown + delta;
        System.out.println(timeKeyDown);

        if (input.isKeyDown(Input.KEY_SPACE) && timeKeyDown > 2000) {
            timeKeyDown = 0;
            return ifJump = true;

        }
        else{ return ifJump = false;}
    }
    public void drawLeprechanum(boolean ifJump){

        if(ifJump==true){
            leprechaun.draw(leprechaun.getX(), leprechaun.jump(190f));

        } else {
            leprechaun.setY(400);
            leprechaun.draw(leprechaun.getX(), leprechaun.getY());

        }
    }*/
    public void spacePressed(){
        if (input.isKeyDown(Input.KEY_SPACE)){
            leprechaun.draw(leprechaun.getX(), leprechaun.jump(190f));
        }
        else {
            leprechaun.setY(400);
            leprechaun.draw(leprechaun.getX(), leprechaun.getY());

        }
    }

    }// end class Game
