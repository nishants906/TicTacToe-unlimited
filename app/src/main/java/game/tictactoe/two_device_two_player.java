package game.tictactoe;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class two_device_two_player extends AppCompatActivity {

    public static Activity act_2p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        act_2p = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_device_two_player);
    }

}
