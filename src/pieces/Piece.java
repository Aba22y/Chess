package pieces;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.MouseHandler;

public abstract class Piece {
    GamePanel gp;
    MouseHandler mouse;
    int row, column;
    public BufferedImage image = null;

    public Piece(GamePanel gp, MouseHandler mouseH, int row, int column) {
        this.gp = gp;
        this.row = row;
        this.mouse = mouseH;
        this.column = column;
        getPlayerImage();
    }

    public void getPlayerImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/black/bpawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (mouse.mousePressed && mouse.x == row && mouse.y == column) {
            gp.selected = this;
        }
    }

    public void draw(Graphics2D g2) {
        if (image != null) {
            g2.drawImage(image, row * 48, column * 48, gp.tileSize, gp.tileSize, null);
        }
    };
}
