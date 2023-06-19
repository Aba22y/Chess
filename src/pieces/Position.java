package pieces;

import java.awt.Graphics2D;

import main.GamePanel;
import main.MouseHandler;
import util.Sprites;

public class Position {
    int row;
    int col;
    boolean highlight;
    Piece curPiece;
    GamePanel gp;
    MouseHandler mouse;
    
    public Position(int row, int col, boolean highlight, Piece curPiece, GamePanel gp, MouseHandler mouse) {
        this.row = row;
        this.col = col;
        this.highlight = highlight;
        this.curPiece = curPiece;
        this.gp = gp;
        this.mouse = mouse;
    }

    public void update() {
        if (mouse.mousePressed && mouse.x == col && mouse.y == row && curPiece != null) {
            gp.selected = gp.selected == this ? null : this;
            highlight = gp.selected == this ? true : false;
        }
    }

    public void draw(Graphics2D g2) {
        if (curPiece != null) {
            g2.drawImage(curPiece.getImage(), col * gp.tileSize, row * gp.tileSize, gp.tileSize, gp.tileSize, null);
        }
        if (highlight) {
            g2.drawImage(new Sprites().getImage("highlight",null), 
            col * gp.tileSize, row * gp.tileSize, gp.tileSize, gp.tileSize, null);
        }
    };
    
}
