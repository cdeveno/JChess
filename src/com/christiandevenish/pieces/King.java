package com.christiandevenish.pieces;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.BoardUtils;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Game;
import com.christiandevenish.game.Move;
import com.christiandevenish.game.PlayerColor;

import java.util.ArrayList;

public class King extends Piece {

    private boolean firstMove = true;
    private boolean inCheck = false;

    public King(Tile tile, Board board, PlayerColor playerColor, Game game) {
        super(tile, board, playerColor, game);
    }

    @Override
    public ArrayList<Move> calculatePseudoLegalMoves() {
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

        if (firstMove) {
            moves.addAll(calculateCastling());
        }

        return moves;
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public void makeMove(Tile newTile) {
        if (firstMove) {
            firstMove = false;
        }
        super.makeMove(newTile);
    }

    private ArrayList<Move> calculateCastling() {
        ArrayList<Move> moves = new ArrayList<>();

        if (board.getTile('h', tile.getRow()).getPiece() != null) {
            Piece rook = board.getTile('h', tile.getRow()).getPiece();
            if (rook instanceof Rook) {
                if (((Rook) rook).isFirstMove()) {
                    boolean castleClear = true;
                    if (board.getTile((char) (tile.getColumn() + 1), tile.getRow()).getPiece() == null &&
                            board.getTile((char) (tile.getColumn() + 2), tile.getRow()).getPiece() == null) {
                        for (Piece piece : game.getOpposingPlayer(getPlayerColor()).getPieces()) {
                            if (piece.legalMoves.contains(new Move(piece, tile)) ||
                                    piece.legalMoves.contains(new Move(piece, board.getTile((char) (tile.getColumn() + 1), tile.getRow()))) ||
                                    piece.legalMoves.contains(new Move(piece, board.getTile((char) (tile.getColumn() + 2), tile.getRow())))) {
                                castleClear = false;
                                break;
                            }
                        }
                        if (castleClear) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() + 2), tile.getRow()), Move.MoveType.CASTLE_KINGSIDE));
                        }
                    }
                }
            }
        }
        if (board.getTile('a', tile.getRow()).getPiece() != null) {
            Piece rook = board.getTile('a', tile.getRow()).getPiece();
            if (rook instanceof Rook) {
                if (((Rook) rook).isFirstMove()) {
                    boolean castleClear = true;
                    if (board.getTile((char) (tile.getColumn() - 1), tile.getRow()).getPiece() == null &&
                            board.getTile((char) (tile.getColumn() - 2), tile.getRow()).getPiece() == null &&
                            board.getTile((char) (tile.getColumn() - 3), tile.getRow()).getPiece() == null) {
                        for (Piece piece : game.getOpposingPlayer(getPlayerColor()).getPieces()) {
                            if (piece.legalMoves.contains(new Move(piece, tile)) ||
                                    piece.legalMoves.contains(new Move(piece, board.getTile((char) (tile.getColumn() - 1), tile.getRow()))) ||
                                    piece.legalMoves.contains(new Move(piece, board.getTile((char) (tile.getColumn() - 2), tile.getRow())))) {
                                castleClear = false;
                                break;
                            }
                        }
                        if (castleClear) {
                            moves.add(new Move(this, board.getTile((char) (tile.getColumn() - 2), tile.getRow()), Move.MoveType.CASTLE_QUEENSIDE));
                        }
                    }
                }
            }
        }

        return moves;
    }

    public void castleKingSide() {
        Rook rook = (Rook) board.getTile('h', tile.getRow()).getPiece();

        board.getGc().clearRect(BoardUtils.calculateXCoord(tile.getColumn()), BoardUtils.calculateYCoord(tile.getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
        tile.paintTile(board.getGc());
        tile.setPiece(null);
        setPosition(board.getTile((char) (tile.getColumn() + 2), tile.getRow()));
        tile.setPiece(this);
        render(board.getGc());
        firstMove = false;

        board.getGc().clearRect(BoardUtils.calculateXCoord(rook.getTile().getColumn()), BoardUtils.calculateYCoord(tile.getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
        rook.getTile().paintTile(board.getGc());
        rook.getTile().setPiece(null);
        rook.setPosition(board.getTile((char) (rook.getTile().getColumn() - 2), tile.getRow()));
        rook.getTile().setPiece(rook);
        rook.render(board.getGc());
        rook.setFirstMove(false);

        game.addMove(getLegalMoves().get(getLegalMoves().indexOf(new Move(this, tile))));
        game.recalculateLegalMoves();
        board.switchPlayerTurn();
    }

    public void castleQueenSide() {
        Rook rook = (Rook) board.getTile('a', tile.getRow()).getPiece();

        board.getGc().clearRect(BoardUtils.calculateXCoord(tile.getColumn()), BoardUtils.calculateYCoord(tile.getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
        tile.paintTile(board.getGc());
        tile.setPiece(null);
        setPosition(board.getTile((char) (tile.getColumn() - 2), tile.getRow()));
        tile.setPiece(this);
        render(board.getGc());
        firstMove = false;

        board.getGc().clearRect(BoardUtils.calculateXCoord(rook.getTile().getColumn()), BoardUtils.calculateYCoord(tile.getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
        rook.getTile().paintTile(board.getGc());
        rook.getTile().setPiece(null);
        rook.setPosition(board.getTile((char) (rook.getTile().getColumn() + 3), tile.getRow()));
        rook.getTile().setPiece(rook);
        rook.render(board.getGc());
        rook.setFirstMove(false);

        game.addMove(getLegalMoves().get(getLegalMoves().indexOf(new Move(this, tile))));
        game.recalculateLegalMoves();
        board.switchPlayerTurn();
    }

    public boolean isInCheck() {
        return inCheck;
    }

    public void setInCheck(boolean inCheck) {
        this.inCheck = inCheck;
    }
}
