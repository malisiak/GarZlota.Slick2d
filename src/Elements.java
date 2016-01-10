import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


/**
 * Contains images, set their position and define what image will be showed
 */
public class Elements extends Image {

    private static String path;
    /**
     * coordinates of element
     */
    private float x;
    private float y;
    /*
     * bird's amount
     */
    private static int amountOfBird = 0;

    /**
     * Elements constructor
     */
    public Elements(String path, float x, float y) throws SlickException {

        super(path);
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    /**
     * function responsible for element's movement
     *
     * @param element - object type Elements
     * @param getPosition - current position of element
     */
    public static void stopElement(Elements element, float getPosition) {
        element.setX(getPosition);
    }

    public static void moveElement(Elements element, int sceneID) {
        if (sceneID == Main.garZlota.getID()) {
            element.setX(element.getX() - 8);
        } else if (sceneID == Main.level2.getID()) {

            element.setX(element.getX() - 10);
            if (element.getResourceReference() == "graph/bird.png") {
                element.setY(380f);
            }
        }
    }

    /**
     * function draw element(coins or clover), which will be displayed on the screen
     *
     * @param number  digit define which element will be choose
     * @return path path to image resource
     * @throws SlickException
     */
    public static String choose(int number) throws SlickException {


        path = "graph/monetapom.png";
        /**
         * image of coins
         */
        if (0 < number && number < 5) {
            path = "graph/monetapom.png";

        }
        /**
         * image of 4-left clover
         */
        if (6 <= number && number <= 7) {

            path = "graph/k4apom.png";
        }
        /**
         * image of three-leaft clover
         */
        if (8 <= number && number < 10) {

            path = "graph/kon3pom.png";
        }
        /**
         * image of bird - perform only at level 2, appear maximum 8 time in level2
         */
        if ((10 <= number && number <= 11) && amountOfBird < 9) {

            amountOfBird++;
            path = "graph/bird.png";
        }
        return path;
    }


}


