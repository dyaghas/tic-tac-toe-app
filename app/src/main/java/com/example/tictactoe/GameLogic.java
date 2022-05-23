package com.example.tictactoe;

public class GameLogic {

    private int[][] gameBoard;
    private int player = 1;

    GameLogic() {
        gameBoard = new int[3][3];
        for(int row=0; row<3;row++) {
            for(int col=0; col<3;col++) {
                gameBoard[row][col] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col) {
        if(gameBoard[row-1][col-1] == 0) {
            gameBoard[row-1][col-1] = player;

            return true;
        } else {
            return false;
        }
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }
}
