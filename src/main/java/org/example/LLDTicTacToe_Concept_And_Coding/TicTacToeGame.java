package org.example.LLDTicTacToe_Concept_And_Coding;

import com.sun.tools.javac.util.Pair;
import org.example.LLDTicTacToe_Concept_And_Coding.Model.*;

import java.util.*;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;
    Stack<Move> moveHistory; // Stack to store the history of moves

    public void initializeGame() {

        // creating 2 Players
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        // initializeBoard
        gameBoard = new Board(3);
        moveHistory = new Stack<>(); // Initialize move history stack
    }

    public String startGame() {

        boolean noWinner = true;
        Scanner inputScanner = new Scanner(System.in);

        while (noWinner) {

            // take out the player whose turn it is and also put the player back in the list
            Player playerTurn = players.removeFirst();

            // print the current state of the board
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            // read the user input
            System.out.print("Player " + playerTurn.name + ": Enter row,column or type 'undo' to undo last move: ");
            String s = inputScanner.nextLine();

            if (s.equalsIgnoreCase("undo")) {
                if (moveHistory.isEmpty()) {
                    System.out.println("No moves to undo!");
                } else {
                    undoLastMove();
                    players.addFirst(playerTurn);
                }
                continue;
            }

            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            // place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if (!pieceAddedSuccessfully) {
                // player cannot insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            // Add move to history
            moveHistory.push(new Move(inputRow, inputColumn, playerTurn.playingPiece));
            players.addLast(playerTurn);

            // Check for a winner
            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.playingPiece.pieceType);
            if (winner) {
                return playerTurn.name;
            }
        }

        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // check in row
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        // check in column
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        // check diagonals
        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        // check anti-diagonals
        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    // Method to undo the last move
    public void undoLastMove() {
        if (!moveHistory.isEmpty()) {
            Move lastMove = moveHistory.pop();
            gameBoard.board[lastMove.row][lastMove.column] = null;
            System.out.println("Last move undone.");
        }
    }

}
