package boon4681.ScreenCapt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class capt {
    public static BufferedImage WOW() {
        Rectangle screenRect = new Rectangle(0, 0, 1300, 700);
        try {
            BufferedImage screen = new Robot().createScreenCapture(screenRect);
            return screen;
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }
}
