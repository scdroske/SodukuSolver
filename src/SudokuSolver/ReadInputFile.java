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

    public static int getSize(String file){
        int size = 0;
        String[] variables = readArray(file);
        size = Integer.valueOf(variables[0]);
        return size;
    }
    public static String[] getVariables(String file){
        String[] variables = readArray(file);
        return variables;
    }
    public static String[] getAvailableVariables(String file, int size){
        String variables[] = getVariables(file);

        String[] availableVariables = new String[size];
        for (int i = 0; i < size; i++) {
            availableVariables[i] = variables[i + 1];
            // System.out.println(availableVariables[i]);
        }

        return availableVariables;
    }


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