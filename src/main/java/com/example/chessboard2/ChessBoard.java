package com.example.chessboard2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static com.example.chessboard2.ChessPieceImages.*;
import static com.example.chessboard2.King.kingRules;
import static com.example.chessboard2.Pawn.enpassantSquare;
import static com.example.chessboard2.Pawn.pawnRules;
import static com.example.chessboard2.Queen.calculateAttackSquares;


public class ChessBoard extends Application {
    public static GridPane gridPane = new GridPane();
    public static ImageView imageView;
    public static Rectangle rectangle;
    public static CellGroup cellGroup;
    public static CellGroup mouseEventSourceTempHolder;
    public static Pawn pawnForMouseEvent;
    public static King kingForMouseEvent;
    public static Queen queenForMouseEvent;

    public static int setPawnIdentityInt = 0;
    public static int setKingIdentityInt = 0;
    public static int setQueenIdentityInt = 0;
    public static boolean pawnActiveBoolean = false;
    public static boolean kingActiveBoolean = false;
    public static boolean queenActiveBoolean = false;
    public static boolean pawnMovedBoolean = false;
    public static boolean kingMovedBoolean = false;
    public static boolean queenMovedBoolean = false;
    public static boolean isWhiteTurn = true;





    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(gridPane, 512, 512);
        ChessPieceImages.PieceImages();
        makeGroupCell(63);
        enpassantSquare.canEnpassant = false;

        stage.setScene(scene);
        stage.show();


    }
    public static CellGroup makeGroupCell(int identity) {
        Pawn pawn;
        King king;
        Queen queen;
        int x = 0;
        boolean isWhite = true;
        while(identity >= 0) {
            imageView = new ImageView();
            rectangle = new Rectangle(64,64);
            cellGroup = new CellGroup();
            cellGroup.getChildren().addAll(rectangle, imageView);
            imageView.setFitHeight(64);
            imageView.setFitWidth(64);
            imageView.setPreserveRatio(false);

            cellGroup.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent mouseEvent) {

                    CellGroup mouseEventSource = (CellGroup) mouseEvent.getSource();

                    if(pawnActiveBoolean == true) {
                        int pawnRowIndex = GridPane.getRowIndex(mouseEventSourceTempHolder);
                        int pawnColumnIndex = GridPane.getColumnIndex(mouseEventSourceTempHolder);

                        if (pawnRules(pawnForMouseEvent, mouseEventSource, pawnColumnIndex, pawnRowIndex, mouseEventSourceTempHolder) == true) {
                            if(enpassantSquare.canEnpassant == true) {

                            }
                            mouseEventSource.getChildren().add(pawnForMouseEvent);
                            if(pawnForMouseEvent.whitePawn == true) {
                                mouseEventSource.whitePiece = true;
                                mouseEventSourceTempHolder.whitePiece = false;
                            } else if (pawnForMouseEvent.blackPawn == true) {
                                mouseEventSource.blackPiece = true;
                                mouseEventSourceTempHolder.blackPiece = false;
                            }
                            mouseEventSource.hasPiece = true;
                            mouseEventSourceTempHolder.hasPiece = false;
                            pawnMovedBoolean = true;
                        } else {
                            pawnMovedBoolean = false;
                            pawnActiveBoolean = false;
                            mouseEventSource = cellGroup;
                            mouseEventSourceTempHolder = cellGroup;
                        }
                    }
                    if(pawnMovedBoolean == true) {
                        pawnMovedBoolean = false;
                        pawnActiveBoolean = false;
                        mouseEventSource = cellGroup;
                        mouseEventSourceTempHolder = cellGroup;
                    }
                    if(kingActiveBoolean == true) {
                        if (kingRules(kingForMouseEvent, mouseEventSource) == true) {
                            mouseEventSource.getChildren().add(kingForMouseEvent);
                            if (kingForMouseEvent.whiteKing == true) {
                                mouseEventSource.whitePiece = true;
                                mouseEventSourceTempHolder.whitePiece = false;
                            } else if (kingForMouseEvent.blackKing == true) {
                                mouseEventSource.blackPiece = true;
                                mouseEventSourceTempHolder.blackPiece = false;
                            }
                            mouseEventSource.hasPiece = true;
                            mouseEventSourceTempHolder.hasPiece = false;
                            kingMovedBoolean = true;
                        } else {
                            kingMovedBoolean = false;
                            kingActiveBoolean = false;
                            mouseEventSource = cellGroup;
                            mouseEventSourceTempHolder = cellGroup;
                        }
                    }
                    if(kingMovedBoolean == true) {
                        kingMovedBoolean = false;
                        kingActiveBoolean = false;
                        mouseEventSource = cellGroup;
                        mouseEventSourceTempHolder = cellGroup;
                    }
                    if (queenActiveBoolean == true) {
                        int queenRowIndex = GridPane.getRowIndex(mouseEventSourceTempHolder);
                        int queenColumnIndex = GridPane.getColumnIndex(mouseEventSourceTempHolder);
                        int attackSquaresIndex[] = calculateAttackSquares(queenForMouseEvent, queenRowIndex, queenColumnIndex);
                        int queenCellIndex = gridPane.getChildren().indexOf(mouseEventSource);
                        System.out.println(attackSquaresIndex[0]);
                        for(int i = 0; i < 32; i++) {

                            if (queenCellIndex == attackSquaresIndex[i]) {
                                System.out.println(i + "This is i");
                                if ()
                                mouseEventSource.getChildren().add(queenForMouseEvent);
                                mouseEventSource.hasPiece = true;
                                mouseEventSourceTempHolder.hasPiece = false;
                                queenMovedBoolean = true;
                            }
                        }
                    }
                    if (queenMovedBoolean == true) {
                        queenMovedBoolean = false;
                        queenActiveBoolean = false;
                        mouseEventSource = cellGroup;
                        mouseEventSourceTempHolder = cellGroup;
                    }
                    if(mouseEventSource.getChildren().size() > 2 && pawnActiveBoolean == false) {
                        if (((ImageView) mouseEventSource.getChildren().get(2)).getImage() == whitePawnImage || ((ImageView) mouseEventSource.getChildren().get(2)).getImage() == blackPawnImage) {
                            mouseEventSourceTempHolder = mouseEventSource;
                            pawnForMouseEvent = (Pawn) mouseEventSource.getChildren().get(2);


                            pawnActiveBoolean = true;
                        }
                    }
                    if(mouseEventSource.getChildren().size() > 2 && kingActiveBoolean == false) {
                        if (((ImageView) mouseEventSource.getChildren().get(2)).getImage() == whiteKingImage || ((ImageView) mouseEventSource.getChildren().get(2)).getImage() == blackKingImage) {
                            mouseEventSourceTempHolder = mouseEventSource;
                            kingForMouseEvent = (King) mouseEventSource.getChildren().get(2);


                            kingActiveBoolean = true;
                        }
                    }
                    if(mouseEventSource.getChildren().size() > 2 && queenActiveBoolean == false) {
                        if (((ImageView) mouseEventSource.getChildren().get(2)).getImage() == whiteQueenImage || ((ImageView) mouseEventSource.getChildren().get(2)).getImage() == blackQueenImage) {
                            mouseEventSourceTempHolder = mouseEventSource;
                            queenForMouseEvent = (Queen) mouseEventSource.getChildren().get(2);


                            queenActiveBoolean = true;
                        }
                    }



                }
            });
            if (identity % 8 == 7) {
                if (isWhite == true) {
                    isWhite = false;
                } else {
                    isWhite = true;
                }

            }
            if (isWhite == true) {
                rectangle.setFill(Color.rgb(118, 150, 86));
                isWhite = false;
            } else {
                rectangle.setFill(Color.rgb(238, 238, 210));
                isWhite = true;
            }
            if (identity == 4) {
                queen = new Queen();
                queen.setId(String.valueOf(setQueenIdentityInt));
                setQueenIdentityInt++;
                queen.setFitHeight(64);
                queen.setFitWidth(64);
                queen.setPreserveRatio(false);
                queen.setImage(whiteQueenImage);
                queen.whiteQueen = true;
                cellGroup.getChildren().add(queen);
                cellGroup.whitePiece = true;
                cellGroup.hasPiece = true;
            }
            if (identity == 60) {
                queen = new Queen();
                queen.setId(String.valueOf(setQueenIdentityInt));
                setQueenIdentityInt++;
                queen.setFitHeight(64);
                queen.setFitWidth(64);
                queen.setPreserveRatio(false);
                queen.setImage(blackQueenImage);
                queen.blackQueen = true;
                cellGroup.getChildren().add(queen);
                cellGroup.blackPiece = true;
                cellGroup.hasPiece = true;
            }
            if (identity == 3) {
                king = new King();
                king.setId(String.valueOf(setKingIdentityInt));
                setKingIdentityInt++;
                king.setFitHeight(64);
                king.setFitWidth(64);
                king.setPreserveRatio(false);
                king.setImage(whiteKingImage);
                king.whiteKing = true;
                cellGroup.getChildren().add(king);
                cellGroup.whitePiece = true;
                cellGroup.hasPiece = true;
            }
            if (identity == 59) {
                king = new King();
                king.setId(String.valueOf(setKingIdentityInt));
                setKingIdentityInt++;
                king.setFitHeight(64);
                king.setFitWidth(64);
                king.setPreserveRatio(false);
                king.setImage(blackKingImage);
                king.blackKing = true;
                cellGroup.getChildren().add(king);
                cellGroup.blackPiece = true;
                cellGroup.hasPiece = true;
            }
            if (identity <= 15 && identity >= 8) {
                pawn = new Pawn();
                pawn.setId(String.valueOf(setPawnIdentityInt));
                setPawnIdentityInt++;
                pawn.setFitHeight(64);
                pawn.setFitWidth(64);
                pawn.setPreserveRatio(false);
                pawn.setImage(whitePawnImage);
                pawn.whitePawn = true;
                cellGroup.getChildren().add(pawn);
                cellGroup.whitePiece = true;
                cellGroup.hasPiece = true;
            }
            if (identity <= 55 && identity >= 48) {
                pawn = new Pawn();
                pawn.setId(String.valueOf(setPawnIdentityInt));
                setPawnIdentityInt++;
                pawn.setFitHeight(64);
                pawn.setFitWidth(64);
                pawn.setPreserveRatio(false);
                pawn.setImage(blackPawnImage);
                pawn.blackPawn = true;
                cellGroup.getChildren().add(pawn);
                cellGroup.blackPiece = true;
                cellGroup.hasPiece = true;
            }
            gridPane.addColumn(x);
            gridPane.addRow(x, cellGroup);

            if (((identity % 8) == 0) && identity != 64) {
                x++;
            }
            identity--;

        }
        return cellGroup;

    }


    public static void main (String[] args) {
        launch(args);

    }
}
