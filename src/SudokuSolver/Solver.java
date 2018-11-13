package SudokuSolver;

import static SudokuSolver.ReadInputFile.*;

public class Solver {
    public class Solver(String file){
     int size = getSize(file);
     String[] availableVariables = getAvailableVariables(file, size);
     String[] variables = getVariables(file);
     String[][] sudokuboard = getSudokuBoard(file,size,variables);


    public void solvePuzzle(){
        //where each solver will put in the work... read in variables for template and then modify
    }

    public long Timer(){
        //where each solver will initate this to keep track of length of timer
    };

    //public boolean isPuzzleSolved(String file){

        //what the solver will use to check if the puzzle is solved

        //if true, timer will stop
        //if true, name of solver will be saved to output file
        //if true, correct puzzle will be saved to output file


        /**
         * Checks if the given answer is correct
         *
         */
        public boolean checkBoard() {
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
            for (int i = 1; i <= 7; i += 3) {
                for (int j = 1; j <= 7; j += 3) {
                    if (checkMatrix(i, j)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }












    }

}




        /**
         * Checks if there are any repeated numbers in a sub matrix
         */

/**
        public boolean checkMatrix(int row, int col) {
            int i, j, central;
            boolean correct = false;

            central = m_board[row][col];
            i = row - 1;
            while (i <= row + 1 && correct) {
                j = col - 1;
                while (j <= col + 1 && correct) {
                    if (i != row && j != col && central == m_board[i][j]) {
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

/**
        public boolean checkBoard() {
            int value;

            //Iterate through the board
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    value = m_board[i][j];

                    if (value == 0) {
                        return false;
                    }

                    //Check for repeated numbers on the row
                    for (int z = 0; z < size; z++) {
                        if (j != z) {
                            if (value == m_board[i][z]) {
                                return false;
                            }
                        }
                    }

                    //Check for repeated numbers on the column
                    for (int z = 0; z < size; z++) {
                        if (i != z) {
                            if (value == m_board[z][j]) {
                                return false;
                            }
                        }
                    }
                }
            }
            //check sub matrices
            for (int i = 1; i <= size; i += 3) {
                for (int j = 1; j <= 7; j += 3) {
                    if (checkMatrix(i, j)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public void Timer(){
        //create timer to be used in all sub classes.
    }


}

 */