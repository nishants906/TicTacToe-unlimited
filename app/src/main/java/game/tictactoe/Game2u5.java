package game.tictactoe;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

public class Game2u5 extends ActionBarActivity {
    int CELLS = 15;
    Button[][] buttons = ((Button[][]) Array.newInstance(Button.class, new int[]{this.CELLS, this.CELLS}));
    private Gameu5 mGame;
    private boolean mGameOver = false;
    private TextView mInfoTextView;
    private TextView mTieCount;
    private int mTieCounter = 0;
    Button newGame;
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
            boolean z = false;
            if (!Game2u5.this.mGameOver && Game2u5.this.buttons[this.i][this.j].isEnabled()) {
                Game2u5 Game2u5;
                int winner;
                if (Game2u5.this.pOneFirst) {
                    Game2u5.this.setMove(TicTacToeGame.HUMAN_PLAYER, this.i, this.j);
                    winner = Game2u5.this.mGame.checkForWinner(this.i, this.j);
                    Game2u5.this.mInfoTextView.setText("turn_player_two");
                    if (winner == 0) {
                        Game2u5.this.mInfoTextView.setText("turn_player_one");
                        Toast.makeText(Game2u5.this, "turn_player_one", Toast.LENGTH_SHORT).show();
                    } else if (winner == 1) {
                        Game2u5.this.mInfoTextView.setText("result_tie");
                        Game2u5 = Game2u5.this;
                        Game2u5.mTieCounter = Game2u5.mTieCounter + 1;
                        Game2u5.this.mTieCount.setText(Integer.toString(Game2u5.this.mTieCounter));
                        Game2u5.this.mGameOver = true;
                        Game2u5.this.showAlert("It's a tie");
                    } else if (winner == 3) {
                        Game2u5.this.mInfoTextView.setText("result_player_one_wins");
                        Game2u5 = Game2u5.this;
                        Game2u5.pOneCounter = Game2u5.pOneCounter + 1;
                        Game2u5.this.pOneCount.setText(Integer.toString(Game2u5.this.pOneCounter));
                        Toast.makeText(Game2u5.this, "result_player_one_wins", Toast.LENGTH_SHORT).show();
                        Game2u5.this.mGameOver = true;
                        Game2u5.this.showAlert("Player One Won!");
                    } else {
                        Game2u5.this.mInfoTextView.setText("result_player_two_wins");
                        Game2u5 = Game2u5.this;
                        Game2u5.pTwoCounter = Game2u5.pTwoCounter + 1;
                        Game2u5.this.pTwoCount.setText(Integer.toString(Game2u5.this.pTwoCounter));
                        Toast.makeText(Game2u5.this, "result_player_two_wins", Toast.LENGTH_SHORT).show();
                        Game2u5.this.mGameOver = true;
                        Game2u5.this.showAlert("Player Two Won!");
                    }
                } else {
                    Game2u5.this.setMove(TicTacToeGame.ANDROID_PLAYER, this.i, this.j);
                    winner = Game2u5.this.mGame.checkForWinner(this.i, this.j);
                    if (winner == 0) {
                        Game2u5.this.mInfoTextView.setText("turn_player_two");
                        Toast.makeText(Game2u5.this, "turn_player_two", Toast.LENGTH_SHORT).show();
                    } else if (winner == 1) {
                        Game2u5.this.mInfoTextView.setText("result_tie");
                        Game2u5 = Game2u5.this;
                        Game2u5.mTieCounter = Game2u5.mTieCounter + 1;
                        Game2u5.this.mTieCount.setText(Integer.toString(Game2u5.this.mTieCounter));
                        Game2u5.this.mGameOver = true;
                        Game2u5.this.showAlert("It's a tie");
                    } else if (winner == 3) {
                        Game2u5.this.mInfoTextView.setText("result_player_one_wins");
                        Game2u5 = Game2u5.this;
                        Game2u5.pOneCounter = Game2u5.pOneCounter + 1;
                        Game2u5.this.pOneCount.setText(Integer.toString(Game2u5.this.pOneCounter));
                        Toast.makeText(Game2u5.this, "result_player_one_wins", Toast.LENGTH_SHORT).show();
                        Game2u5.this.mGameOver = true;
                        Game2u5.this.showAlert("Player One Won!");
                    } else {
                        Game2u5.this.mInfoTextView.setText("result_player_two_wins");
                        Game2u5 = Game2u5.this;
                        Game2u5.pTwoCounter = Game2u5.pTwoCounter + 1;
                        Game2u5.this.pTwoCount.setText(Integer.toString(Game2u5.this.pTwoCounter));
                        Toast.makeText(Game2u5.this, "result_player_two_wins", Toast.LENGTH_SHORT).show();
                        Game2u5.this.mGameOver = true;
                        Game2u5.this.showAlert("Player Two Won!");
                    }
                }
                Game2u5 = Game2u5.this;
                if (!Game2u5.this.pOneFirst) {
                    z = true;
                }
                Game2u5.pOneFirst = z;
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
                Game2u5.this.startNewGame();
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
        setContentView(R.layout.activity_game2u5);
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
        this.mGame = new Gameu5();
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

