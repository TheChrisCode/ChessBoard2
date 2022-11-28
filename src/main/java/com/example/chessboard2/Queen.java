package com.example.chessboard2;

import javafx.scene.image.ImageView;

public class Queen extends ImageView {
    boolean whiteQueen = false;
    boolean blackQueen = false;
    public static int y = 0;
    public static int x = 0;
    public static int a = 0;
    public static int b = 0;
    public static int attackSquaresIndex[] = new int[32];
    public static CellGroup attackSquaresPositiveDiagonal[] = new CellGroup[8];

    public static int[] calculateAttackSquares(Queen queenForMouseEvent, int queenRowIndex, int queenColumnIndex) {
        a = queenColumnIndex;
        b = queenRowIndex;
        for(int i = 0; i <= 7; i++) {
            x = i;
            y = (x-a) + b;
            attackSquaresIndex[i] = y*8 + x;
        }
        for(int i = 7; i <= 15; i++) {
            x = i;
            y = -(x-a) + b;
            attackSquaresIndex[i] = y*8 + x;
        }
        for(int i = 15; i <= 23; i++) {
            x = a;
            y = i;
            attackSquaresIndex[i] = y*8 + x;
        }
        for(int i = 23; i <= 31; i++) {
            x = i;
            y = b;
            attackSquaresIndex[i] = y*8 + x;
        }
        return attackSquaresIndex;
    }
}
