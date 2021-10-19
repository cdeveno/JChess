package com.christiandevenish.game;

import com.christiandevenish.board.BoardUtils;
import com.christiandevenish.board.Tile;
import com.christiandevenish.pieces.Piece;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Move {

    private final Piece piece;
    private final Tile newTile;

    public enum MoveType {
        NORMAL,
        EN_PASSANT,
        ATTACK,
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
        gc.fillOval(BoardUtils.calculateXCoord(newTile.getColumn()) + (BoardUtils.getTileSize() / 2.0), BoardUtils.calculateYCoord(newTile.getRow()) + (BoardUtils.getTileSize() / 2.0), 20.0, 20.0);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Move)) {
            return false;
        }

        return ((Move) obj).getNewTile().equals(this.newTile) && ((Move) obj).getPiece().equals(this.piece);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 56;
    }
}
