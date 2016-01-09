import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.awt.Font;

/**
 * Created by Martyna on 04.01.2016.
 */
public abstract class Scenery extends BasicGameState {

    // background object
    protected Background background;
    // rainbow object
    protected Rainbow rainbow;
    // font object
    protected static ChooseFont font;
    // input object
    protected Input input;
    // image object

    protected Image coins;
    protected Image clover4;
    protected Image clover3;


    // Function is responsible for object's initialization
    public void initialization(GameContainer gc) throws SlickException {
        // background initialization
        background = new Background();
        //rainbow initialization
        rainbow = new Rainbow();
        // font initialization
        font = new ChooseFont();
        // input initialization
        input = gc.getInput();
    }
    // Function is responsible for image initialization
    public void imageInitialization(GameContainer gc) throws SlickException{

        coins = new Image("graph/monetapom.png");
        clover4 = new Image("graph/k4apomPanel.png");
        clover3= new Image("graph/kon3pomPanel.png");
    }

    // Function draw object
    public void drawScenery(Graphics g) throws SlickException {
        background.draw(0, 0);
        rainbow.drawRainbow(g);

    }

    // function set color and size of font, set string in rectangle and its position, draw rectangle and string
    public static void drawButton(Graphics g, String str, int xpos, int ypos) {

        g.setFont(font.chooseFont(30));

        // Get the width of the given string
        int widthStr = font.getWidthStr(str, font.chooseFont(30));
         //System.out.println(str + " " + widthStr);
        int heightStr = font.getWidthStr(str, font.chooseFont(30));
       // System.out.println(str + " " + heightStr);
        g.setColor(new Color(31, 147, 255));

        // xpos, ypos - string position
        g.drawString(str, xpos, ypos);

        /*
       Parameters:  xpos-8 -> the x coordinate of the top left corner
                    ypos - 3 -> The y coordinate of the top left corner
                    widthStr + 20 -> The width of the rectangle to draw
                    48 -> The height of the rectangle to draw
         */
        g.drawRect(xpos - 8, ypos - 3, widthStr + 20, 48);
    }

    public void mousePressed(StateBasedGame sbg, int mouseX, int mouseY, String nameClass) {

        // button from class Menu
        if (nameClass.equals("Menu")) {

            // button Graj
            if ((874 < mouseX && mouseX < 977) && (27 < mouseY && mouseY < 72)) {

                sbg.enterState(Main.garZlota.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            }
            //button Ranking

            else if ((559 < mouseX && mouseX < 773) && (27 < mouseY && mouseY < 70)) {

                sbg.enterState(Main.ranking.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            }

            // button Wyjdz
            else if ((284 < mouseX && mouseX < 419 && 27 < mouseY && mouseY < 70)) {

                System.exit(0);
            }

            // buttons from clas Ranking
        } else if (nameClass.equals("Ranking")) {

            // button WYJDZ
            if (286 < Mouse.getX() && Mouse.getX() < 420 && 30 < Mouse.getY() && Mouse.getY() < 73) {

                System.exit(0);}

            // button MENU
            if (578 < Mouse.getX() && Mouse.getX() < 692 && 30 < Mouse.getY() && Mouse.getY() < 73) {

                sbg.enterState(Main.menu.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            }

            // button GRAJ
            if (872 < Mouse.getX() && Mouse.getX() < 980 && 30 < Mouse.getY() && Mouse.getY() < 73) {

                sbg.enterState(Main.garZlota.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            }

            // buttons from clas Summary
        } else if (nameClass.equals("Summary")) {

            // button DALEJ
            if (790 < Mouse.getX() && Mouse.getX() < 940 && 30 < Mouse.getY() && Mouse.getY() < 73) {

                sbg.enterState(Main.level2.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            }
        }

        else if (nameClass.equals("SummaryAfterLevel2")) {

                // button MENU
                if (473 < Mouse.getX() && Mouse.getX() < 588 && 30 < Mouse.getY() && Mouse.getY() < 73) {

                    sbg.enterState(Main.menu.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
                }

                // buttons WYJDZ
                if (691 < Mouse.getX() && Mouse.getX() < 831 && 30 < Mouse.getY() && Mouse.getY() < 73) {

                   System.exit(0);
                }

            // buttons from clas GameOverWindows
        } else if (nameClass.equals("GameOverWindow")) {
            // buttons MENU
            if (470 < Mouse.getX() && Mouse.getX() < 568 && 20 < Mouse.getY() && Mouse.getY() < 83) {

                sbg.enterState(Main.menu.getID(), new FadeOutTransition(new Color(100, 180, 255)), new FadeInTransition(new Color(100, 180, 255)));
            }

            // button WYJDZ
        }else if  (670 < Mouse.getX() && Mouse.getX() < 789 && 20 < Mouse.getY() && Mouse.getY() < 83){
                System.exit(0);
            }

        }
    }

