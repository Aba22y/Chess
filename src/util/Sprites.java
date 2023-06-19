package util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprites {
        public BufferedImage getImage(String color, String piece) {
            try {
                if(color == "highlight" && piece == null) {
                    return ImageIO.read(getClass().getResourceAsStream("/res/"+color+".png"));
                }
                return ImageIO.read(getClass().getResourceAsStream("/res/" + color + "/" + piece + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
}
