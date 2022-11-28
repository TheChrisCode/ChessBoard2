package com.example.chessboard2;

import javafx.scene.Group;
import javafx.scene.control.Cell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import static com.example.chessboard2.ChessBoard.gridPane;

import static com.example.chessboard2.ChessBoard.isWhiteTurn;
import static com.example.chessboard2.ChessPieceImages.whitePawnImage;


public class Pawn extends ImageView {
    boolean whitePawn = false;
    boolean blackPawn = false;
    boolean pawnMovedBoolean = false;
    public static CellGroup enpassantSquare = null;
    public static int enpassantSquareIndex;
    public static CellGroup mouseEventSourceCell1;
    public static CellGroup mouseEventSourceCell2;


    public static boolean pawnRules(Pawn pawnForPawnRules, CellGroup mouseEventSourceForPawnRules, int pawnColumnIndex, int pawnRowIndex, CellGroup pawnOrigin){
        int cellRowIndex = GridPane.getRowIndex(mouseEventSourceForPawnRules);
        int cellColumnIndex = GridPane.getColumnIndex(mouseEventSourceForPawnRules);




        int mouseEventSourceForPawnRulesIndex = gridPane.getChildren().indexOf(mouseEventSourceForPawnRules);
        mouseEventSourceCell1 = (CellGroup) gridPane.getChildren().get(gridPane.getChildren().indexOf(mouseEventSourceForPawnRules) + 1);
        mouseEventSourceCell2 = (CellGroup) gridPane.getChildren().get(gridPane.getChildren().indexOf(mouseEventSourceForPawnRules) - 1);
        int indexOfPawnOrigin = gridPane.getChildren().indexOf(pawnOrigin);
        if (pawnForPawnRules.blackPawn == true && isWhiteTurn == false) {

            enpassantSquareIndex = gridPane.getChildren().indexOf(mouseEventSourceForPawnRules) - 8;
            System.out.println(enpassantSquareIndex);
            enpassantSquare = (CellGroup) gridPane.getChildren().get(enpassantSquareIndex);
            System.out.println(enpassantSquare.canEnpassant);
            if(enpassantSquare.canEnpassant == true && enpassantSquare.getChildren().size() > 2) {
                System.out.println(enpassantSquareIndex);
                enpassantSquare.whitePiece = false;
                enpassantSquare.hasPiece = false;
                enpassantSquare.getChildren().remove(2);
                isWhiteTurn = true;
                return true;
            }

            CellGroup attackAbleSquare1 = (CellGroup) gridPane.getChildren().get(indexOfPawnOrigin + 7);
            CellGroup attackAbleSquare2 = (CellGroup) gridPane.getChildren().get(indexOfPawnOrigin + 9);
            if (attackAbleSquare1 == mouseEventSourceForPawnRules || attackAbleSquare2 == mouseEventSourceForPawnRules) {
                if (attackAbleSquare1.whitePiece == true || attackAbleSquare2.whitePiece == true) {

                    mouseEventSourceForPawnRules.getChildren().remove(2);
                    mouseEventSourceForPawnRules.canEnpassant = false;
                    isWhiteTurn = true;
                    return true;
                }
            }
        }
        if (pawnForPawnRules.whitePawn == true && isWhiteTurn == true) {

            int enpassantSquareIndex = gridPane.getChildren().indexOf(mouseEventSourceForPawnRules) + 8;
            enpassantSquare = (CellGroup) gridPane.getChildren().get(enpassantSquareIndex);
            if(enpassantSquare.canEnpassant == true && enpassantSquare.getChildren().size() > 2) {
                System.out.println("checkpoint 1");
                enpassantSquare.getChildren().remove(2);
                enpassantSquare.blackPiece = false;
                enpassantSquare.hasPiece = false;
                isWhiteTurn = false;
                return true;
            }
            CellGroup attackAbleSquare1 = (CellGroup) gridPane.getChildren().get(indexOfPawnOrigin - 7);
            CellGroup attackAbleSquare2 = (CellGroup) gridPane.getChildren().get(indexOfPawnOrigin - 9);
            if (attackAbleSquare1 == mouseEventSourceForPawnRules || attackAbleSquare2 == mouseEventSourceForPawnRules) {
                if (attackAbleSquare1.blackPiece == true || attackAbleSquare2.blackPiece == true) {
                    mouseEventSourceForPawnRules.getChildren().remove(2);
                    mouseEventSourceForPawnRules.canEnpassant = false;
                    isWhiteTurn = false;
                    return true;
                }
            }
        }

        if (mouseEventSourceForPawnRules.hasPiece == false) {

            if (pawnForPawnRules.blackPawn == true && isWhiteTurn == false) {

                if (pawnForPawnRules.pawnMovedBoolean == false) {
                    if (pawnColumnIndex == cellColumnIndex && (cellRowIndex - pawnRowIndex) > 0 && (cellRowIndex - pawnRowIndex) <= 2) {
                        if((cellRowIndex - pawnRowIndex) == 2 && (mouseEventSourceCell1.whitePiece == true || mouseEventSourceCell2.whitePiece == true)) {
                            System.out.println("checkpoint 2");
                            mouseEventSourceForPawnRules.canEnpassant = true;
                        }
                        CellGroup betweenCellGroupBlack = (CellGroup) gridPane.getChildren().get(gridPane.getChildren().indexOf(mouseEventSourceForPawnRules) - 8);
                        if (gridPane.getChildren().indexOf(mouseEventSourceForPawnRules) - 8 == gridPane.getChildren().indexOf(pawnOrigin)) {
                            betweenCellGroupBlack.hasPiece = false;
                        }
                        if (betweenCellGroupBlack.hasPiece == false) {
                            pawnForPawnRules.pawnMovedBoolean = true;
                            isWhiteTurn = true;
                            return true;
                        }
                    }
                    return false;
                } else if (pawnForPawnRules.pawnMovedBoolean == true) {
                    if (pawnColumnIndex == cellColumnIndex && (cellRowIndex - pawnRowIndex) > 0 && (cellRowIndex - pawnRowIndex) <= 1) {
                        mouseEventSourceForPawnRules.canEnpassant = false;
                        isWhiteTurn = true;
                        return true;
                    }
                    return false;
                }

            } else if (pawnForPawnRules.whitePawn == true && isWhiteTurn == true) {

                if (pawnForPawnRules.pawnMovedBoolean == false) {

                    if (pawnColumnIndex == cellColumnIndex && (pawnRowIndex - cellRowIndex) > 0 && (pawnRowIndex - cellRowIndex) <= 2) {
                        if((pawnRowIndex - cellRowIndex) == 2 && (mouseEventSourceCell1.blackPiece == true || mouseEventSourceCell2.blackPiece == true)) {
                            System.out.println("checkpoint 2");
                            mouseEventSourceForPawnRules.canEnpassant = true;
                        }

                        CellGroup betweenCellGroupWhite = (CellGroup) gridPane.getChildren().get(gridPane.getChildren().indexOf(mouseEventSourceForPawnRules) + 8);
                        if(gridPane.getChildren().indexOf(mouseEventSourceForPawnRules) + 8 == gridPane.getChildren().indexOf(pawnOrigin)) {
                            betweenCellGroupWhite.hasPiece = false;
                        }
                        if(betweenCellGroupWhite.hasPiece == false) {
                            pawnForPawnRules.pawnMovedBoolean = true;
                            isWhiteTurn = false;
                            return true;
                        }
                    }
                    return false;
                } else if (pawnForPawnRules.pawnMovedBoolean == true) {
                    if (pawnColumnIndex == cellColumnIndex && (pawnRowIndex - cellRowIndex) > 0 && (pawnRowIndex - cellRowIndex) <= 1) {
                        mouseEventSourceForPawnRules.canEnpassant = false;
                        isWhiteTurn = false;
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }


}
