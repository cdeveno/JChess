package com.christiandevenish.board;

import com.christiandevenish.Main;

public final class BoardUtils {

    /*
    Converts row number for calculation of y coordinate
     */
    public static int calculateYCoord(int row) {
        switch (row) {
            case 1:
                row = 8;
                break;
            case 2:
                row = 7;
                break;
            case 3:
                row =  6;
                break;
            case 4:
                row = 5;
                break;
            case 5:
                row = 4;
                break;
            case 6:
                row = 3;
                break;
            case 7:
                row = 2;
                break;
            case 8:
                row = 1;
                break;
        }
        return (row - 1) * getTileSize();
    }

    public static int calculateXCoord(char column) {
        return (column - 'a') * getTileSize();
    }

    public static char xCoordToColumn (double x) {
        return (char) (Math.floor(x / getTileSize()) + 'a');
    }

    public static int yCoordToRow (double y) {
        int row = (int) Math.floor(y / getTileSize()) + 1;
        switch (row) {
            case 1:
                row = 8;
                break;
            case 2:
                row = 7;
                break;
            case 3:
                row =  6;
                break;
            case 4:
                row = 5;
                break;
            case 5:
                row = 4;
                break;
            case 6:
                row = 3;
                break;
            case 7:
                row = 2;
                break;
            case 8:
                row = 1;
                break;
        }
        return row;
    }


    public static int getTileSize() {
        return Main.boardLength / 8;
    }
    
}
