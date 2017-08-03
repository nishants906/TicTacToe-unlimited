package game.tictactoe;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Play extends ActionBarActivity {
    private TextView mAndroidCount;
    private int mAndroidCounter = 0;
    private Button[] mBoardButtons;
    private TicTacToeAndroid mGame;
    private boolean mGameOver = false;
    private TextView mHumanCount;
    private int mHumanCounter = 0;
    private boolean mHumanFirst = true;
    private TextView mInfoTextView;
    private TextView mTieCount;
    private int mTieCounter = 0;
    Play r2;
    private class ButtonClickListener implements OnClickListener {
        int location;

        public ButtonClickListener(int location) {
            this.location = location;
        }

        public void onClick(View view) {
            if (!Play.this.mGameOver && Play.this.mBoardButtons[this.location].isEnabled()) {
                Play.this.setMove(TicTacToeGame.HUMAN_PLAYER, this.location);
                int winner = Play.this.mGame.checkForWinner();
                if (winner == 0) {
                    Play.this.mInfoTextView.setText("turn_computer");
                    Play.this.setMove(TicTacToeGame.ANDROID_PLAYER, Play.this.mGame.getComputerMove());
                    winner = Play.this.mGame.checkForWinner();
                }
                if (winner == 0) {
                    Play.this.mInfoTextView.setText("turn_human");
                } else if (winner == 1) {
                    Play.this.mInfoTextView.setText("result_tie");
                    r2 = Play.this;
                    r2.mTieCounter = r2.mTieCounter + 1;
                    Play.this.mTieCount.setText(Integer.toString(Play.this.mTieCounter));
                    Play.this.mGameOver = true;
                } else if (winner == 2) {
                    Play.this.mInfoTextView.setText("result_human_wins");
                    r2 = Play.this;
                    r2.mHumanCounter = r2.mHumanCounter + 1;
                    Play.this.mHumanCount.setText(Integer.toString(Play.this.mHumanCounter));
                    Play.this.mGameOver = true;
                } else {
                    Play.this.mInfoTextView.setText("result_android_wins");
                    r2 = Play.this;
                    r2.mAndroidCounter = r2.mAndroidCounter + 1;
                    Play.this.mAndroidCount.setText(Integer.toString(Play.this.mAndroidCounter));
                    Play.this.mGameOver = true;
                    Play.this.mInfoTextView.setText("turn_human");
                }
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
        setContentView(R.layout.activity_play);
        this.mBoardButtons = new Button[TicTacToeAndroid.getBOARD_SIZE()];
        this.mBoardButtons[0] = (Button) findViewById(R.id.one);
        this.mBoardButtons[1] = (Button) findViewById(R.id.two);
        this.mBoardButtons[2] = (Button) findViewById(R.id.three);
        this.mBoardButtons[3] = (Button) findViewById(R.id.four);
        this.mBoardButtons[4] = (Button) findViewById(R.id.five);
        this.mBoardButtons[5] = (Button) findViewById(R.id.six);
        this.mBoardButtons[6] = (Button) findViewById(R.id.seven);
        this.mBoardButtons[7] = (Button) findViewById(R.id.eight);
        this.mBoardButtons[8] = (Button) findViewById(R.id.nine);
        this.mInfoTextView = (TextView) findViewById(R.id.information);
        this.mHumanCount = (TextView) findViewById(R.id.humanCount);
        this.mTieCount = (TextView) findViewById(R.id.tiesCount);
        this.mAndroidCount = (TextView) findViewById(R.id.androidCount);
        this.mHumanCount.setText(Integer.toString(this.mHumanCounter));
        this.mTieCount.setText(Integer.toString(this.mTieCounter));
        this.mAndroidCount.setText(Integer.toString(this.mAndroidCounter));
        this.mGame = new TicTacToeAndroid();
       
        startNewGame();
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
            this.mInfoTextView.setText("first_human");
            this.mHumanFirst = false;
        } else {
            this.mInfoTextView.setText("turn_computer");
            setMove(TicTacToeGame.ANDROID_PLAYER, this.mGame.getComputerMove());
            this.mHumanFirst = true;
        }
        this.mGameOver = false;
    }

    private void setMove(char player, int location) {
        boolean z = false;
        this.mGame.setMove(player, location);
        this.mBoardButtons[location].setEnabled(false);
        if (player == TicTacToeGame.HUMAN_PLAYER) {
            this.mBoardButtons[location].setBackgroundResource(R.drawable.x);
        } else {
            this.mBoardButtons[location].setBackgroundResource(R.drawable.o);
        }
        if (!this.mHumanFirst) {
            z = true;
        }
        this.mHumanFirst = z;
    }
}
