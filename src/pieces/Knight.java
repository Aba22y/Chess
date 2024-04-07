package pieces;

public class Knight extends Piece{

    public Knight(boolean black) {
        if (black) {
            this.image = imageUtil.getImage("black", "bhorse");
        } else {
            this.image = imageUtil.getImage("white", "whorse");
        }
    }
}
