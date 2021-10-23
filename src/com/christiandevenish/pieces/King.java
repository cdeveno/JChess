package com.christiandevenish.pieces;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Game;
import com.christiandevenish.game.Move;
import com.christiandevenish.game.PlayerColor;

import java.util.ArrayList;

public class King extends Piece {

    public King(Tile tile, Board board, PlayerColor playerColor, Game game) {
        super(tile, board, playerColor, game);
    }

    @Override
    public void calculateLegalMoves() {
        ArrayList<Move> moves = new ArrayList<>();

        if (tile.getRow() + 1 <= 8) {
            if (board.getTile(tile.getColumn(), tile.getRow() + 1).getPiece() == null) {
                moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() + 1), Move.MoveType.NORMAL));
            } else if (board.getTile(tile.getColumn(), tile.getRow() + 1).getPiece().getPlayerColor() != getPlayerColor()) {
                moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() + 1), Move.MoveType.ATTACK));
            }
        }
        if (tile.getRow() - 1 >= 1) {
            if (board.getTile(tile.getColumn(), tile.getRow() - 1).getPiece() == null) {
                moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() - 1), Move.MoveType.NORMAL));
            } else if (board.getTile(tile.getColumn(), tile.getRow() - 1).getPiece().getPlayerColor() != getPlayerColor()) {
                moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() - 1), Move.MoveType.ATTACK));
            }
        }

        if (tile.getColumn() + 1 <= 'h') {
            if (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece() == null) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow()), Move.MoveType.NORMAL));
            } else if (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece().getPlayerColor() != getPlayerColor()) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow()), Move.MoveType.ATTACK));
            }
            if (tile.getRow() + 1 <= 8) {
                if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1), Move.MoveType.NORMAL));
                } else if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1).getPiece().getPlayerColor() != getPlayerColor()) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1), Move.MoveType.ATTACK));
                }
            }
            if (tile.getRow() - 1 >= 1) {
                if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1), Move.MoveType.NORMAL));
                } else if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1).getPiece().getPlayerColor() != getPlayerColor()) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1), Move.MoveType.ATTACK));
                }
            }
        }
        if (tile.getColumn() - 1 >= 'a') {
            if (board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece() == null) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow()), Move.MoveType.NORMAL));
            } else if (board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece().getPlayerColor() != getPlayerColor()) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow()), Move.MoveType.ATTACK));
            }
            if (tile.getRow() + 1 <= 8) {
                if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1), Move.MoveType.NORMAL));
                } else if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1).getPiece().getPlayerColor() != getPlayerColor()) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1), Move.MoveType.ATTACK));
                }
            }
            if (tile.getRow() - 1 >= 1) {
                if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1), Move.MoveType.NORMAL));
                } else if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1).getPiece().getPlayerColor() != getPlayerColor()) {
                    moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1), Move.MoveType.ATTACK));
                }
            }
        }

        this.legalMoves = moves;
    }

    @Override
    public String toString() {
        return "K";
    }
}
