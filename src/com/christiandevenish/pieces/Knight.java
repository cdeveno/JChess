package com.christiandevenish.pieces;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Move;
import com.christiandevenish.game.PlayerColor;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Tile tile, Board board, PlayerColor playerColor) {
        super(tile, board, playerColor);
    }

    @Override
    public void calculateLegalMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        this.legalMoves = moves;
    }

    @Override
    public String toString() {
        return "N";
    }
}
