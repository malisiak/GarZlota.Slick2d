import org.newdawn.slick.*;

/**
 * draw score on the top level's scene
 */
public class Panel {

    public static int panelWidth = Main.WIDTH;
    public static int panelHight = 80;
    Image clover3;
    Image clover4;
    Image pot;
    Image string1;

    // font object
    private ChooseFont font = new ChooseFont();

    /**
     * draw elements of panel
     *
     * @param g - graphics object
     * @param amountOfCoins - amount of coins
     * @param amountOfClover4 - amount of 4-leaf clover
     * @param amountOfClover3 - amount of 3-leaf clover
     * @param stateID - number of scene
     * @throws SlickException
     */
    public void drawPanel(Graphics g, int amountOfCoins, int amountOfClover4, int amountOfClover3, int stateID) throws SlickException {

        g.setColor(Color.white);
        // set which level and draw proper image
        if (stateID == Main.garZlota.getID()) {
            string1 = new Image("graph/napis1.png");
        } else if (stateID == Main.level2.getID()) {
            string1 = new Image("graph/napis2.png");
        }
        clover3 = new Image("graph/kon3pomPanel.png");
        clover4 = new Image("graph/k4apomPanel.png");
        pot = new Image("graph/garZlotaPanel.png");

        //g.drawImage(string1, 20, 20);
        g.setFont(font.chooseFont(20));
        if (stateID == Main.garZlota.getID()) {
            g.drawString("POZIOM 1", 20, 20);
        } else if (stateID == Main.level2.getID()) {
            g.drawString("POZIOM 2", 20, 20);
        }
        g.setColor(Color.white);
        g.drawImage(clover3, 825, 10);
        g.drawString(amountOfClover3 + "", 880, 60);
        g.drawImage(clover4, 975, 10);
        g.drawString(amountOfClover4 + "", 1020, 60);
        g.drawImage(pot, 1125, 10);
        g.drawString(amountOfCoins + "", 1190, 60);
    }

}
