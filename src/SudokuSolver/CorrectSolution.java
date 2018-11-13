package SudokuSolver;

import static SudokuSolver.ReadInputFile.getAvailableVariables;
import static SudokuSolver.ReadInputFile.getSize;
import static SudokuSolver.ReadInputFile.getVariables;

public class CorrectSolution {

    /**
     * Checks if there are any repeated numbers in a sub matrix
     */
    public boolean checkMatrix(String file, int row, int col) {
        ReadInputFile inputFile = new ReadInputFile();
        int size = getSize(file);
        String[] variables = getVariables(file);
        String[] availableVariables = getAvailableVariables(file, size);

        String[][] sudokuboard = inputFile.getSudokuBoard(file, size, variables);

        int i, j;
        String central;

        boolean correct = false;

        central = sudokuboard[row][col];
        i = row - 1;
        while (i <= row + 1 && correct) {
            j = col - 1;
            while (j <= col + 1 && correct) {
                if (i != row && j != col && central == sudokuboard[i][j]) {
                    correct = true;
                }
                j++;
            }
            i++;
        }
        return correct;
    }

    /**
     * Checks if the given answer is correct
     *
     */
    public boolean checkBoard(String file) {
        ReadInputFile inputFile = new ReadInputFile();
        int size = getSize(file);
        String[] variables = getVariables(file);
        String[] availableVariables = getAvailableVariables(file, size);

        String[][] sudokuboard = inputFile.getSudokuBoard(file, size, variables);

        String value;

        //Iterate through the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                value = sudokuboard[i][j];

                if (value == "-") {
                    return false;
                }

                //Check for repeated numbers on the row
                for (int z = 0; z < 9; z++) {
                    if (j != z) {
                        if (value == sudokuboard[i][z]) {
                            return false;
                        }
                    }
                }

                //Check for repeated numbers on the column
                for (int z = 0; z < 9; z++) {
                    if (i != z) {
                        if (value == sudokuboard[z][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        //check sub matrices
        for (int i = 1; i <= (size - 3); i += 3) {
            for (int j = 1; j <= 7; j += 3) {
                if (checkMatrix(file,i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}





