import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 *  Main class, start program
 */
public class Main extends StateBasedGame {


    public static final int WIDTH = 1280;
    public static final int HEIGHT = 700;
    static String title = "GarZłota";

    public static Menu menu;
    public static Ranking ranking;
    public static GarZlota garZlota;
    public static Summary summary;
    public static Level2 level2;
    public static SummaryAfterLevel2 summaryAl2;
    public static GameOverWindow gameOverWindow;

    /**
     * Main constructor
     * @param title
     */
    public Main(String title) {
        super(title);

        menu = new Menu();
        ranking = new Ranking();
        garZlota = new GarZlota();
        summary = new Summary();
        level2 = new Level2();
        summaryAl2 = new SummaryAfterLevel2();
        gameOverWindow = new GameOverWindow();

        // add scene

        this.addState(menu);
        this.addState(garZlota);
        this.addState(summary);
        this.addState(level2);
        this.addState(summaryAl2);
        this.addState(gameOverWindow);
        this.addState(ranking);
    }

    /**
     * initialize scenes
     * @param gb  The container holing this game
     * @throws SlickException
     */
    @Override
    public void initStatesList(GameContainer gb) throws SlickException {

       this.getState(garZlota.getID()).init(gb, this);
       this.getState(menu.getID()).init(gb, this);
        this.getState(ranking.getID()).init(gb, this);
       this.getState(summary.getID()).init(gb, this);
       this.getState(level2.getID()).init(gb, this);
        this.getState(summaryAl2.getID()).init(gb, this);
        this.getState(gameOverWindow.getID()).init(gb,this);

        // set first screen to show
       // this.enterState(garZlota.getID());
    }


    /**
     * Main class
     * @param args
     */
    public static void main(String[] args) {

        try {
            // create new window
            AppGameContainer app = new AppGameContainer(new Main(title));
            // set size of game window
            app.setDisplayMode(WIDTH, HEIGHT, false);
            // set amount of fps
            app.setTargetFrameRate(50);
           // remove String FPS
            app.setShowFPS(false);
            // start game
            app.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



