import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

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
    public static Animationn animation;


    public Main(String title) {
        super(title);

        menu = new Menu();
        ranking = new Ranking();
        garZlota = new GarZlota();
        summary = new Summary();
        level2 = new Level2();
        summaryAl2 = new SummaryAfterLevel2();
        gameOverWindow = new GameOverWindow();
        animation = new Animationn();


        // add scene

        this.addState(garZlota);

        this.addState(animation);
        this.addState(menu);
        this.addState(ranking);
        this.addState(summaryAl2);
        this.addState(menu);
        this.addState(summaryAl2);
        this.addState(garZlota);
        this.addState(ranking);
        this.addState(menu);
        this.addState(summary);

        this.addState(level2);
        this.addState(gameOverWindow);


        this.addState(summaryAl2);

        this.addState(ranking);


    }

    @Override
    public void initStatesList(GameContainer gb) throws SlickException {

        // initialize scenes
this.getState(animation.getID()).init(gb, this);
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


    public static void main(String[] args) {

        try {
            // create new window
            AppGameContainer app = new AppGameContainer(new Main(title));
            // set size of game window
            app.setDisplayMode(WIDTH, HEIGHT, false);
            // set amount of fps
            app.setTargetFrameRate(50);
           // remove String FPS
            app.setShowFPS(true);
            // start game
            app.start();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}



