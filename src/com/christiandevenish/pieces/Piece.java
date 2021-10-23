package com.christiandevenish.pieces;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.BoardUtils;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Game;
import com.christiandevenish.game.Move;
import com.christiandevenish.game.PlayerColor;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class Piece {

    protected final Board board;
    protected Tile tile;
    protected PlayerColor playerColor;

    protected final Sprite sprite;

    protected Game game;
    protected ArrayList<Move> legalMoves;

    public Piece(Tile tile, Board board, PlayerColor playerColor, Game game) {
        this.tile = tile;
        this.board = board;
        this.playerColor = playerColor;
        this.game = game;

        if (playerColor == PlayerColor.WHITE) {
            if (this instanceof Bishop) {
                sprite = new Sprite(SpriteSheet.getBishopWhiteImage());
            } else if (this instanceof King) {
                sprite = new Sprite(SpriteSheet.getKingWhiteImage());
            } else if (this instanceof Knight) {
                sprite = new Sprite(SpriteSheet.getKnightWhiteImage());
            } else if (this instanceof Pawn) {
                sprite = new Sprite(SpriteSheet.getPawnWhiteImage());
            } else if (this instanceof Queen) {
                sprite = new Sprite(SpriteSheet.getQueenWhiteImage());
            } else {
                sprite = new Sprite(SpriteSheet.getRookWhiteImage());
            }
        } else {
            if (this instanceof Bishop) {
                sprite = new Sprite(SpriteSheet.getBishopBlackImage());
            } else if (this instanceof King) {
                sprite = new Sprite(SpriteSheet.getKingBlackImage());
            } else if (this instanceof Knight) {
                sprite = new Sprite(SpriteSheet.getKnightBlackImage());
            } else if (this instanceof Pawn) {
                sprite = new Sprite(SpriteSheet.getPawnBlackImage());
            } else if (this instanceof Queen) {
                sprite = new Sprite(SpriteSheet.getQueenBlackImage());
            } else {
                sprite = new Sprite(SpriteSheet.getRookBlackImage());
            }
        }
        tile.setPiece(this);
    }

    public abstract void calculateLegalMoves();

    public void setPosition(Tile tile) {
        this.tile = tile;
    }

    public void render(GraphicsContext gc) {
        sprite.render(gc, BoardUtils.calculateXCoord(tile.getColumn()), BoardUtils.calculateYCoord(tile.getRow()));
    }

    public void renderWithMoves(GraphicsContext gc) {
        sprite.render(gc, BoardUtils.calculateXCoord(tile.getColumn()), BoardUtils.calculateYCoord(tile.getRow()));
        displayMoves(gc);
    }

    public ArrayList<Move> getLegalMoves() {
        return legalMoves;
    }

    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    private void displayMoves(GraphicsContext gc) {
        for (Move move : legalMoves) {
            move.render(gc);
        }
    }

    public void undisplayMoves(GraphicsContext gc) {
        for (Move move : legalMoves) {
            gc.clearRect(BoardUtils.calculateXCoord(move.getNewTile().getColumn()),
                    BoardUtils.calculateYCoord(move.getNewTile().getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
            move.getNewTile().paintTile(gc);
            if (move.getNewTile().getPiece() != null) {
                move.getNewTile().getPiece().render(gc);
            }
        }
    }

    public Tile getTile() {
        return tile;
    }

    public void makeMove(Tile newTile) {
        board.getGc().clearRect(BoardUtils.calculateXCoord(tile.getColumn()), BoardUtils.calculateYCoord(tile.getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
        tile.paintTile(board.getGc());
        tile.setPiece(null);
        board.getGc().clearRect(BoardUtils.calculateXCoord(newTile.getColumn()), BoardUtils.calculateYCoord(newTile.getRow()), BoardUtils.getTileSize(), BoardUtils.getTileSize());
        newTile.paintTile(board.getGc());
        newTile.setPiece(this);
        setPosition(newTile);
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