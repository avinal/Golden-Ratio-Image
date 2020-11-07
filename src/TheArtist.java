/**
*
* D:\Git\Golden-Ratio-Image\src\TheArtist.java
*
* @author Avinal Kumar
* @since  April 26, 2020
*/

package src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The class creates and draws the image according to golden ratio.
 */
public class TheArtist {
    private double px, py;// pixel cordinate
    private double r, degree;
    private double spacing = 8; // spacing between the drawn points
    private int width, height; // height and Widht of the image
    private double goldenRatio = (Math.sqrt(5.0) + 1) / 2; // The Golden Ratio 

    int iter = 0;
    BufferedImage img = null;

    /**
     * The constructor initializes with a image object to operate on. It also gives
     * the height and widht of the mage.
     * 
     * @param f A image file object
     */
    TheArtist(File f) {
        try {
            img = ImageIO.read(f);
            width = img.getWidth();
            height = img.getHeight();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Calculates the position of the next point to be drawn using cos and sin
     * functions.
     * 
     * @param x     The x coordinate of the current pixel of the image
     * @param y     The y coordinate of the current pixel of the image
     * @param grade The angle by which the point should be positioned
     */
    private void calculatePointPosition(double x, double y, double grade) {
        px = x + Math.cos(Math.toRadians(grade)) * (r / 2);
        py = y + Math.sin(Math.toRadians(grade)) * (r / 2);
    }

    /**
     * The Actual Drawing Routing. Uses StdDraw.
     */
    public void goldenDraw() {
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setXscale(-10, width + 10);
        StdDraw.setYscale(-1 * (height + 10), 10);
        StdDraw.enableDoubleBuffering();

        for (int i = 5000; i > 0; i--) {
            degree = (iter * goldenRatio) * 360;
            r = Math.sqrt(iter++) * spacing;
            calculatePointPosition(width / 2, height / 2, (degree % 360));
            if (px - 10 <= 0 || px + 10 >= width || py - 10 <= 0 || py + 10 >= height) {
                break;
            }
            int p = img.getRGB((int) px, (int) py);
            // int a = (p >> 24) & 0xff; // alpha
            int r = (p >> 16) & 0xff; // red
            int g = (p >> 8) & 0xff; // green
            int b = p & 0xff; // blue
            int avg = (r + g + b) / 3; // because i like the gray scaled ones 😊
            float luminance = (r * 0.2126f + g * 0.7152f + b * 0.0722f) / 255; // brightness

            StdDraw.setPenColor(r, g, b); // set all gray 🤗
            StdDraw.setPenRadius((1 - luminance) / 70); /** set the point size */
            StdDraw.point(px, -1 * py); // draw the point
            StdDraw.show();
        }
    }
}