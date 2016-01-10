
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;


/**
 * create rainbow object
 */
public class Rainbow {

    // array of rainbow's color
    final Color ARRAY_COLOR[] = {new Color(250, 7, 16), new Color(250, 92, 7), new Color(250, 246, 5),
            new Color(143, 237, 36), new Color(49, 201, 235), new Color(49, 117, 235), new Color(165, 63, 242)};

    Curve curve;

    /**
     * effect rainbow movement
     *
     * @param g Graphic object
     * @param i index od color array
     * @param j describe rainbow movement
     * @return
     */
    public Curve drawRainbow(Graphics g, int i, int j) {

        Vector2f p1 = new Vector2f(0, 600 - (8 * i)); // 550
        /** The first control point */
        Vector2f c1 = new Vector2f(j, 550 - (8 * i)); // 450
        /** The second control point */
        Vector2f c2 = new Vector2f((j / 2) + 300, 700 - (8 * i)); // 650
        /** The end point of the curve */
        Vector2f p2 = new Vector2f(1280, 550 - (8 * i)); // 500

        g.setColor(ARRAY_COLOR[i]);
        g.setLineWidth(7f);
        curve = new Curve(p1, c1, c2, p2);
        g.draw(curve);
        return curve;
    }


    /**
     * rainbow image for class  extends Scenery
     *
     * @param g graphics object
     * @return
     * @throws SlickException
     */
    public Image drawRainbow(Graphics g) throws SlickException {

        Image rainbow = new Image("graph/tecza2.png");
        rainbow.draw(90f, 30f);

        return rainbow;
    }

}