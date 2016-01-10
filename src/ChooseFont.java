import org.newdawn.slick.TrueTypeFont;

import java.awt.Font;

/**
 * Contains various kind of font
 */
public class ChooseFont {
    /**
     * font object
     */
    Font awtFont20 = new Font("Verdana", Font.BOLD, 20);
    TrueTypeFont font20 = new TrueTypeFont(awtFont20, true);
    Font awtFont30 = new Font("Verdana", Font.BOLD, 30);
    TrueTypeFont font30 = new TrueTypeFont(awtFont30, true);
    Font awtFont40 = new Font("Verdana", Font.BOLD, 40);
    TrueTypeFont font40 = new TrueTypeFont(awtFont40, true);
    Font awtFont50 = new Font("Verdana", Font.BOLD, 50);
    TrueTypeFont font50 = new TrueTypeFont(awtFont50, true);

    /**
     * choose appropriate kind of font
     */
    public TrueTypeFont chooseFont(int sizeFont) {
        if (sizeFont == 20) {
            return font20;
        } else if (sizeFont == 30) {
            return font30;
        } else if (sizeFont == 40) {
            return font40;
        } else if (sizeFont == 50) {
            return font50;
        }
        return font20;
    }

    /**
     * return width of given string
     */
    public int getWidthStr(String str, TrueTypeFont font) {

        return font.getWidth(str);
    }

}
