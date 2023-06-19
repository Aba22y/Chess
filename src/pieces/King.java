package pieces;


public class King extends Piece{

    public King(boolean black) {
        if (black) {
            this.image = imageUtil.getImage("black", "bking");
        } else {
            this.image = imageUtil.getImage("white", "wking");
        }
    }
    
}
