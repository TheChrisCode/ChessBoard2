package com.example.chessboard2;

import javafx.scene.image.ImageView;

import static com.example.chessboard2.ChessBoard.isWhiteTurn;

public class King extends ImageView {
    boolean whiteKing = false;
    boolean blackKing = false;

    public static boolean kingRules(King kingForKingRules, CellGroup mouseEventSourceForKingRules) {
        if(kingForKingRules.whiteKing == true && isWhiteTurn == true) {
            if (mouseEventSourceForKingRules.hasPiece == false) {
                isWhiteTurn = false;
                return true;
            } else if (mouseEventSourceForKingRules.whitePiece == true) {
                return false;
            } else if (mouseEventSourceForKingRules.blackPiece == true) {
                mouseEventSourceForKingRules.getChildren().remove(2);
                isWhiteTurn = false;
                return true;
            }
        } else if(kingForKingRules.blackKing == true && isWhiteTurn == false) {
            if (mouseEventSourceForKingRules.hasPiece == false) {
                isWhiteTurn = true;
                return true;
            } else if (mouseEventSourceForKingRules.blackPiece == true) {
                return false;
            } else if (mouseEventSourceForKingRules.whitePiece == true) {
                mouseEventSourceForKingRules.getChildren().remove(2);
                isWhiteTurn = true;
                return true;
            }
        }
        return false;
    }
}
