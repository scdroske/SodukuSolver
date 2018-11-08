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

    public static void main(String[] args){
       //String text = readString("C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\SodukuSolver\\src\\SudokuSolver\\puzzle1.txt");
       // System.out.println(text);
        String[] variables = readArray("C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\SodukuSolver\\src\\SudokuSolver\\puzzle1.txt");

        int size = Integer.valueOf(variables[0]);
        //System.out.println(size);
        String[] availableVariables = new String[size];
        for(int i = 0; i < size; i++){
            availableVariables[i] = variables[i+1];
           // System.out.println(availableVariables[i]);
        }

        String[][] sudokuboard = new String[size][size];
        int varcount = size +1;
        //for (int i = 5; i < variables.length; i++){
            for( int x = 0; x < size; x++){
                for(int y = 0; y < size; y++) {
                    sudokuboard[x][y] = variables[varcount];
                    varcount++;
                }
            }
            
    }




    public static String readString(String file){
        String variables = "";
        try{
            Scanner s = new Scanner(new File(file));
            while(s.hasNextLine()){
                variables = variables + s.next() + " ";
            }
        }
        catch(FileNotFoundException e){
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
            while(readinPuzzle.hasNext()){
                counter++;
                readinPuzzle.next();
            }

            String[] variables = new String[counter];

            Scanner line = new Scanner(new File(file));
            for(int i = 0; i < counter; i++){
                variables[i] = line.next();
            }

            return variables;

        }
        catch (FileNotFoundException e) {
            System.out.println("Cannot read file");
            return null;
        }
    }
}


//Currently have :
// the size of the matrix :           size
// a string of variables we can use : availableVariables
// the sudoku board :                 sudokuboard

