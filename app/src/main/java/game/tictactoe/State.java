package game.tictactoe;
public class State {
    public Position p = new Position() ;
    public int val;

    public State(Position p, int val) {
        this.p.x = p.x;
        this.p.y = p.y;
        this.val = val;
    }

}
