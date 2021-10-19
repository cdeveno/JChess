package com.christiandevenish.input;

import com.christiandevenish.board.Board;
import com.christiandevenish.board.BoardUtils;
import com.christiandevenish.board.Tile;
import com.christiandevenish.game.Game;
import com.christiandevenish.game.Move;
import com.christiandevenish.pieces.Pawn;
import com.christiandevenish.pieces.Piece;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Mouse implements EventHandler<MouseEvent> {

    private final Board board;

    private Piece selectedPiece = null;

    public Mouse(Board board) {
        this.board = board;
    }

    //TODO restrict making moves to player turn
    @Override
    public void handle(MouseEvent mouseEvent) {
        Tile selectedTile = board.getTile(BoardUtils.xCoordToColumn(mouseEvent.getX()), BoardUtils.yCoordToRow(mouseEvent.getY()));
        if (selectedTile.getPiece() != null && selectedPiece == null && selectedTile.getPiece().getPlayerColor() == board.getPlayerTurn()) {
            selectedPiece = selectedTile.getPiece();
            selectedPiece.renderWithMoves(board.getGc());
        } else if (selectedPiece != null) {
            if (selectedPiece.getLegalMoves().contains(new Move(selectedPiece, selectedTile))) {
                if (selectedPiece.getLegalMoves().get(selectedPiece.getLegalMoves().indexOf(new Move(selectedPiece, selectedTile))).getMoveType() == Move.MoveType.EN_PASSANT) {
                    selectedPiece.undisplayMoves(board.getGc());
                    ((Pawn) selectedPiece).makeEnPassantMove(selectedTile);
                    selectedPiece = null;
                } else {
                    selectedPiece.undisplayMoves(board.getGc());
                    selectedPiece.makeMove(selectedTile);
                    selectedPiece = null;
                }
            } else if (selectedTile.getPiece() != null && selectedTile.getPiece().getPlayerColor() == board.getPlayerTurn()) {
                selectedPiece.undisplayMoves(board.getGc());
                selectedPiece = selectedTile.getPiece();
                selectedPiece.renderWithMoves(board.getGc());
            }
        }
    }


}
