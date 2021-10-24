package com.christiandevenish.pieces;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Game;
import com.christiandevenish.game.Move;
import com.christiandevenish.game.PlayerColor;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Tile tile, Board board, PlayerColor playerColor, Game game) {
        super(tile, board, playerColor, game);
    }

    @Override
    public ArrayList<Move> calculatePseudoLegalMoves() {
        ArrayList<Move> moves = new ArrayList<>();
        
        for (int i = 1; tile.getRow() + i <= 8 && tile.getColumn() + i <= 'h'; i++) {
            if (board.getTile((char) (tile.getColumn() + i), tile.getRow() + i).getPiece() == null) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() + i), tile.getRow() + i), Move.MoveType.NORMAL));
                continue;
            } else if (board.getTile((char) (tile.getColumn() + i), tile.getRow() + i).getPiece().getPlayerColor() != getPlayerColor()) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() + i), tile.getRow() + i), Move.MoveType.ATTACK));
                break;
            }
            break;
        }

        for (int i = 1; tile.getRow() + i <= 8 && tile.getColumn() - i >= 'a'; i++) {
            if (board.getTile((char) (tile.getColumn() - i), tile.getRow() + i).getPiece() == null) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() - i), tile.getRow() + i), Move.MoveType.NORMAL));
                continue;
            } else if (board.getTile((char) (tile.getColumn() - i), tile.getRow() + i).getPiece().getPlayerColor() != getPlayerColor()) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() - i), tile.getRow() + i), Move.MoveType.ATTACK));
                break;
            }
            break;
        }

        for (int i = 1; tile.getRow() - i >= 1 && tile.getColumn() + i <= 'h'; i++) {
            if (board.getTile((char) (tile.getColumn() + i), tile.getRow() - i).getPiece() == null) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() + i), tile.getRow() - i), Move.MoveType.NORMAL));
                continue;
            } else if (board.getTile((char) (tile.getColumn() + i), tile.getRow() - i).getPiece().getPlayerColor() != getPlayerColor()) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() + i), tile.getRow() - i), Move.MoveType.ATTACK));
                break;
            }
            break;
        }

        for (int i = 1; tile.getRow() - i >= 1 && tile.getColumn() - i >= 'a'; i++) {
            if (board.getTile((char) (tile.getColumn() - i), tile.getRow() - i).getPiece() == null) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() - i), tile.getRow() - i), Move.MoveType.NORMAL));
                continue;
            } else if (board.getTile((char) (tile.getColumn() - i), tile.getRow() - i).getPiece().getPlayerColor() != getPlayerColor()) {
                moves.add(new Move(this, board.getTile((char) (tile.getColumn() - i), tile.getRow() - i), Move.MoveType.ATTACK));
                break;
            }
            break;
        }
        
        return moves;
    }

    @Override
    public String toString() {
        return "B";
    }
}
