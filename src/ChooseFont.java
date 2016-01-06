import org.newdawn.slick.TrueTypeFont;

import java.awt.Font;

public class ChooseFont {

Font awtFont;

    public Font chooseAwtFont(int i, int sizeFont){
         awtFont = new Font("Verdana", Font.BOLD, 20);
        if(i == 1){
            awtFont = new Font("Verdana", Font.BOLD, sizeFont);
            return awtFont;
        }

        else { return awtFont;}
    }
    public TrueTypeFont trueTypeFont (Font awtFont){

        TrueTypeFont font = new TrueTypeFont(awtFont, true);

        return  font;
    }
    public int getWidthStr(String str, TrueTypeFont font){

       return font.getWidth(str);
    }

}
