/**
*
* D:\Git\Golden-Ratio-Image\src\TheCanvas.java
*
* @author Avinal Kumar
* @since  April 26, 2020
*/

package src;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This Class conatains the file chooser and main function.
 */
public class TheCanvas {

    public static void main(String[] args) {

        File f = openFile();
        TheArtist art = new TheArtist(f);
        art.goldenDraw();

    }

    /**
     * Chooses Image File
     * 
     * @return File object of the chosen File
     */
    public static File openFile() {
        JFileChooser open = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png");
        open.setFileFilter(filter);
        int status = open.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            return open.getSelectedFile();
        } else {
            return new File("images/avii.jpg");
        }
    }
}