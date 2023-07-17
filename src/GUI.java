import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class GUI {
    private Game game = new Game();
    private final JFrame gameWindow = new JFrame("TicTacToe");
    private final JButton[][] gameButtons = this.makeGameButtons();

    public GUI() {
        this.initialize();
    }

    private void initialize() {
        this.gameWindow.setSize(300, 300);
        this.gameWindow.setResizable(false);
        this.gameWindow.getContentPane().setBackground(Color.BLACK);
        this.gameWindow.setLocationRelativeTo(null);
        this.gameWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        JPanel gameBoard = new JPanel(new GridLayout(3, 3, 10, 10));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                gameBoard.add(this.gameButtons[i][j]);
            }
        }

        this.gameWindow.add(gameBoard);
    }

    public void show() {
        JOptionPane.showMessageDialog(null, "Player 1 is X, Player 2 is O");
        this.gameWindow.setVisible(true);
    }

    private JButton[][] makeGameButtons() {
        JButton[][] buttons = new JButton[3][3];

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                JButton button = new JButton();
                button.setFocusable(false);
                button.setFont(new Font("Arial", Font.BOLD, 50));
                button.setBackground(Color.BLACK);
                buttons[i][j] = button;
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addActionListener((e) -> {
                    JButton source = (JButton)e.getSource();
                    String sign;
                    if (this.game.getRound() % 2 == 0) {
                        sign = this.game.player1.sign();
                        this.game.gameBoard[finalI][finalJ] = 1;
                    } else {
                        sign = this.game.player2.sign();
                        this.game.gameBoard[finalI][finalJ] = 2;
                    }

                    this.game.setRound(this.game.getRound() + 1);
                    source.setText(sign);
                    source.setEnabled(false);
                    if (this.game.isDone()[1] == 1) {
                        this.colorWinLine();
                        JOptionPane.showMessageDialog(this.gameWindow, "Player 1 Wins", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        this.endGame();
                    } else if (this.game.isDone()[1] == 2) {
                        this.colorWinLine();
                        JOptionPane.showMessageDialog(this.gameWindow, "Player 2 Wins", "Winner", JOptionPane.INFORMATION_MESSAGE);
                        this.endGame();
                    } else if (this.game.getRound() == 9) {
                        JOptionPane.showMessageDialog(this.gameWindow, "Draw", "Draw", JOptionPane.INFORMATION_MESSAGE);
                        this.endGame();
                    }

                });
            }
        }

        return buttons;
    }

    private void endGame() {
        int i;
        if (this.game.isDone()[1] == 1 || this.game.isDone()[1] == 2) {
            for(i = 0; i < 3; ++i) {
                for(int j = 0; j < 3; ++j) {
                    this.gameButtons[i][j].setEnabled(false);
                }
            }
        }

        i = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            this.resetGame();
        } else {
            System.exit(0);
        }

    }

    private void resetGame() {
        this.game = new Game();

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                this.gameButtons[i][j].setText("");
                this.gameButtons[i][j].setBackground(Color.BLACK);
                this.gameButtons[i][j].setEnabled(true);
            }
        }

    }

    private void colorWinLine() {
        int i;
        switch (this.game.isDone()[0]) {
            case 1 -> {
                for (i = 0; i < 3; ++i) {
                    this.gameButtons[0][i].setBackground(Color.CYAN);
                }
            }
            case 2 -> {
                for (i = 0; i < 3; ++i) {
                    this.gameButtons[1][i].setBackground(Color.CYAN);
                }
            }
            case 3 -> {
                for (i = 0; i < 3; ++i) {
                    this.gameButtons[2][i].setBackground(Color.CYAN);
                }
            }
            case 4 -> {
                for (i = 0; i < 3; ++i) {
                    this.gameButtons[i][0].setBackground(Color.CYAN);
                }
            }
            case 5 -> {
                for (i = 0; i < 3; ++i) {
                    this.gameButtons[i][1].setBackground(Color.CYAN);
                }
            }
            case 6 -> {
                for (i = 0; i < 3; ++i) {
                    this.gameButtons[i][2].setBackground(Color.CYAN);
                }
            }
            case 7 -> {
                this.gameButtons[0][0].setBackground(Color.CYAN);
                this.gameButtons[1][1].setBackground(Color.CYAN);
                this.gameButtons[2][2].setBackground(Color.CYAN);
            }
            case 8 -> {
                this.gameButtons[0][2].setBackground(Color.CYAN);
                this.gameButtons[1][1].setBackground(Color.CYAN);
                this.gameButtons[2][0].setBackground(Color.CYAN);
            }
        }

    }
}
