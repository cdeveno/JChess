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
        ArrayList<Move> moves = new ArrayList<>();

        for (int i = 1; tile.getRow() + i <= 8; i++) {
            if (board.getTile(tile.getColumn(), tile.getRow() + i).getPiece() == null) {
                moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() + i), Move.MoveType.NORMAL));
            } else {
                if (board.getTile(tile.getColumn(), tile.getRow() + i).getPiece().getPlayerColor() != getPlayerColor()) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() + i), Move.MoveType.ATTACK));
                }
                break;
            }
        }
        for (int i = 1; tile.getRow() - i >= 1; i++) {
            if (board.getTile(tile.getColumn(), tile.getRow() - i).getPiece() == null) {
                moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() - i), Move.MoveType.NORMAL));
            } else {
                if (board.getTile(tile.getColumn(), tile.getRow() - i).getPiece().getPlayerColor() != getPlayerColor()) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() - i), Move.MoveType.ATTACK));
                }
                break;
            }
        }
        for (int i = 1; tile.getColumn() + i <= 'h'; i++) {
            if (board.getTile((char) (tile.getColumn() + i), tile.getRow()).getPiece() == null) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() + i), tile.getRow()), Move.MoveType.NORMAL));
            } else {
                if (board.getTile((char) (tile.getColumn() + i), tile.getRow()).getPiece().getPlayerColor() != getPlayerColor()) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() + i), tile.getRow()), Move.MoveType.ATTACK));
                }
                break;
            }
        }
        for (int i = 1; tile.getColumn() - i >= 'a'; i++) {
            if (board.getTile((char) (tile.getColumn() - i), tile.getRow()).getPiece() == null) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() - i), tile.getRow()), Move.MoveType.NORMAL));
            } else {
                if (board.getTile((char) (tile.getColumn() - i), tile.getRow()).getPiece().getPlayerColor() != getPlayerColor()) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() - i), tile.getRow()), Move.MoveType.ATTACK));
                }
                break;
            }
        }
        this.legalMoves = moves;
    }

    @Override
    public String toString() {
        return "R";
    }
}
