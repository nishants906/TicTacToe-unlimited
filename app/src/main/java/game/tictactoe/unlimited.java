package game.tictactoe;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class unlimited extends ActionBarActivity {
    private static final String AD_UNIT_ID = "ca-app-pub-5571778247542263/5949433337";
    int CELLS = 15;
    Button[][] buttons = ((Button[][]) Array.newInstance(Button.class, new int[]{this.CELLS, this.CELLS}));
    boolean easy = false;
    RadioButton easybtn;
    RadioButton hardbtn;
    RadioGroup levelgroup;
    private Gameu5 mGame;
    private boolean mGameOver = false;
    private TextView mInfoTextView;
    private TextView mTieCount;
    private int mTieCounter = 0;
    LinearLayout p5mainlayout;
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
            if (!unlimited.this.mGameOver && unlimited.this.buttons[this.i][this.j].isEnabled()) {
                unlimited.this.setMove(TicTacToeGame.HUMAN_PLAYER, this.i, this.j);
                int winner = unlimited.this.mGame.checkForWinner(this.i, this.j);
                unlimited unlimited;
                if (winner == 0) {
                    int[] newPos = new int[2];
                    newPos = unlimited.this.mGame.minMaxAI();
                    unlimited.this.setMove(TicTacToeGame.ANDROID_PLAYER, newPos[0], newPos[1]);
                    winner = unlimited.this.mGame.checkForWinner(newPos[0], newPos[1]);
                    if (winner == 0) {
                        unlimited.this.mInfoTextView.setText(R.string.turn_human);
                        Toast.makeText(unlimited.this, R.string.turn_human, Toast.LENGTH_SHORT).show();
                    } else if (winner == 1) {
                        unlimited.this.mInfoTextView.setText(R.string.result_tie);
                        unlimited = unlimited.this;
                        unlimited.mTieCounter = unlimited.mTieCounter + 1;
                        unlimited.this.mTieCount.setText(Integer.toString(unlimited.this.mTieCounter));
                        unlimited.this.mGameOver = true;
                        showAlert("It's a tie!");
                    } else if (winner == 2) {
                        unlimited.this.mInfoTextView.setText(R.string.result_human_wins);
                        unlimited = unlimited.this;
                        unlimited.pOneCounter = unlimited.pOneCounter + 1;
                        unlimited.this.pOneCount.setText(Integer.toString(unlimited.this.pOneCounter));
                        Toast.makeText(unlimited.this, R.string.result_human_wins, Toast.LENGTH_SHORT).show();
                        unlimited.this.mGameOver = true;
                        showAlert("You won!");
                    } else {
                        unlimited.this.mInfoTextView.setText(R.string.result_android_wins);
                        unlimited = unlimited.this;
                        unlimited.pTwoCounter = unlimited.pTwoCounter + 1;
                        unlimited.this.pTwoCount.setText(Integer.toString(unlimited.this.pTwoCounter));
                        Toast.makeText(unlimited.this, R.string.result_android_wins, Toast.LENGTH_SHORT).show();
                        unlimited.this.mGameOver = true;
                        showAlert("You lose!");
                    }
                } else if (winner == 1) {
                    unlimited.this.mInfoTextView.setText(R.string.result_tie);
                    unlimited = unlimited.this;
                    unlimited.mTieCounter = unlimited.mTieCounter + 1;
                    unlimited.this.mTieCount.setText(Integer.toString(unlimited.this.mTieCounter));
                    unlimited.this.mGameOver = true;
                    showAlert("It's a tie!");
                } else if (winner == 2) {
                    unlimited.this.mInfoTextView.setText(R.string.result_human_wins);
                    unlimited = unlimited.this;
                    unlimited.pOneCounter = unlimited.pOneCounter + 1;
                    unlimited.this.pOneCount.setText(Integer.toString(unlimited.this.pOneCounter));
                    Toast.makeText(unlimited.this, R.string.result_human_wins, Toast.LENGTH_SHORT).show();
                    unlimited.this.mGameOver = true;
                    showAlert("You won!");
                } else {
                    unlimited.this.mInfoTextView.setText(R.string.result_android_wins);
                    unlimited = unlimited.this;
                    unlimited.pTwoCounter = unlimited.pTwoCounter + 1;
                    unlimited.this.pTwoCount.setText(Integer.toString(unlimited.this.pTwoCounter));
                    Toast.makeText(unlimited.this, R.string.result_android_wins, Toast.LENGTH_SHORT).show();
                    unlimited.this.mGameOver = true;
                    showAlert("You lose!");
                }
            }
        }

        private void showAlert(String winer) {
            Builder builder1 = new Builder(unlimited.this);
            builder1.setMessage(new StringBuilder(String.valueOf(winer)).append("\nWould you like to start a new game?").toString());
            builder1.setCancelable(true);
            builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    unlimited.this.startNewGame();
                }
            });
            builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            builder1.create().show();
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
        this.mGameOver = false;
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
        setContentView(R.layout.activity_unlimited);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
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
        this.mInfoTextView = (TextView) findViewById(R.id.human);
        this.mInfoTextView.setText("Player: ");
        this.mInfoTextView = (TextView) findViewById(R.id.android);
        this.mInfoTextView.setText("Android: ");
        this.mInfoTextView = (TextView) findViewById(R.id.information);
        this.pOneCount = (TextView) findViewById(R.id.humanCount);
        this.mTieCount = (TextView) findViewById(R.id.tiesCount);
        this.pTwoCount = (TextView) findViewById(R.id.androidCount);
        this.pOneCount.setText(Integer.toString(this.pOneCounter));
        this.mTieCount.setText(Integer.toString(this.mTieCounter));
        this.pTwoCount.setText(Integer.toString(this.pTwoCounter));
        this.mGame = new Gameu5();

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
