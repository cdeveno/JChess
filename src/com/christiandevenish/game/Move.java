package com.christiandevenish.game;

import com.christiandevenish.board.BoardUtils;
import com.christiandevenish.board.Tile;
import com.christiandevenish.pieces.Piece;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Move {

    private final Piece piece;
    private final Tile newTile;
    private MoveType moveType;

    public enum MoveType {
        NORMAL,
        EN_PASSANT,
        ATTACK,
        PAWN_DOUBLE_MOVE,
        CASTLE_KINGSIDE,
        CASTLE_QUEENSIDE
    }

    public Move(Piece piece, Tile newTile, MoveType moveType) {
        this.piece = piece;
        this.newTile = newTile;
        this.moveType = moveType;
    }

    public Move(Piece piece, Tile newTile) {
        this.piece = piece;
        this.newTile = newTile;
    }

    public Tile getNewTile() {
        return newTile;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return piece + "" + newTile;
    }

    public void render(GraphicsContext gc) {
        gc.setFill(Color.FUCHSIA);
        gc.fillOval(BoardUtils.calculateXCoord(newTile.getColumn()) + (BoardUtils.getTileSize() / 2.0) - 10, BoardUtils.calculateYCoord(newTile.getRow()) + (BoardUtils.getTileSize() / 2.0) - 10, 20.0, 20.0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Move)) {
            return false;
        }

        return ((Move) obj).getNewTile().equals(this.newTile) && ((Move) obj).getPiece().equals(this.piece);
    }

    public boolean equals(Piece piece, Tile newTile) {
        return this.getPiece() == piece && this.getNewTile() == newTile;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 56;
    }

    public MoveType getMoveType() {
        return moveType;
    }
}
