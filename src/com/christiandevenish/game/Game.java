package com.christiandevenish.game;

import com.christiandevenish.board.Board;
import com.christiandevenish.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board;

    private final Player whitePlayer;
    private final Player blackPlayer;

    private final List<Move> moveList;

    public Game(Board board) {

        this.board = board;

        whitePlayer = new Player(PlayerColor.WHITE, board, this);
        blackPlayer = new Player(PlayerColor.BLACK, board, this);

        whitePlayer.renderPieces(board.getGc());
        blackPlayer.renderPieces(board.getGc());

        for (Piece piece : whitePlayer.getPieces()) {
            piece.calculateLegalMoves();
        }
        for (Piece piece : blackPlayer.getPieces()) {
            piece.calculateLegalMoves();
        }

        moveList = new ArrayList<>();
    }

    public void recalculateLegalMoves() {
        for (Piece piece : whitePlayer.getPieces()) {
            piece.calculateLegalMoves();
        }
        for (Piece piece : blackPlayer.getPieces()) {
            piece.calculateLegalMoves();
        }
    }

    public void addMove(Move move) {
        moveList.add(move);
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public Player getOpposingPlayer(PlayerColor color) {
        return color == PlayerColor.WHITE ? blackPlayer : whitePlayer;
    }
}
