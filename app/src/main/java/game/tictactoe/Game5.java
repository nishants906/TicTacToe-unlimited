package game.tictactoe;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class Game5 {
    public static final char EMPTY_SPACE = ' ';
    private static int[] KScore = null;
    public static final char PONE = 'X';
    public static final char PTWO = '0';
    private static int[] TScore;
    private static String[] Truonghopo = new String[]{"\\SOO\\S", "\\SOOOX", "XOOO\\S", "\\SOOO\\S", "\\SOOOOX", "XOOOO\\S", "\\SOOOO\\S", "OOOOO"};
    private static String[] Truonghopx = new String[]{"\\SXX\\S", "\\SXXXO", "OXXX\\S", "\\SXXX\\S", "\\SXXXXO", "OXXXX\\S", "\\SXXXX\\S", "XXXXX"};
    private static int[] point = new int[]{6, 4, 4, 12, 30, 30, 3000, 10000};
    private int BOARD_SIZE = 7;
    private int INT_MAX = Integer.MAX_VALUE;
    private int[][] Val;
    private int _branch = 1;
    private char[][] cells;
    private char[][] mBoard = ((char[][]) Array.newInstance(Character.TYPE, this.BOARD_SIZE, this.BOARD_SIZE));
    private int maxdepth = 1;
    private int n = this.BOARD_SIZE;
    private Random rand;

    static {
        int[] iArr = new int[5];
        iArr[1] = 1;
        iArr[2] = 9;
        iArr[3] = 85;
        iArr[4] = 769;
        TScore = iArr;
        iArr = new int[5];
        iArr[1] = 4;
        iArr[2] = 28;
        iArr[3] = 256;
        iArr[4] = 2308;
        KScore = iArr;
    }

    public Game5() {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                this.mBoard[i][j] = EMPTY_SPACE;
            }
        }
        this.rand = new Random();
        this.Val = (int[][]) Array.newInstance(Integer.TYPE, this.n, this.n);
        this.cells = (char[][]) Array.newInstance(Character.TYPE, this.n, this.n);
    }

    public void clearBoard() {
        for (int i = 0; i < this.BOARD_SIZE; i++) {
            for (int j = 0; j < this.BOARD_SIZE; j++) {
                this.mBoard[i][j] = EMPTY_SPACE;
            }
        }
    }

    public void setMove(char player, int i, int j) {
        this.mBoard[i][j] = player;
    }

    public int checkForWinner(int pi, int pj) {
        int z;
        int i;
        int h;
        for (z = 0; z < this.BOARD_SIZE; z++) {
            int playerOneCount = 0;
            int playerTwoCount = 0;
            for (i = 0; i < this.BOARD_SIZE; i++) {
                Log.d("winner","31");
                if (this.mBoard[z][i] == EMPTY_SPACE) {
                    playerOneCount = 0;
                    playerTwoCount = 0;
                } else if (this.mBoard[z][i] == PONE) {
                    playerOneCount++;
                    playerTwoCount = 0;
                } else if (this.mBoard[z][i] == PTWO) {
                    playerOneCount = 0;
                    playerTwoCount++;
                }
                if (playerOneCount == 5) {
                    return 2;
                }
                if (playerTwoCount == 5) {
                    return 3;
                }
            }
        }
        for (z = 0; z < this.BOARD_SIZE; z++) {
            int playerOneCount = 0;
            int playerTwoCount = 0;
            Log.d("winner","2");
            for (i = 0; i < this.BOARD_SIZE; i++) {
                if (this.mBoard[i][z] == EMPTY_SPACE) {
                    playerOneCount = 0;
                    playerTwoCount = 0;
                } else if (this.mBoard[i][z] == PONE) {
                    playerOneCount++;
                    playerTwoCount = 0;
                } else if (this.mBoard[i][z] == PTWO) {
                    playerOneCount = 0;
                    playerTwoCount++;
                }
                if (playerOneCount == 5) {
                    return 2;
                }
                if (playerTwoCount == 5) {
                    return 3;
                }
            }
        }
        for (h = 0; h < this.BOARD_SIZE - 5; h++) {
            int l = 0;
            while (l < this.BOARD_SIZE - 5) {
                int playerOneCount = 0;
                int playerTwoCount = 0;
                i = l;
                Log.d("winner","3");
                for (z = h; z <= h + 5 && i <= l + 5; z++) {
                    if (this.mBoard[z][i] == EMPTY_SPACE) {
                        playerOneCount = 0;
                        playerTwoCount = 0;
                    } else if (this.mBoard[z][i] == PONE) {
                        playerOneCount++;
                        playerTwoCount = 0;
                    } else if (this.mBoard[z][i] == PTWO) {
                        playerOneCount = 0;
                        playerTwoCount++;
                    }
                    if (playerOneCount == 5) {
                        return 2;
                    }
                    if (playerTwoCount == 5) {
                        return 3;
                    }
                    i++;
                }
                l++;
            }
        }
        for (h = 0; h < this.BOARD_SIZE - 5; h++) {
            int l = 0;
            while (l < this.BOARD_SIZE - 5) {
                int playerOneCount = 0;
                int playerTwoCount = 0;
                Log.d("winner","4");
                i = l + 5;
                for (z = h; z <= h + 5 && i >= l - 5; z++) {
                    if (this.mBoard[z][i] == EMPTY_SPACE) {
                        playerOneCount = 0;
                        playerTwoCount = 0;
                    } else if (this.mBoard[z][i] == PONE) {
                        playerOneCount++;
                        playerTwoCount = 0;
                    } else if (this.mBoard[z][i] == PTWO) {
                        playerOneCount = 0;
                        playerTwoCount++;
                    }
                    if (playerOneCount == 5) {
                        return 2;
                    }
                    if (playerTwoCount == 5) {
                        return 3;
                    }
                    i--;
                }
                l++;
            }
        }
        for (int u = 0; u < this.BOARD_SIZE; u++) {
            for (int m = 0; m < this.BOARD_SIZE; m++) {
                if (this.mBoard[u][m] != EMPTY_SPACE) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public int[] minMaxAI() {
        int[] playMove;
        Log.d("winner","5");
        do {
            playMove = Solve(this.mBoard, PTWO);
        } while (this.mBoard[playMove[0]][playMove[1]] != EMPTY_SPACE);
        return playMove;
    }

    void ResetVal() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                this.Val[i][j] = 0;
            }
        }
    }

    public void EvalueCaroBoard(char[][] b, char Player) {
        int rw;
        int cl;
        int i;
        int[] iArr;
        int i2;
        ResetVal();
        for (rw = 0; rw < this.n; rw++) {
            Log.d("winner","6");
            for (cl = 0; cl < this.n - 4; cl++) {
                int cComputer = 0;
                int cPlayer = 0;
                Log.d("winner","7");
                for (i = 0; i < 5; i++) {
                    if (b[rw][cl + i] == PTWO) {
                        cComputer++;
                    }
                    if (b[rw][cl + i] == PONE) {
                        cPlayer++;
                    }
                }
                if (cComputer * cPlayer == 0 && cComputer != cPlayer) {
                    for (i = 0; i < 5; i++) {
                        Log.d("winner","8");
                        if (b[rw][cl + i] == EMPTY_SPACE) {
                            Log.d("winner","9");
                            if (cComputer == 0) {
                                if (Player == PTWO) {
                                    iArr = this.Val[rw];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + TScore[cPlayer];
                                } else {
                                    iArr = this.Val[rw];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + KScore[cPlayer];
                                }
                            }
                            if (cPlayer == 0) {
                                if (Player == PONE) {
                                    iArr = this.Val[rw];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + TScore[cComputer];
                                } else {
                                    iArr = this.Val[rw];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + KScore[cComputer];
                                }
                            }
                            if (cComputer == 4 || cPlayer == 4) {
                                iArr = this.Val[rw];
                                i2 = cl + i;
                                iArr[i2] = iArr[i2] * 2;
                            }
                        }
                    }
                }
            }
        }
        for (rw = 0; rw < this.n - 4; rw++) {
            for (cl = 0; cl < this.n - 4; cl++) {
                Log.d("winner","10");
                int cComputer = 0;
                int cPlayer = 0;
                for (i = 0; i < 5; i++) {
                    Log.d("winner","11");
                    if (b[rw + i][cl] == PTWO) {
                        cComputer++;
                    }
                    if (b[rw + i][cl] == PONE) {
                        cPlayer++;
                    }
                }
                if (cComputer * cPlayer == 0 && cComputer != cPlayer) {
                    for (i = 0; i < 5; i++) {
                        if (b[rw + i][cl] == EMPTY_SPACE) {
                            if (cComputer == 0) {
                                if (Player == PTWO) {
                                    iArr = this.Val[rw + i];
                                    iArr[cl] = iArr[cl] + TScore[cPlayer];
                                } else {
                                    iArr = this.Val[rw + i];
                                    iArr[cl] = iArr[cl] + KScore[cPlayer];
                                }
                            }
                            if (cPlayer == 0) {
                                if (Player == PONE) {
                                    iArr = this.Val[rw + i];
                                    iArr[cl] = iArr[cl] + TScore[cComputer];
                                } else {
                                    iArr = this.Val[rw + i];
                                    iArr[cl] = iArr[cl] + KScore[cComputer];
                                }
                            }
                            if (cComputer == 4 || cPlayer == 4) {
                                iArr = this.Val[rw + i];
                                iArr[cl] = iArr[cl] * 2;
                            }
                        }
                    }
                }
            }
        }
        for (rw = 0; rw < this.n - 4; rw++) {
            for (cl = 0; cl < this.n - 4; cl++) {

                Log.d("winner","12");
                int cComputer = 0;
                int cPlayer = 0;
                for (i = 0; i < 5; i++) {
                    if (b[rw + i][cl + i] == PTWO) {

                        Log.d("winner","13");
                        cComputer++;
                    }
                    if (b[rw + i][cl + i] == PONE) {
                        cPlayer++;
                    }
                }
                if (cComputer * cPlayer == 0 && cComputer != cPlayer) {
                    for (i = 0; i < 5; i++) {
                        if (b[rw + i][cl + i] == EMPTY_SPACE) {
                            if (cComputer == 0) {
                                if (Player == PTWO) {
                                    iArr = this.Val[rw + i];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + TScore[cPlayer];
                                } else {
                                    iArr = this.Val[rw + i];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + KScore[cPlayer];
                                }
                            }
                            if (cPlayer == 0) {
                                if (Player == PONE) {
                                    iArr = this.Val[rw + i];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + TScore[cComputer];
                                } else {
                                    iArr = this.Val[rw + i];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + KScore[cComputer];
                                }
                            }
                            if (cComputer == 4 || cPlayer == 4) {
                                iArr = this.Val[rw + i];
                                i2 = cl + i;
                                iArr[i2] = iArr[i2] * 2;
                            }
                        }
                    }
                }
            }
        }
        for (rw = 4; rw < this.n; rw++) {
            for (cl = 0; cl < this.n - 4; cl++) {

                Log.d("winner","14");
                int cComputer = 0;
                int cPlayer = 0;
                for (i = 0; i < 5; i++) {

                    Log.d("winner","15");
                    if (b[rw - i][cl + i] == PTWO) {
                        cComputer++;
                    }
                    if (b[rw - i][cl + i] == PONE) {
                        cPlayer++;
                    }
                }
                if (cComputer * cPlayer == 0 && cComputer != cPlayer) {
                    for (i = 0; i < 5; i++) {
                        if (b[rw - i][cl + i] == EMPTY_SPACE) {
                            if (cComputer == 0) {
                                if (Player == PTWO) {
                                    iArr = this.Val[rw - i];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + TScore[cPlayer];
                                } else {
                                    iArr = this.Val[rw - i];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + KScore[cPlayer];
                                }
                            }
                            if (cPlayer == 0) {
                                if (Player == PONE) {
                                    iArr = this.Val[rw - i];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + TScore[cComputer];
                                } else {
                                    iArr = this.Val[rw - i];
                                    i2 = cl + i;
                                    iArr[i2] = iArr[i2] + KScore[cComputer];
                                }
                            }
                            if (cComputer == 4 || cPlayer == 4) {
                                iArr = this.Val[rw - i];
                                i2 = cl + i;
                                iArr[i2] = iArr[i2] * 2;
                            }
                        }
                    }
                }
            }
        }
    }

    private State GetMaxNode() {
        int i;

        Position p = new Position(0, 0);
        ArrayList<State> list = new ArrayList();
        int t = -this.INT_MAX;
        for (i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (t < this.Val[i][j]) {
                    t = this.Val[i][j];
                    p.Set(i, j);
                    list.clear();
                    list.add(new State(p, t));
                } else if (t == this.Val[i][j]) {
                    p.Set(i, j);
                    list.add(new State(p, t));
                }
            }
        }
        for (i = 0; i < list.size(); i++) {
            this.Val[list.get(i).p.x][list.get(i).p.y] = 0;
        }
        return list.get(this.rand.nextInt(list.size()));
    }

    private int Eval(char[][] b) {
        int i;
        int j;
        String s = "";
        for (i = 0; i < this.n; i++) {
            for (j = 0; j < this.n; j++) {
                s = new StringBuilder(String.valueOf(s)).append(b[i][j]).toString();
            }
            s = new StringBuilder(String.valueOf(s)).append(";").toString();
            for (j = 0; j < this.n; j++) {
                s = new StringBuilder(String.valueOf(s)).append(b[j][i]).toString();
            }
            s = new StringBuilder(String.valueOf(s)).append(";").toString();
        }
        for (i = 0; i < this.n - 4; i++) {
            for (j = 0; j < this.n - i; j++) {
                s = new StringBuilder(String.valueOf(s)).append(b[j][i + j]).toString();
            }
            s = new StringBuilder(String.valueOf(s)).append(";").toString();
        }
        for (i = this.n - 5; i > 0; i--) {
            for (j = 0; j < this.n - i; j++) {
                s = new StringBuilder(String.valueOf(s)).append(b[i + j][j]).toString();
            }
            s = new StringBuilder(String.valueOf(s)).append(";").toString();
        }
        for (i = 4; i < this.n; i++) {
            for (j = 0; j <= i; j++) {
                s = new StringBuilder(String.valueOf(s)).append(b[i - j][j]).toString();
            }
            s = new StringBuilder(String.valueOf(s)).append(";").toString();
        }
        for (i = this.n - 5; i > 0; i--) {
            for (j = this.n - 1; j >= i; j--) {
                s = new StringBuilder(String.valueOf(s)).append(b[j][((this.n + i) - j) - 1]).toString();
            }
            s = new StringBuilder(String.valueOf(s)).append(";\n").toString();
        }
        int diem = 0;
        for (i = 0; i < Truonghopx.length; i++) {
            diem = (diem + (point[i] * matches(s, Truonghopx[i].toString()))) - (point[i] * matches(s, Truonghopo[i].toString()));
        }
        return diem;
    }

    private int matches(String data, String s) {
        int count = 0;
        while (Pattern.compile(s).matcher(data).find()) {
            count++;
        }
        return count;
    }

    public int[] Solve(char[][] bb, char Player) {
        int i;
        int[] result = new int[2];

        Log.d("done","error9");
        for (i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                this.cells[i][j] = bb[i][j];
            }
        }
        EvalueCaroBoard(this.cells, Player);
        ArrayList<State> list = new ArrayList();
        for (i = 0; i < this._branch; i++) {
            list.add(GetMaxNode());
            if (list.get(i).val > 1538) {
                Log.d("done","error4");
                break;
            }
        }
        int maxp = -this.INT_MAX;
        ArrayList<State> ListChoose = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            this.cells[list.get(i).p.x][list.get(i).p.y] = Player;
            int t = MinVal(this.cells, list.get(i), -this.INT_MAX, this.INT_MAX, 0);
            if (maxp < t) {
                Log.d("done","error5");
                maxp = t;
                ListChoose.clear();
                ListChoose.add(list.get(i));
            } else if (maxp == t) {

                Log.d("done","error8");
                ListChoose.add(list.get(i));
            }
            this.cells[list.get(i).p.x][list.get(i).p.y] = EMPTY_SPACE;
        }
        int x = this.rand.nextInt(ListChoose.size());
        result[0] = ListChoose.get(x).p.x;
        result[1] = ListChoose.get(x).p.y;
        return result;
    }

    private int MaxVal(char[][] b, State s, int alpha, int beta, int depth) {
        int val = Eval(b);
        if (depth >= this.maxdepth || Math.abs(val) > 3000) {
            Log.d("done","error6");
            return val;
        }
        int i;
        EvalueCaroBoard(b, PTWO);
        ArrayList<State> list = new ArrayList();
        for (i = 0; i < this._branch; i++) {
            list.add(GetMaxNode());
            if (list.get(i).val > 1538) {
                Log.d("done","error8");
                break;
            }
        }
        for (i = 0; i < list.size(); i++) {
            b[list.get(i).p.x][list.get(i).p.y] = '0';
            alpha = Math.max(alpha, MinVal(b, list.get(i), alpha, beta, depth + 1));
            b[list.get(i).p.x][list.get(i).p.y] = EMPTY_SPACE;
            if (alpha > beta) {
                Log.d("done","error7");
                break;
            }
        }
        return alpha;
    }

    private int MinVal(char[][] b, State s, int alpha, int beta, int depth) {
        int val = Eval(b);
        if (depth >= this.maxdepth || Math.abs(val) > 3000) {
            Log.d("done","error1");
            return val;
        }
        int i;
        EvalueCaroBoard(b, PONE);
        ArrayList<State> list = new ArrayList();
        for (i = 0; i < this._branch; i++) {
            list.add(GetMaxNode());
            if (list.get(i).val > 1538) {
                Log.d("done","error2");
                break;
            }
        }
        for (i = 0; i < list.size(); i++) {
            b[list.get(i).p.x][list.get(i).p.y] = 'X';
            beta = Math.min(beta, MaxVal(b, list.get(i), alpha, beta, depth + 1));
            b[list.get(i).p.x][list.get(i).p.y] = EMPTY_SPACE;
            if (alpha >= beta) {
                Log.d("done","error3");
                break;
            }
        }
        return beta;
    }
}