package org.example.LLDTicTacToe_Concept_And_Coding.Model;


// Move class to store the details of each move
public class Move {
    public int row;
    public int column;
    PlayingPiece playingPiece;

    public Move(int row, int column, PlayingPiece playingPiece) {
        this.row = row;
        this.column = column;
        this.playingPiece = playingPiece;
    }
}