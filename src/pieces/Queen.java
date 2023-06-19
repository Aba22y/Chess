package pieces;

public class Queen extends Piece{

    public Queen(boolean black) {
        if (black) {
            this.image = imageUtil.getImage("black", "bqueen");
        } else {
            this.image = imageUtil.getImage("white", "wqueen");
        }
    }

}
