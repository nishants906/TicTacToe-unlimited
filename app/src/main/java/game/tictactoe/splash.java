package game.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;

public class splash extends Activity {

    public static int SPLASH_TIME_OUT = 2000;
    RelativeLayout splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash = (RelativeLayout) findViewById(R.id.splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                Intent intent = new Intent(splash.this, PlayingMode.class);
                startActivity(intent);
                finish();
                //    overridePendingTransition(R.anim.fadeout,R.anim.fade);
            }
        }, SPLASH_TIME_OUT);
    }
}
