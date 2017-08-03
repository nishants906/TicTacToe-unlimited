package game.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class PlayingMode extends AppCompatActivity {

    TextView one_player,two_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_mode);

        one_player = (TextView) findViewById(R.id.one_player);
        two_player = (TextView) findViewById(R.id.two_player);

        one_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayingMode.this,one_player_choices.class));


            }
        });

        two_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PlayingMode.this,two_player_choices.class));

            }
        });
    }
}
