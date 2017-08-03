package game.tictactoe;

import android.util.Log;

public class Position {
    int x;
    int y;

    public Position(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public Position() {
        Log.d("error","error");
        
    }

    public void Set(int a, int b) {
        this.x = a;
        this.y = b;
    }
}
