package com.christiandevenish.board;

import com.christiandevenish.pieces.Piece;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Tile {

    private Color color;
    private final char column;
    private final int row;
    private final int x, y;
    private final int size;
    private Piece piece = null;

    public Tile(char column, int row, int size) {

        this.size = size;
        this.column = column;
        this.row = row;

        x = BoardUtils.calculateXCoord(column);
        y = BoardUtils.calculateYCoord(row);
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return column + "" + row;
    }

    public void paintTile(GraphicsContext gc, Color color) {
        this.color = color;
        gc.setFill(color);
        gc.fillRect(x, y, size, size);
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 12));
        gc.fillText(this.toString(), x, y + 10);
    }

    public void paintTile(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, size, size);
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 12));
        gc.fillText(this.toString(), x, y + 10);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
