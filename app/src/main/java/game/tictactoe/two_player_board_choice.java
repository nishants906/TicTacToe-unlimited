package game.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class two_player_board_choice extends AppCompatActivity {

    Button easy;
    Button difficult;
    Button unlimited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_choices);

        easy = (Button) findViewById(R.id.easyRBtn);
        difficult  = (Button) findViewById(R.id.RBtn);
        unlimited = (Button) findViewById(R.id.difficultRBtn);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(two_player_board_choice.this, Play2.class);
                startActivity(intent);

            }
        });

        difficult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(two_player_board_choice.this, Play25.class);
                startActivity(intent);
            }
        });
        unlimited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(two_player_board_choice.this, Game2u5.class);
                startActivity(intent);

            }
        });


    }
}
