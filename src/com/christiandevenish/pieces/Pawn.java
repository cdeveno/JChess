package com.christiandevenish.pieces;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Move;
import com.christiandevenish.game.PlayerColor;

import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean firstMove = true;

    public Pawn(Tile tile, Board board, PlayerColor playerColor) {
        super(tile, board, playerColor);
    }

    @Override
    public void calculateLegalMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        if (playerColor == PlayerColor.WHITE) {
            if (firstMove) {
                if (board.getTile(tile.getColumn(), tile.getRow() + 2).getPiece() == null && board.getTile(tile.getColumn(), tile.getRow() + 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() + 2)));
                }
            }
            if (tile.getRow() != 8) { // Prevents IndexOutOfBounds
                if (board.getTile(tile.getColumn(), tile.getRow() + 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() + 1)));
                }
                if (tile.getColumn() != 'h') {
                    if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1).getPiece() != null) {
                        if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1).getPiece().getPlayerColor() != PlayerColor.WHITE) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1)));
                        }
                    }
                }
                if (tile.getColumn() != 'a') {
                    if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1).getPiece() != null) {
                        if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1).getPiece().getPlayerColor() != PlayerColor.WHITE) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1)));
                        }
                    }
                }
                // en passant
                if (tile.getRow() == 5) {
                    if (tile.getColumn() != 'h') {
                        if (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece() != null && board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece() instanceof Pawn) {
                            Pawn pawn = (Pawn) (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece());
                            if (pawn.isFirstMove()) {
                                moves.add(new Move(this, pawn.getTile()));
                            }
                        }
                    }
                }
            }
        } else {
            if (firstMove) {
                if (board.getTile(tile.getColumn(), tile.getRow() - 2).getPiece() == null && board.getTile(tile.getColumn(), tile.getRow() - 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() - 2)));
                }
            }
            if (tile.getRow() != 0) { // Prevents IndexOutOfBounds
                if (board.getTile(tile.getColumn(), tile.getRow() - 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() - 1)));
                }
                if (tile.getColumn() != 'h') {
                    if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1).getPiece() != null) {
                        if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1).getPiece().getPlayerColor() != PlayerColor.BLACK) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1)));
                        }
                    }
                }
                if (tile.getColumn() != 'a') {
                    if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1).getPiece() != null) {
                        if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1).getPiece().getPlayerColor() != PlayerColor.BLACK) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1)));
                        }
                    }
                }
            }
        }
        this.legalMoves = moves;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public void makeMove(Tile newTile) {
        if (firstMove) {
            firstMove = false;
        }
        super.makeMove(newTile);
    }

    public boolean isFirstMove() {
        return firstMove;
    }
}
