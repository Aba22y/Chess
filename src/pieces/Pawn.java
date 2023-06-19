package pieces;

public class Pawn extends Piece{

    public Pawn(boolean black) {
        if (black) {
            this.image = imageUtil.getImage("black", "bpawn");
        } else {
            this.image = imageUtil.getImage("white", "wpawn");
        }
    }
}
