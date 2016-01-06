import org.newdawn.slick.*;

/**
 * Created by Martyna on 02.01.2016.
 */
public class Panel {

    public static int panelWidth = Main.WIDTH;
    public static int panelHight = 80;
    Image clover3 ;
    Image clover4 ;
    Image  pot;
    Image string1;


    // font object
    private ChooseFont font  = new ChooseFont();




    public void drawPanel(Graphics g, int amountOfCoins, int amountOfClover4, int amountOfClover3, int stateID ) throws SlickException{


        g.setColor(Color.white);
        // set which level and draw proper image
        if(stateID == Main.garZlota.getID()){
             string1 = new Image("graph/napis1.png");}
        else if(stateID == Main.level2.getID()){
            string1 = new Image("graph/napis2.png");
        }
        clover3 = new Image("graph/kon3pomPanel.png");
        clover4 = new Image("graph/k4apomPanel.png");
        pot = new Image("graph/garZlotaPanel.png");


        g.drawImage(string1, 20, 20);
        //g.setFont(font.trueTypeFont(font.chooseAwtFont(1, 30)));
       // g.drawString("POZIOM 1", 20,20);
       // g.setColor(new Color(31,147,255));
       // g.drawString("MENU ", 20,650);

        g.drawImage(clover3, 825, 10);
        g.drawString(amountOfClover3 +"", 880, 60);


        g.drawImage(clover4, 975, 10);
        g.drawString(amountOfClover4 +"", 1020, 60);


        g.drawImage(pot, 1125, 10);
        g.drawString(amountOfCoins +"", 1190, 60);

    }

}
