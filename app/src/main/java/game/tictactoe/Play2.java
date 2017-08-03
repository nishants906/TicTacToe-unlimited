package game.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Play2 extends AppCompatActivity {
    private TextView mAndroidCount;
    private int mAndroidCounter = 0;
    private Button[] mBoardButtons;
    private TicTacToeGame mGame;
    private boolean mGameOver = false;
    private TextView mHumanCount;
    private int mHumanCounter = 0;
    private boolean mHumanFirst = true;
    private TextView mInfoTextView;
    private TextView mTieCount;
    private int mTieCounter = 0;

    private class ButtonClickListener implements OnClickListener {
        int location;

        public ButtonClickListener(int location) {
            this.location = location;
        }

        public void onClick(View view) {
            boolean z = true;
            Play2 play2;
            play2 = Play2.this;
            if (!Play2.this.mGameOver && Play2.this.mBoardButtons[this.location].isEnabled()) {
                int winner;
                if (Play2.this.mHumanFirst) {
                    Play2.this.setMove(TicTacToeGame.HUMAN_PLAYER, this.location);
                    winner = Play2.this.mGame.checkForWinner();
                    Play2.this.mInfoTextView.setText("turn_player_two");
                    if (winner == 0) {
                        Play2.this.mInfoTextView.setText("turn_player_one");
                    } else if (winner == 1) {
                        Play2.this.mInfoTextView.setText("result_tie");

                        play2.mTieCounter = play2.mTieCounter + 1;
                        Play2.this.mTieCount.setText(Integer.toString(Play2.this.mTieCounter));
                        Play2.this.mGameOver = true;
                        return;
                    } else if (winner == 3) {
                        Play2.this.mInfoTextView.setText("result_player_one_wins");
                        play2 = Play2.this;
                        play2.mHumanCounter = play2.mHumanCounter + 1;
                        Play2.this.mHumanCount.setText(Integer.toString(Play2.this.mHumanCounter));
                        Play2.this.mGameOver = true;
                        return;
                    } else {
                        Play2.this.mInfoTextView.setText("result_player_two_wins");
                        play2 = Play2.this;
                        play2.mAndroidCounter = play2.mAndroidCounter + 1;
                        Play2.this.mAndroidCount.setText(Integer.toString(Play2.this.mAndroidCounter));
                        Play2.this.mGameOver = true;
                        return;
                    }
                    play2 = Play2.this;
                    if (Play2.this.mHumanFirst) {
                        z = false;
                    }
                    else{
                        z=true;
                    }
                }
                    else {

                    Play2.this.setMove(TicTacToeGame.ANDROID_PLAYER, this.location);
                    winner = Play2.this.mGame.checkForWinner();
                    if (winner == 0) {
                        Play2.this.mInfoTextView.setText("turn_player_one");
                        winner = Play2.this.mGame.checkForWinner();
                    }
                    if (winner == 0) {
                        Play2.this.mInfoTextView.setText("turn_player_two");
                    } else if (winner == 1) {
                        Play2.this.mInfoTextView.setText("result_tie");
                        play2 = Play2.this;
                        play2.mTieCounter = play2.mTieCounter + 1;
                        Play2.this.mTieCount.setText(Integer.toString(Play2.this.mTieCounter));
                        Play2.this.mGameOver = true;
                        return;
                    } else if (winner == 3) {
                        Play2.this.mInfoTextView.setText("result_player_one_wins");
                        play2 = Play2.this;
                        play2.mHumanCounter = play2.mHumanCounter + 1;
                        Play2.this.mHumanCount.setText(Integer.toString(Play2.this.mHumanCounter));
                        Play2.this.mGameOver = true;
                        return;
                    } else {
                        Play2.this.mInfoTextView.setText("result_player_two_wins");
                        play2 = Play2.this;
                        play2.mAndroidCounter = play2.mAndroidCounter + 1;
                        Play2.this.mAndroidCount.setText(Integer.toString(Play2.this.mAndroidCounter));
                        Play2.this.mGameOver = true;
                        return;
                    }
                    play2 = Play2.this;
                    if (Play2.this.mHumanFirst) {
                        z = false;
                    }
                    else{
                        z=true;
                    }
                }
                    play2.mHumanFirst = z;
            }
        }
    }

    public void newGame(View view) {
        startNewGame();
    }

    public void exitGame(View view) {
        finish();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);
        this.mBoardButtons = new Button[TicTacToeGame.getBOARD_SIZE()];
        this.mBoardButtons[0] = (Button) findViewById(R.id.one);
        this.mBoardButtons[1] = (Button) findViewById(R.id.two);
        this.mBoardButtons[2] = (Button) findViewById(R.id.three);
        this.mBoardButtons[3] = (Button) findViewById(R.id.four);
        this.mBoardButtons[4] = (Button) findViewById(R.id.five);
        this.mBoardButtons[5] = (Button) findViewById(R.id.six);
        this.mBoardButtons[6] = (Button) findViewById(R.id.seven);
        this.mBoardButtons[7] = (Button) findViewById(R.id.eight);
        this.mBoardButtons[8] = (Button) findViewById(R.id.nine);
        this.mInfoTextView = (TextView) findViewById(R.id.human);
        this.mInfoTextView.setText(getIntent().getStringExtra("p1name"));
        this.mInfoTextView = (TextView) findViewById(R.id.android);
        this.mInfoTextView.setText(getIntent().getStringExtra("p2name"));
        this.mInfoTextView = (TextView) findViewById(R.id.information);
        this.mHumanCount = (TextView) findViewById(R.id.humanCount);
        this.mTieCount = (TextView) findViewById(R.id.tiesCount);
        this.mAndroidCount = (TextView) findViewById(R.id.androidCount);
        this.mHumanCount.setText(Integer.toString(this.mHumanCounter));
        this.mTieCount.setText(Integer.toString(this.mTieCounter));
        this.mAndroidCount.setText(Integer.toString(this.mAndroidCounter));
        this.mGame = new TicTacToeGame();

        startNewGame();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.play, menu);
        return true;
    }

    private void startNewGame() {
        this.mGame.clearBoard();
        for (int i = 0; i < this.mBoardButtons.length; i++) {
            this.mBoardButtons[i].setText("");
            this.mBoardButtons[i].setBackgroundResource(R.drawable.blank);
            this.mBoardButtons[i].setEnabled(true);
            this.mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
        }
        if (this.mHumanFirst) {
            this.mInfoTextView.setText(getIntent().getStringExtra("p1name"));
            this.mHumanFirst = false;
        } else {
            this.mInfoTextView.setText(getIntent().getStringExtra("p2name"));
            this.mHumanFirst = true;
        }
        this.mGameOver = false;
    }

    private void setMove(char player, int location) {
        this.mGame.setMove(player, location);
        this.mBoardButtons[location].setEnabled(false);
        if (player == TicTacToeGame.HUMAN_PLAYER) {
            this.mBoardButtons[location].setBackgroundResource(R.drawable.x);
        } else {
            this.mBoardButtons[location].setBackgroundResource(R.drawable.o);
        }
    }
}
