record Player(String sign) {
}
public class Game {
    private int round = 0;
    Player player1 = new Player("X");
    Player player2 = new Player("O");
    int[][] gameBoard = new int[3][3];

    Game() {
    }

    public int getRound() {
        return this.round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int[] isDone() {
        int[] win = new int[2];
        if (this.gameBoard[0][0] != 0 && this.gameBoard[0][0] == this.gameBoard[0][1] && this.gameBoard[0][1] == this.gameBoard[0][2]) {
            if (this.gameBoard[0][1] == 1) {
                win[1] = 1;
            } else if (this.gameBoard[0][1] == 2) {
                win[1] = 2;
            }

            win[0] = 1;
        } else if (this.gameBoard[1][0] != 0 && this.gameBoard[1][0] == this.gameBoard[1][1] && this.gameBoard[1][1] == this.gameBoard[1][2]) {
            if (this.gameBoard[1][1] == 1) {
                win[1] = 1;
            } else if (this.gameBoard[1][1] == 2) {
                win[1] = 2;
            }

            win[0] = 2;
        } else if (this.gameBoard[2][0] != 0 && this.gameBoard[2][0] == this.gameBoard[2][1] && this.gameBoard[2][1] == this.gameBoard[2][2]) {
            if (this.gameBoard[2][1] == 1) {
                win[1] = 1;
            } else if (this.gameBoard[2][1] == 2) {
                win[1] = 2;
            }

            win[0] = 3;
        } else if (this.gameBoard[0][0] != 0 && this.gameBoard[0][0] == this.gameBoard[1][0] && this.gameBoard[1][0] == this.gameBoard[2][0]) {
            if (this.gameBoard[1][0] == 1) {
                win[1] = 1;
            } else if (this.gameBoard[1][0] == 2) {
                win[1] = 2;
            }

            win[0] = 4;
        } else if (this.gameBoard[0][1] != 0 && this.gameBoard[0][1] == this.gameBoard[1][1] && this.gameBoard[1][1] == this.gameBoard[2][1]) {
            if (this.gameBoard[1][1] == 1) {
                win[1] = 1;
            } else if (this.gameBoard[1][1] == 2) {
                win[1] = 2;
            }

            win[0] = 5;
        } else if (this.gameBoard[0][2] != 0 && this.gameBoard[0][2] == this.gameBoard[1][2] && this.gameBoard[1][2] == this.gameBoard[2][2]) {
            if (this.gameBoard[1][2] == 1) {
                win[1] = 1;
            } else if (this.gameBoard[1][2] == 2) {
                win[1] = 2;
            }

            win[0] = 6;
        } else if (this.gameBoard[0][0] != 0 && this.gameBoard[0][0] == this.gameBoard[1][1] && this.gameBoard[1][1] == this.gameBoard[2][2]) {
            if (this.gameBoard[1][1] == 1) {
                win[1] = 1;
            } else if (this.gameBoard[1][1] == 2) {
                win[1] = 2;
            }

            win[0] = 7;
        } else if (this.gameBoard[2][0] != 0 && this.gameBoard[2][0] == this.gameBoard[1][1] && this.gameBoard[1][1] == this.gameBoard[0][2]) {
            if (this.gameBoard[1][1] == 1) {
                win[1] = 1;
            } else if (this.gameBoard[1][1] == 2) {
                win[1] = 2;
            }

            win[0] = 8;
        }

        return win;
    }
}
