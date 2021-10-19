package com.christiandevenish.pieces;

import com.christiandevenish.board.BoardUtils;
import javafx.scene.image.Image;

public final class SpriteSheet {
    
    private static final String BISHOP_WHITE_PATH = "pieceImages/bishop_white.png";
    private static final String KING_WHITE_PATH = "pieceImages/king_white.png";
    private static final String KNIGHT_WHITE_PATH = "pieceImages/knight_white.png";
    private static final String PAWN_WHITE_PATH = "pieceImages/pawn_white.png";
    private static final String QUEEN_WHITE_PATH = "pieceImages/queen_white.png";
    private static final String ROOK_WHITE_PATH = "pieceImages/rook_white.png";

    private static final String BISHOP_BLACK_PATH = "pieceImages/bishop_black.png";
    private static final String KING_BLACK_PATH = "pieceImages/king_black.png";
    private static final String KNIGHT_BLACK_PATH = "pieceImages/knight_black.png";
    private static final String PAWN_BLACK_PATH = "pieceImages/pawn_black.png";
    private static final String QUEEN_BLACK_PATH = "pieceImages/queen_black.png";
    private static final String ROOK_BLACK_PATH = "pieceImages/rook_black.png";

    public static Image getBishopWhiteImage() {
        return new Image(BISHOP_WHITE_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getBishopBlackImage() {
        return new Image(BISHOP_BLACK_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getKingWhiteImage() {
        return new Image(KING_WHITE_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getKingBlackImage() {
        return new Image(KING_BLACK_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getKnightWhiteImage() {
        return new Image(KNIGHT_WHITE_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getKnightBlackImage() {
        return new Image(KNIGHT_BLACK_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getPawnWhiteImage() {
        return new Image(PAWN_WHITE_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getPawnBlackImage() {
        return new Image(PAWN_BLACK_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getQueenWhiteImage() {
        return new Image(QUEEN_WHITE_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getQueenBlackImage() {
        return new Image(QUEEN_BLACK_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getRookWhiteImage() {
        return new Image(ROOK_WHITE_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }

    public static Image getRookBlackImage() {
        return new Image(ROOK_BLACK_PATH, BoardUtils.getTileSize(), BoardUtils.getTileSize(), true, true);
    }
}
