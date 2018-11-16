package SudokuSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class ReadInputFile {

    public static void readIn(String file){

        int size = getSize(file);
        String[] variables = getVariables(file);
        String[] availableVariables = getAvailableVariables(file, size);

        for (int i = 0; i < size; i++) {
            availableVariables[i] = variables[i + 1];
            // System.out.println(availableVariables[i]);
        }

        /** read in sudokuboard*/
        String[][] sudokuboard = getSudokuBoard(file,size,variables);
    }

    /**gets the initial sudokuboard and stores it as an array of strings [][] */
    public static String[][] getSudokuBoard(String file, int size, String[] variables){
        String[][] sudokuboard = new String[size][size];
        int varcount = size + 1;
        //for (int i = 5; i < variables.length; i++){
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                sudokuboard[x][y] = variables[varcount];
                varcount++;
            }
        }
        return sudokuboard;
    }

    public void setSudokuBoard(){};



    /**gets the submatrix size of the sudokuboard */
    public static double getSubMatrixSize(String file){
        double subMatrixSize = 0;
        String[] variables = readArray(file);
        subMatrixSize = Math.sqrt(Integer.valueOf(variables[0]));
        return subMatrixSize;
    }

    public void setSubMatrixSize(){};


    /**gets the matrix size of the sudokuboard */
    public static int getSize(String file){
        int size = 0;
        String[] variables = readArray(file);
        size = Integer.valueOf(variables[0]);
        return size;
    }

    public void setSize(){};

    /**gets all of the data from the input file  */
    public static String[] getVariables(String file){
        String[] variables = readArray(file);
        return variables;
    }

    public void setVariables(){};
    /**gets the available variables to use to fill in the blanks of the sudokuboard */
    public static String[] getAvailableVariables(String file, int size){
        String variables[] = getVariables(file);

        String[] availableVariables = new String[size];
        for (int i = 0; i < size; i++) {
            availableVariables[i] = variables[i + 1];
            // System.out.println(availableVariables[i]);
        }
        return availableVariables;
    }

    public void setAvailableVariables(String file, int size){

    }

    /**implement to read title of file being read in if implementing through a directory */
    public static String readString(String file) {
        String variables = "";
        try {
            Scanner s = new Scanner(new File(file));
            while (s.hasNextLine()) {
                variables = variables + s.next() + " ";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return variables;
    }


/** reads the array of data from the input file */

    public static String[] readArray(String file) {
        int counter = 0;
        //count how many lines are in file
        //create array and copy elements in
        try {
            Scanner readinPuzzle = new Scanner(new File(file));
            while (readinPuzzle.hasNext()) {
                counter++;
                readinPuzzle.next();
            }

            String[] variables = new String[counter];

            Scanner line = new Scanner(new File(file));
            for (int i = 0; i < counter; i++) {
                variables[i] = line.next();
            }

            return variables;

        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
            return null;
        }
    }

}