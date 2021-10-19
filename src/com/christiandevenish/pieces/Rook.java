package com.christiandevenish.pieces;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Game;
import com.christiandevenish.game.Move;
import com.christiandevenish.game.PlayerColor;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Tile tile, Board board, PlayerColor playerColor, Game game) {
        super(tile, board, playerColor, game);
    }

    @Override
    public void calculateLegalMoves() {
        this.legalMoves = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "R";
    }
}
