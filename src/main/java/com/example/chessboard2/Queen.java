package com.example.chessboard2;

import javafx.scene.image.ImageView;

public class Queen extends ImageView {
    boolean whiteQueen = false;
    boolean blackQueen = false;
    public static int y = 0;
    public static int x = 0;
    public static int a = 0;
    public static int b = 0;
    public static int index = 0;
    public static int attackSquaresIndex[] = new int[32];
    public static CellGroup attackSquaresPositiveDiagonal[] = new CellGroup[8];

    public static int[] calculateAttackSquares(Queen queenForMouseEvent, int queenRowIndex, int queenColumnIndex) {
        a = queenColumnIndex;
        b = queenRowIndex;
        for(int i = 0; i <= 7; i++) {
            x = i;
            y = (x-a) + b;

            if(y < 8 && y >= 0) {
                attackSquaresIndex[index] = y*8 + x;
            }

            index++;
            System.out.println(a + "This is a");
            System.out.println(b + "This is b");
            System.out.println(y + "This is y");
            System.out.println(x + "This is x");
            System.out.println(attackSquaresIndex[i] + "This is attackSquaresIndex");
        }

        for(int i = 0; i <= 7; i++) {
            x = i;
            y = -(x-a) + b;

            if(y < 8 && y >= 0) {
                attackSquaresIndex[index] = y*8 + x;
            }
            index++;
        }
        for(int i = 0; i <= 7; i++) {
            x = a;
            y = i;

            if(y < 8 && y >= 0) {
                attackSquaresIndex[index] = y*8 + x;
            }
            index++;
        }
        for(int i = 0; i <= 7; i++) {
            x = i;
            y = b;

            if(y < 8 && y >= 0) {
                attackSquaresIndex[index] = y*8 + x;
            }
            index++;
        }
        index = 0;
        return attackSquaresIndex;
    }
}
