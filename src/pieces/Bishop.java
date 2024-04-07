package pieces;

public class Bishop extends Piece{

    public Bishop(boolean black) {
        if (black) {
            this.image = imageUtil.getImage("black", "bbishop");
        } else {
            this.image = imageUtil.getImage("white", "wbishop");
        }
    }

}
