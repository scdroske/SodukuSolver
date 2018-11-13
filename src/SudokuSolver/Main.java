package SudokuSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String file = "C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\SodukuSolver\\src\\SudokuSolver\\puzzle1.txt";

        ReadInputFile readfile = new ReadInputFile();
        readfile.readIn(file);

        WriteOutputFile writefile = new WriteOutputFile();
        writefile.WriteOutputFile(file);



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


    public static void writeToFile(String file, String data) {
        OutputStream os = null;
        try {
            //write input and then corresponding output to file
            os = new FileOutputStream(new File(file));
            os.write(data.getBytes(), 0, data.length());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}


//Currently have :
// the size of the matrix :           size
// a string of variables we can use : availableVariables
// the sudoku board :                 sudokuboard

