package game.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class two_player_choices extends AppCompatActivity {

    Button single_device;
    Button two_device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_choices);

        single_device = (Button) findViewById(R.id.singleRBtn);
        two_device = (Button) findViewById(R.id.doubleRBtn);

        single_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(two_player_choices.this, two_player_names.class);
                startActivity(intent);
            }
        });
        two_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(two_player_choices.this, two_device_two_player_name.class);
                startActivity(intent);

            }
        });


    }
}
