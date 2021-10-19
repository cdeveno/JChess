package com.christiandevenish.pieces;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.BoardUtils;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Game;
import com.christiandevenish.game.Move;
import com.christiandevenish.game.PlayerColor;

import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean firstMove = true;

    public Pawn(Tile tile, Board board, PlayerColor playerColor, Game game) {
        super(tile, board, playerColor, game);
    }

    @Override
    public void calculateLegalMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        if (playerColor == PlayerColor.WHITE) {
            if (firstMove) {
                if (board.getTile(tile.getColumn(), tile.getRow() + 2).getPiece() == null && board.getTile(tile.getColumn(), tile.getRow() + 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() + 2), Move.MoveType.PAWN_DOUBLE_MOVE));
                }
            }
            if (tile.getRow() != 8) { // Prevents IndexOutOfBounds
                if (board.getTile(tile.getColumn(), tile.getRow() + 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() + 1), Move.MoveType.NORMAL));
                }
                if (tile.getColumn() != 'h') {
                    if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1).getPiece() != null) {
                        if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1).getPiece().getPlayerColor() != PlayerColor.WHITE) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1), Move.MoveType.ATTACK));
                        }
                    }
                }
                if (tile.getColumn() != 'a') {
                    if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1).getPiece() != null) {
                        if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1).getPiece().getPlayerColor() != PlayerColor.WHITE) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1), Move.MoveType.ATTACK));
                        }
                    }
                }
                // en passant
                if (tile.getRow() == 5) {
                    if (tile.getColumn() != 'h') {
                        if (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece() != null && board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece() instanceof Pawn
                            && board.getTile((char) (tile.getColumn() + 1), tile.getRow() + 1).getPiece() == null) {
                            Pawn pawn = (Pawn) (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece());
                            if (game.getMoveList().get(game.getMoveList().size() - 1).getMoveType() == Move.MoveType.PAWN_DOUBLE_MOVE) {
                                moves.add(new Move(this, board.getTile(pawn.tile.getColumn(), tile.getRow() + 1), Move.MoveType.EN_PASSANT));
                            }
                        }
                    }
                    if (tile.getColumn() != 'a') {
                        if (board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece() != null && board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece() instanceof Pawn
                                && board.getTile((char) (tile.getColumn() - 1), tile.getRow() + 1).getPiece() == null) {
                            Pawn pawn = (Pawn) (board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece());
                            if (game.getMoveList().get(game.getMoveList().size() - 1).getMoveType() == Move.MoveType.PAWN_DOUBLE_MOVE) {
                                moves.add(new Move(this, board.getTile(pawn.tile.getColumn(), tile.getRow() + 1), Move.MoveType.EN_PASSANT));
                            }
                        }
                    }
                }
            }
        } else {
            if (firstMove) {
                if (board.getTile(tile.getColumn(), tile.getRow() - 2).getPiece() == null && board.getTile(tile.getColumn(), tile.getRow() - 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() - 2), Move.MoveType.PAWN_DOUBLE_MOVE));
                }
            }
            if (tile.getRow() != 0) { // Prevents IndexOutOfBounds
                if (board.getTile(tile.getColumn(), tile.getRow() - 1).getPiece() == null) {
                    moves.add(new Move(this, board.getTile(tile.getColumn(), tile.getRow() - 1), Move.MoveType.NORMAL));
                }
                if (tile.getColumn() != 'h') {
                    if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1).getPiece() != null) {
                        if (board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1).getPiece().getPlayerColor() != PlayerColor.BLACK) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1), Move.MoveType.ATTACK));
                        }
                    }
                }
                if (tile.getColumn() != 'a') {
                    if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1).getPiece() != null) {
                        if (board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1).getPiece().getPlayerColor() != PlayerColor.BLACK) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1), Move.MoveType.ATTACK));
                        }
                    }
                }
                // en passant
                if (tile.getRow() == 4) {
                    if (tile.getColumn() != 'h') {
                        if (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece() != null && board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece() instanceof Pawn
                                && board.getTile((char) (tile.getColumn() + 1), tile.getRow() - 1).getPiece() == null) {
                            Pawn pawn = (Pawn) (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece());
                            if (game.getMoveList().get(game.getMoveList().size() - 1).getMoveType() == Move.MoveType.PAWN_DOUBLE_MOVE) {
                                moves.add(new Move(this, board.getTile(pawn.tile.getColumn(), tile.getRow() - 1), Move.MoveType.EN_PASSANT));
                            }
                        }
                    }
                    if (tile.getColumn() != 'a') {
                        if (board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece() != null && board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece() instanceof Pawn
                                && board.getTile((char) (tile.getColumn() - 1), tile.getRow() - 1).getPiece() == null) {
                            Pawn pawn = (Pawn) (board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece());
                            if (game.getMoveList().get(game.getMoveList().size() - 1).getMoveType() == Move.MoveType.PAWN_DOUBLE_MOVE) {
                                moves.add(new Move(this, board.getTile(pawn.tile.getColumn(), tile.getRow() - 1), Move.MoveType.EN_PASSANT));
                            }
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

    public void makeEnPassantMove(Tile newTile) {
        board.getGc().clearRect(BoardUtils.calculateXCoord(tile.getColumn()), BoardUtils.calculateYCoord(tile.getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
        tile.paintTile(board.getGc());
        tile.setPiece(null);
        Tile deadPawnTile;
        if (playerColor == PlayerColor.WHITE) {
            deadPawnTile = board.getTile(newTile.getColumn(), newTile.getRow() - 1);
        } else {
            deadPawnTile = board.getTile(newTile.getColumn(), newTile.getRow() + 1);
        }
        board.getGc().clearRect(BoardUtils.calculateXCoord(deadPawnTile.getColumn()), BoardUtils.calculateYCoord(deadPawnTile.getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
        deadPawnTile.paintTile(board.getGc());
        deadPawnTile.setPiece(null);
        setPosition(newTile);
        newTile.setPiece(this);
        render(board.getGc());
        game.addMove(getLegalMoves().get(getLegalMoves().indexOf(new Move(this, newTile))));
        for (Tile[] row : board.getBoard()) {
            for (Tile tile : row) {
                if (tile.getPiece() != null) {
                    tile.getPiece().calculateLegalMoves();
                }
            }
        }
        board.switchPlayerTurn();
    }
}
