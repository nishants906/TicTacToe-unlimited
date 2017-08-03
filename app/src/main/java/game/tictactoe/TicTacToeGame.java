package game.tictactoe;

import java.util.Random;

public class TicTacToeGame {
    public static final char ANDROID_PLAYER = '0';
    private static final int BOARD_SIZE = 9;
    public static final char EMPTY_SPACE = ' ';
    public static final char HUMAN_PLAYER = 'X';
    private char[] mBoard = new char[BOARD_SIZE];
    private Random mRand;

    public static int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    public TicTacToeGame() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            this.mBoard[i] = EMPTY_SPACE;
        }
        this.mRand = new Random();
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            this.mBoard[i] = EMPTY_SPACE;
        }
    }

    public void setMove(char player, int location) {
        this.mBoard[location] = player;
    }

    public int getComputerMove() {
        int i = 0;
        while (i < getBOARD_SIZE()) {
            char curr;
            if (!(this.mBoard[i] == HUMAN_PLAYER || this.mBoard[i] == ANDROID_PLAYER)) {
                curr = this.mBoard[i];
                this.mBoard[i] = ANDROID_PLAYER;
                if (checkForWinner() == 3) {
                    setMove(ANDROID_PLAYER, i);
                    return i;
                }
                this.mBoard[i] = curr;
            }
            i++;
        }
        i = 0;
        while (i < getBOARD_SIZE()) {
            if (!(this.mBoard[i] == HUMAN_PLAYER || this.mBoard[i] == ANDROID_PLAYER)) {
                char curr = this.mBoard[i];
                this.mBoard[i] = HUMAN_PLAYER;
                if (checkForWinner() == 2) {
                    setMove(ANDROID_PLAYER, i);
                    return i;
                }
                this.mBoard[i] = curr;
            }
            i++;
        }
        while (true) {
            int move = this.mRand.nextInt(getBOARD_SIZE());
            if (this.mBoard[move] != HUMAN_PLAYER && this.mBoard[move] != ANDROID_PLAYER) {
                setMove(ANDROID_PLAYER, move);
                return move;
            }
        }
    }

    public int checkForWinner() {
        int i = 0;
        while (i <= 6) {
            if (this.mBoard[i] == HUMAN_PLAYER && this.mBoard[i + 1] == HUMAN_PLAYER && this.mBoard[i + 2] == HUMAN_PLAYER) {
                return 2;
            }
            if (this.mBoard[i] == ANDROID_PLAYER && this.mBoard[i + 1] == ANDROID_PLAYER && this.mBoard[i + 2] == ANDROID_PLAYER) {
                return 3;
            }
            i += 3;
        }
        i = 0;
        while (i <= 2) {
            if (this.mBoard[i] == HUMAN_PLAYER && this.mBoard[i + 3] == HUMAN_PLAYER && this.mBoard[i + 6] == HUMAN_PLAYER) {
                return 2;
            }
            if (this.mBoard[i] == ANDROID_PLAYER && this.mBoard[i + 3] == ANDROID_PLAYER && this.mBoard[i + 6] == ANDROID_PLAYER) {
                return 3;
            }
            i++;
        }
        if (this.mBoard[0] == HUMAN_PLAYER && this.mBoard[4] == HUMAN_PLAYER && this.mBoard[8] == HUMAN_PLAYER) {
            return 2;
        }
        if (this.mBoard[2] == HUMAN_PLAYER && this.mBoard[4] == HUMAN_PLAYER && this.mBoard[6] == HUMAN_PLAYER) {
            return 2;
        }
        if ((this.mBoard[0] == ANDROID_PLAYER && this.mBoard[4] == ANDROID_PLAYER && this.mBoard[8] == ANDROID_PLAYER) || (this.mBoard[2] == ANDROID_PLAYER && this.mBoard[4] == ANDROID_PLAYER && this.mBoard[6] == ANDROID_PLAYER)) {
            return 3;
        }
        i = 0;
        while (i < getBOARD_SIZE()) {
            if (this.mBoard[i] != HUMAN_PLAYER && this.mBoard[i] != ANDROID_PLAYER) {
                return 0;
            }
            i++;
        }
        return 1;
    }
}
