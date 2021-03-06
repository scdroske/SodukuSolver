package SudokuSolver;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static SudokuSolver.ReadInputFile.*;
import static java.lang.Math.abs;


public class Backtracking extends Solver {

    //int size = getSize(file);
    //String[] availableVariables = getAvailableVariables(file, size);
    //String[] variables = getVariables(file);
    String[][] solvedsudokuboard;


    @Override
    protected double applyChanges() {
        try {
            System.out.println("applying changes via Backtracking");
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            System.out.println("Cannot Sleep");
        }
        return 4;
    }

    @Override
    protected long timeToComplete() {
        long time = this.stopTimer() - this.startTimer();
        String timeTaken = "" + time;
        System.out.println("Time: " + timeTaken);
        long durationinMS = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS);
        time = time*-1;
        return time;

    }


    @Override
    protected void findApplicableCells() {
        try {

            ReadInputFile inputFile = new ReadInputFile();
            int size = inputFile.size;
            System.out.println(size);
            String[][] solvedsudokuboard = inputFile.sudokuboard;
            String[][] sudokuboard = inputFile.sudokuboard;

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++) {
                    if (sudokuboard[i][j] != "-") {
                        solvedsudokuboard[i][j] = "0";
                        System.out.println("changing variable to 0");
                    } else {
                        solvedsudokuboard[i][j] = sudokuboard[i][j];

                        System.out.println("no variables to change");
                        System.out.println(sudokuboard[i][j]);
                    }
                }
            }
            this.solvedsudokuboard = solvedsudokuboard;
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    System.out.println(sudokuboard[i][j]);
                }
                    System.out.println("\n");
            }


            System.out.println("solving puzzle backtracking");
            //backtracking(sudokuboard);
            //this is where we will implement the code to backtrack
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            System.out.println("Cannot Sleep");
        }
    }
}
/**
    private boolean backtracking(String[][] sudokuboard) {
        int recursiveCalls = 0;
        recursiveCalls++;
        if (endOfGrid(sudokuboard)) {
            return true;
        }

        ArrayList<Integer> valuesCell = sudokuboard.get(cell); // get the domain of the cell on which im operating
        int value = 0;

        for (int i = 0; i < valuesCell.size(); i++) { // Iterate through the cells domain
            value = valuesCell.get(i);                  // get a value from the domain
            sudokuboard.setCell(value, cell.row, cell.col);  // set the value onto the board
            if (isValid(sudokuboard, cell, value)) {            // check for errors
                if (backtrack(sudokuboard, cell.nextCell(sudokuboard))) {   // recursive call
                    return true;
                }
            }
        }
        sudokuboard.setCell(0, cell.row, cell.col);  // restores the cell value

        return false;
    }

    private boolean endOfGrid(String[][] sudokuboard) { // returns true if the whole grid is full
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuboard.getCell(i, j) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(Grid tablero, Cell cell, int value) { // Checks if the inserted value is correct
        for (int i = 0; i < 9; i++) { // check for repeated values in the row
            if (i != cell.col) {
                if (tablero.getCell(cell.row, i) == value) {
                    return false;
                }
            }
        }

        for (int j = 0; j < 9; j++) { // check for repeated values in the column
            if (j != cell.row) {
                if (tablero.getCell(j, cell.col) == value) {
                    return false;
                }
            }
        }

        if (!checkMatrix(tablero, cell, value)) {
            return false;
        }

        return true;
    }

    private boolean checkMatrix(Grid board, Cell cell, int value) { // check for repeated values on a 3x3 matrix
        float x1Calc = 3 * (cell.row / 3);
        float y1Calc = 3 * (cell.col / 3);
        int x1 = Math.round(x1Calc);
        int y1 = Math.round(y1Calc);
        int x2 = x1 + 2;
        int y2 = y1 + 2;

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (x != cell.row && y != cell.col) {
                    if (board.getCell(x, y) == value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}


    /**
    //go through the row, check if the solution exists..
     for int i = 0; i < size; i++){
        for int j = 0; j < size; j++){
     ***** check if variable = -
            if (sudokuboard[i][j] = "-"){
                currentPosition = sudokuboard[i][j](need the position ie. [3][1] not value;
                fillCell(currentPosition);
                checkCell(currentPosition);
     }
     currentPosition = sudokuboard[2][3]
     fillCell(Cell currentPosition){ **call in the position of current cell

        for(int i = 0; i < size; i++){
            if(availableVariables [i] = sudokuboard[
     }


            for(int j = 0; j < size; j++){
                if  (availableVariabes[i] = sudokuboard[i][j])



     }
     if


     }


}
     */
