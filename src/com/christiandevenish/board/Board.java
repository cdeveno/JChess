package com.christiandevenish.board;

import com.christiandevenish.game.PlayerColor;
import com.christiandevenish.input.Mouse;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Board {

    private final Canvas canvas;
    private final GraphicsContext gc;
    private final int boardLength;
    private final Tile[][] board;

    private PlayerColor playerTurn = PlayerColor.WHITE;

    public Board(Group root, int boardLength) {
        this.boardLength = boardLength;

        canvas = new Canvas(boardLength, boardLength);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new Mouse(this));
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        board = new Tile[8][8];
        createBoard();
    }

    private void createBoard() {
        Color tileColor = Color.CHOCOLATE;
        for (int i = 0; i < 8; i++) {
            for (int j = 7; j >= 0; j--) {
                tileColor = (tileColor == Color.CHOCOLATE) ? Color.NAVAJOWHITE : Color.CHOCOLATE;
                board[i][j] = new Tile((char) (i + 'a'), j + 1, boardLength / 8);
                board[i][j].paintTile(gc, tileColor);
            }
            tileColor = (tileColor == Color.CHOCOLATE) ? Color.NAVAJOWHITE : Color.CHOCOLATE;
        }
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Tile getTile(char column, int row) {
        return board[column - 'a'][row - 1];
    }

    public PlayerColor getPlayerTurn() {
        return playerTurn;
    }

    public void switchPlayerTurn() {
        if (playerTurn == PlayerColor.WHITE) {
            playerTurn = PlayerColor.BLACK;
        } else {
            playerTurn = PlayerColor.WHITE;
        }
    }

    public Tile[][] getBoard() {
        return board;
    }
}
