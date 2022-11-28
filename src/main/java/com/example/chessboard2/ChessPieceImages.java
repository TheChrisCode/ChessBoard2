package com.example.chessboard2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ChessPieceImages {

    public static Image whitePawnImage;
    public static Image blackPawnImage;
    public static Image whiteKingImage;
    public static Image blackKingImage;
    public static Image whiteQueenImage;
    public static Image blackQueenImage;

    public static void PieceImages() throws Exception{
        whitePawnImage = new Image(new FileInputStream("C:\\Users\\Christia.Phillips\\IdeaProjects\\ChessBoard2\\src\\main\\resources\\com\\example\\chessboard2\\whitepawn.png"));
        blackPawnImage = new Image(new FileInputStream("C:\\Users\\Christia.Phillips\\IdeaProjects\\ChessBoard2\\src\\main\\resources\\com\\example\\chessboard2\\blackPawnTransparent2.png"));
        whiteKingImage = new Image(new FileInputStream("C:\\Users\\Christia.Phillips\\IdeaProjects\\ChessBoard2\\src\\main\\resources\\com\\example\\chessboard2\\whiteKing.png"));
        blackKingImage = new Image(new FileInputStream("C:\\Users\\Christia.Phillips\\IdeaProjects\\ChessBoard2\\src\\main\\resources\\com\\example\\chessboard2\\blackKing.png"));
        whiteQueenImage = new Image(new FileInputStream("C:\\Users\\Christia.Phillips\\IdeaProjects\\ChessBoard2\\src\\main\\resources\\com\\example\\chessboard2\\whiteQueen.png"));
        blackQueenImage = new Image(new FileInputStream("C:\\Users\\Christia.Phillips\\IdeaProjects\\ChessBoard2\\src\\main\\resources\\com\\example\\chessboard2\\blackQueen.png"));
    }

}
