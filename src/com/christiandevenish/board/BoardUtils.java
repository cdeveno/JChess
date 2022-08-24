package com.christiandevenish.board;

import com.christiandevenish.Main;

public final class BoardUtils {

    /*
    Converts row number for calculation of y coordinate
     */
    public static int calculateYCoord(int row) {
        return (-row + 8) * getTileSize();
    }

    public static int calculateXCoord(char column) {
        return (column - 'a') * getTileSize();
    }

    public static char xCoordToColumn (double x) {
        return (char) (Math.floor(x / getTileSize()) + 'a');
    }

    public static int yCoordToRow (double y) {
        int row = (int) Math.floor(y / getTileSize()) + 1;
        return 9 - row;
    }


    public static int getTileSize() {
        return Main.boardLength / 8;
    }
    
}
