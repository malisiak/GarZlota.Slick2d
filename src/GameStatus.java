import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.lwjgl.input.Cursor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Responsible for game status - this class count result
 */
public class GameStatus {

    // time for level
    static int gameTime = 0;
    // Score
    static int score = 0;
    private static int gameScore = 0;
    // false when time of level is less than 20sek
    static boolean limitTime = false;

    static int amountOfClover3 = 0;
    static int amountOfClover4 = 0;
    static int amountOfCoins = 0;


    /**
     * measure time game
     *
     * @param delta  The amount of time thats passed since last update in milliseconds
     * @return
     */
    public static boolean gameTime(int delta) {

        gameTime = gameTime + delta;

        if (gameTime > 30000) {

            gameTime = 0;
            return limitTime = true;

        } else return limitTime = false;
    }

    /**
     * return score, which player win in level
     *
     * @return
     */

    public static int levelScore() {

        score = amountOfCoins * 3 + amountOfClover4 * 5 - amountOfClover3 * 5;
        return score;
    }

    /**
     * return score, which player win in game
     *
     * @return
     */

    public static int gameScore() {
        gameScore = Summary.scoreLevel1 + SummaryAfterLevel2.scoreLevel2;
        return gameScore;
    }

    /**
     * Function return amount of given element
     *
     * @param path  image resource
     * @return
     */

    public int Count(String path) {

        if ("graph/monetapom.png".equals(path)) {

            amountOfCoins++;
            return amountOfCoins;
        } else if ("graph/k4apom.png".equals(path)) {

            amountOfClover4++;
            return amountOfClover4;


        } else if ("graph/kon3pom.png".equals(path)) {

            amountOfClover3++;
            return amountOfClover3;
        } else {
            return 0;
        }
    }


}

