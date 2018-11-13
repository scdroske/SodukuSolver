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
}

//Currently have :
// the size of the matrix :           size
// a string of variables we can use : availableVariables
// the sudoku board :                 sudokuboard

