package pieces;

import java.awt.image.BufferedImage;

import util.Sprites;

public abstract class Piece {
    public BufferedImage image = null;
    public Sprites imageUtil = new Sprites();

    public BufferedImage getImage() {
        return image;
    } 
}
