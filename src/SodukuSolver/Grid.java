package SodukuSolver;

import java.io.File;

public class Grid {
    //build grid for input file to be put into

    private File inputFile;
    private int[][] sodukuboard;

    int size = 9;  // this will be modified to size of board will be the second input of the script --- 1 2 3 4 5 6 7 8 9  --> create a 9x9 grid


    public Grid() {
        inputFile = null;
        sodukuboard = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                sodukuboard[x][y] = 0;
            }
        }
    }

    //time to initialize grid based on input

    public Grid(Grid initialGrid){
        inputFile = initialGrid.inputFile;
        sodukuboard = new int[size][size];

        for (int x = 0; x < size; x++) {
            System.arraycopy(initialGrid.sodukuboard[x], 0, sodukuboard[x], 0, size);
        }
    }

    public int getCell(int row, int column){
        return sodukuboard[row][column];
    }

    public void setCell(int cellValue, int row, int column){
        sodukuboard[row][column] = cellValue;
    }


}
