import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.lwjgl.input.Cursor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Martyna on 02.01.2016.
 */
public class GameStatus {

    // time for level
    static int gameTime = 0;
    // Score
    static int score =0;
    private static int gameScore=0;
    // false when time of level is less than 20sek
    static boolean limitTime = false;

    static int  amountOfClover3=0;
    static int  amountOfClover4=0;
    static int  amountOfCoins=0;


    public static boolean gameTime(int delta) {


        gameTime= gameTime + delta;


        if (gameTime >  7000) {

            gameTime = 0;
            return limitTime = true;

        }
        else return limitTime=false;
    }

        // return score, which player win in level
        public static int levelScore() {
            score = amountOfCoins + amountOfClover4 * 3 - amountOfClover3 * 2;
            return score ;
        }
    // return score, which player win in game
    public static int gameScore(){
        gameScore = Summary.scoreLevel1 + SummaryAfterLevel2.scoreLevel2;
        System.out.println("Koncowe: "+ gameScore);
        return gameScore;

    }

    // Function return amount of given element
    public  int Count (String path) {

        if ("graph/monetapom.png".equals(path)) {

            amountOfCoins++;
            return amountOfCoins;
        } else if ("graph/k4apom.png".equals(path)) {

            amountOfClover4++;
            return amountOfClover4;


        } else if ("graph/kon3pom.png".equals(path)) {

            amountOfClover3++;
            return amountOfClover3;
        }
        else {return 0;}
    }


}

