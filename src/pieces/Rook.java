package pieces;

public class Rook extends Piece{

    public Rook(boolean black) {
        if (black) {
            this.image = imageUtil.getImage("black", "brook");
        } else {
            this.image = imageUtil.getImage("white", "wrook");
        }
    }

    
}
