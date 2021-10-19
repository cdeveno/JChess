package com.christiandevenish.game;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.Tile;
import com.christiandevenish.pieces.*;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Player {

    private final PlayerColor playerColor;

    private final Board board;
    private final ArrayList<Piece> pieces;

    public Player(PlayerColor playerColor, Board board) {

        this.playerColor = playerColor;
        this.board = board;

        pieces = createInitialPieces();
    }

    private ArrayList<Piece> createInitialPieces() {
        ArrayList<Piece> pieces = new ArrayList<>();
        if (playerColor == PlayerColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                pieces.add(new Pawn(board.getTile((char) ('a' + i), 2), board, playerColor));
            }
            pieces.add(new Rook(board.getTile('a', 1), board, playerColor));
            pieces.add(new Knight(board.getTile('b', 1), board, playerColor));
            pieces.add(new Bishop(board.getTile('c', 1), board, playerColor));
            pieces.add(new Queen(board.getTile('d', 1), board, playerColor));
            pieces.add(new King(board.getTile('e', 1), board, playerColor));
            pieces.add(new Bishop(board.getTile('f', 1), board, playerColor));
            pieces.add(new Knight(board.getTile('g', 1), board, playerColor));
            pieces.add(new Rook(board.getTile('h', 1), board, playerColor));
        } else {
            for (int i = 0; i < 8; i++) {
                pieces.add(new Pawn(board.getTile((char) ('a' + i),7), board, playerColor));
            }
            pieces.add(new Rook(board.getTile('a', 8), board, playerColor));
            pieces.add(new Knight(board.getTile('b', 8), board, playerColor));
            pieces.add(new Bishop(board.getTile('c', 8), board, playerColor));
            pieces.add(new Queen(board.getTile('d', 8), board, playerColor));
            pieces.add(new King(board.getTile('e', 8), board, playerColor));
            pieces.add(new Bishop(board.getTile('f', 8), board, playerColor));
            pieces.add(new Knight(board.getTile('g', 8), board, playerColor));
            pieces.add(new Rook(board.getTile('h', 8), board, playerColor));
        }
        return pieces;
    }

    public void renderPieces(GraphicsContext gc) {
        for (Piece piece : pieces) {
            piece.render(gc);
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void makeMove(Piece piece, Tile newTile) {

    }
}
