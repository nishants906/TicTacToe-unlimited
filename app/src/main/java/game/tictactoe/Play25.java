package game.tictactoe;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Play25 extends AppCompatActivity {
    int CELLS = 7;
    Button[][] buttons = ((Button[][]) Array.newInstance(Button.class, new int[]{this.CELLS, this.CELLS}));
    private Game5 mGame;
    private boolean mGameOver = false;
    private TextView mInfoTextView;
    private TextView mTieCount;
    private int mTieCounter = 0;
    private TextView pOneCount;
    private int pOneCounter = 0;
    private boolean pOneFirst = true;
    private TextView pTwoCount;
    private int pTwoCounter = 0;
    TableLayout table;
    LinearLayout tableParent;

    private class ButtonClickListener implements OnClickListener {
        int i;
        int j;

        public ButtonClickListener(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void onClick(View view) {
            boolean z;
            if (!Play25.this.mGameOver && Play25.this.buttons[this.i][this.j].isEnabled()) {
                Play25 play25;
                int winner;
                if (Play25.this.pOneFirst) {
                    Play25.this.setMove(TicTacToeGame.HUMAN_PLAYER, this.i, this.j);
                    winner = Play25.this.mGame.checkForWinner(this.i, this.j);
                    Play25.this.mInfoTextView.setText("turn_player_two");
                    if (winner == 0) {
                        Play25.this.mInfoTextView.setText("turn_player_one");
                        Toast.makeText(Play25.this, "turn_player_one", Toast.LENGTH_SHORT).show();
                    } else if (winner == 1) {
                        Play25.this.mInfoTextView.setText("result_tie");
                        play25 = Play25.this;
                        play25.mTieCounter = play25.mTieCounter + 1;
                        Play25.this.mTieCount.setText(Integer.toString(Play25.this.mTieCounter));
                        Play25.this.mGameOver = true;
                        Play25.this.showAlert("It's a tie");
                    } else if (winner == 3) {
                        Play25.this.mInfoTextView.setText("result_player_one_wins");
                        play25 = Play25.this;
                        play25.pOneCounter = play25.pOneCounter + 1;
                        Play25.this.pOneCount.setText(Integer.toString(Play25.this.pOneCounter));
                        Toast.makeText(Play25.this, "result_player_one_wins", Toast.LENGTH_SHORT).show();
                        Play25.this.mGameOver = true;
                        Play25.this.showAlert("Player One Won!");
                    } else {
                        Play25.this.mInfoTextView.setText("result_player_two_wins");
                        play25 = Play25.this;
                        play25.pTwoCounter = play25.pTwoCounter + 1;
                        Play25.this.pTwoCount.setText(Integer.toString(Play25.this.pTwoCounter));
                        Toast.makeText(Play25.this, "result_player_two_wins", Toast.LENGTH_SHORT).show();
                        Play25.this.mGameOver = true;
                        Play25.this.showAlert("Player Two Won!");
                    }

                    play25 = Play25.this;
                    if (!Play25.this.pOneFirst) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    Play25.this.setMove(TicTacToeGame.ANDROID_PLAYER, this.i, this.j);
                    winner = Play25.this.mGame.checkForWinner(this.i, this.j);
                    if (winner == 0) {
                        Play25.this.mInfoTextView.setText("turn_player_two");
                        Toast.makeText(Play25.this, "turn_player_two", Toast.LENGTH_SHORT).show();
                    } else if (winner == 1) {
                        Play25.this.mInfoTextView.setText("result_tie");
                        play25 = Play25.this;
                        play25.mTieCounter = play25.mTieCounter + 1;
                        Play25.this.mTieCount.setText(Integer.toString(Play25.this.mTieCounter));
                        Play25.this.mGameOver = true;
                        Play25.this.showAlert("It's a tie");
                    } else if (winner == 3) {
                        Play25.this.mInfoTextView.setText("result_player_one_wins");
                        play25 = Play25.this;
                        play25.pOneCounter = play25.pOneCounter + 1;
                        Play25.this.pOneCount.setText(Integer.toString(Play25.this.pOneCounter));
                        Toast.makeText(Play25.this, "result_player_one_wins", Toast.LENGTH_SHORT).show();
                        Play25.this.mGameOver = true;
                        Play25.this.showAlert("Player One Won!");
                    } else {
                        Play25.this.mInfoTextView.setText("result_player_two_wins");
                        play25 = Play25.this;
                        play25.pTwoCounter = play25.pTwoCounter + 1;
                        Play25.this.pTwoCount.setText(Integer.toString(Play25.this.pTwoCounter));
                        Toast.makeText(Play25.this, "result_player_two_wins", Toast.LENGTH_SHORT).show();
                        Play25.this.mGameOver = true;
                        Play25.this.showAlert("Player Two Won!");
                    }

                play25 = Play25.this;
                if (!Play25.this.pOneFirst) {
                    z = true;
                } else {
                    z = false;
                }
            }
                play25.pOneFirst = z;
            }
        }
    }

    public void newGame(View view) {
        startNewGame();
    }

    public void exitGame(View view) {
        finish();
    }

    private void startNewGame() {
        this.mGame.clearBoard();
        for (int i = 0; i < this.CELLS; i++) {
            for (int j = 0; j < this.CELLS; j++) {
                this.buttons[i][j].setText("");
                this.buttons[i][j].setBackgroundResource(R.drawable.blank);
                this.buttons[i][j].setEnabled(true);
                this.buttons[i][j].setOnClickListener(new ButtonClickListener(i, j));
            }
        }
        if (this.pOneFirst) {
            this.mInfoTextView.setText("turn_player_one");
            this.pOneFirst = false;
        } else {
            this.mInfoTextView.setText("turn_player_two");
            this.pOneFirst = true;
        }
        this.mGameOver = false;
    }

    private void showAlert(String winer) {
        Builder builder1 = new Builder(this);
        builder1.setMessage(new StringBuilder(String.valueOf(winer)).append("\nWould you like to start a new game?").toString());
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Play25.this.startNewGame();
            }
        });
        builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder1.create().show();
    }

    private void setMove(char player, int i, int j) {
        this.mGame.setMove(player, i, j);
        this.buttons[i][j].setEnabled(false);
        if (player == TicTacToeGame.HUMAN_PLAYER) {
            this.buttons[i][j].setBackgroundResource(R.drawable.x);
        } else {
            this.buttons[i][j].setBackgroundResource(R.drawable.o);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play25);
        this.tableParent = (LinearLayout) findViewById(R.id.tableParent);
        this.table = new TableLayout(this);
        for (int i = 0; i < this.CELLS; i++) {
            TableRow newRow = new TableRow(this);
            for (int j = 0; j < this.CELLS; j++) {
                this.buttons[i][j] = new Button(this);
                this.buttons[i][j].setText(String.valueOf(i) + " " + String.valueOf(j));
                newRow.addView(this.buttons[i][j]);
                int heightDp = (int) ((30.0f * getResources().getDisplayMetrics().density) + 0.5f);
                LayoutParams params = this.buttons[i][j].getLayoutParams();
                params.height = heightDp;
                params.width = heightDp;
                this.buttons[i][j].setLayoutParams(params);
                this.buttons[i][j].requestLayout();
            }
            newRow.setGravity(17);
            this.table.addView(newRow);
        }
        this.tableParent.addView(this.table);
        this.mInfoTextView = (TextView) findViewById(R.id.information);
        this.pOneCount = (TextView) findViewById(R.id.humanCount);
        this.mTieCount = (TextView) findViewById(R.id.tiesCount);
        this.pTwoCount = (TextView) findViewById(R.id.androidCount);
        this.pOneCount.setText(Integer.toString(this.pOneCounter));
        this.mTieCount.setText(Integer.toString(this.mTieCounter));
        this.pTwoCount.setText(Integer.toString(this.pTwoCounter));
        this.mGame = new Game5();
        LinearLayout layout = (LinearLayout) findViewById(R.id.adview25);

        startNewGame();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.play, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newGame /*2131230843*/:
                startNewGame();
                break;
            case R.id.exitGame /*2131230844*/:
                finish();
                break;
            case R.id.shareResult /*2131230845*/:
                break;
        }
         return true;
    }

}
