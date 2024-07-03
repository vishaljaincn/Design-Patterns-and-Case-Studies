package org.example.tictactoe.strategies.winningstrategy;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
