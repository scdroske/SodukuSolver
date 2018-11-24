package SudokuSolver;



public class CorrectSolution {

    /**
     * Checks if repeated numbers occur in sub matrix
     */
    public boolean checkMatrix(String file, int row, int col) {
        ReadInputFile inputFile = new ReadInputFile();
        int size = inputFile.size;
        String[] variables = inputFile.variables;
        String[] availableVariables = inputFile.availableVariables;

        String[][] sudokuboard = inputFile.sudokuboard;

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
     * Checks for answer in the code
     *
     */
    public boolean checkBoard(String file) {
        ReadInputFile inputFile = new ReadInputFile();
        int size = inputFile.size;
        String[] variables = inputFile.variables;
        String[] availableVariables = inputFile.availableVariables;

        String[][] sudokuboard = inputFile.sudokuboard;

        String value;

        //Iterate through the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                value = sudokuboard[i][j];

                if (value == "-") {
                    return false;
                }

                //Check for repeated numbers on the row
                for (int z = 0; z < size; z++) {
                    if (j != z) {
                        if (value == sudokuboard[i][z]) {
                            return false;
                        }
                    }
                }

                //Check for repeated numbers on the column
                for (int z = 0; z < size; z++) {
                    if (i != z) {
                        if (value == sudokuboard[z][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        //check sub matrices
        for (int i = 1; i <= (size - 2); i += 3) {
            for (int j = 1; j <= (size -2 ); j += 3) {
                if (checkMatrix(file,i, j)) {
                    return false;
                }
            }
        }

        return true;
    }
}





