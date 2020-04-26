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
import src.depends.StdDraw;

public class TheArtist {
    private double px, py, r, degree;
    private double spacing = 15;
    private int width, height;
    private double goldenRatio = (Math.sqrt(5.0) + 1) / 2;

    int iter = 0;
    boolean smallChaos = false;
    BufferedImage img = null;

    TheArtist(File f) {
        try {
            img = ImageIO.read(f);
            width = img.getWidth();
            height = img.getHeight();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void calculatePointPosition(double x, double y, double grade) {
        px = x + Math.cos(Math.toRadians(grade)) * (r / 2);
        py = y + Math.sin(Math.toRadians(grade)) * (r / 2);
    }

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
            // int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            int avg = (r + g + b) / 3;
            float luminance = (r * 0.2126f + g * 0.7152f + b * 0.0722f) / 255;

            StdDraw.setPenColor(avg, avg, avg);
            StdDraw.setPenRadius((1 - luminance) / 70);
            StdDraw.point(px, -1 * py);
            StdDraw.show();
        }
    }
}