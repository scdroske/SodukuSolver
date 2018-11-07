package SudokuSolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Grid {
    //build grid for input file to be put into

    private File inputFile;
    public int[][] sudokuboard;

    int size = 4;  // this will be modified to size of board will be the second input of the script --- 1 2 3 4 5 6 7 8 9  --> create a 9x9 grid

    public File getInputFile(){
        return inputFile;
    }

    public void setInputFile(File file){
        inputFile = file;
    }

    public int getGridSize(){
        return size;
    }

    public void setGridSize(int gridSize){
        size = gridSize;
    }


    public Grid() {
        inputFile = null;
        sudokuboard = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                sudokuboard[x][y] = 0;
            }
        }
    }

    //time to initialize grid based on input
    //sets all the grid to 0's to establish an empty size
    public Grid(Grid initialGrid){
        getGridSize();
        getInputFile();
        inputFile = initialGrid.inputFile;
        sudokuboard = new int[size][size];

        for (int x = 0; x < size; x++) {
            System.arraycopy(initialGrid.sudokuboard[x], 0, sudokuboard[x], 0, size);
        }
    }

    public int getCell(int row, int column){
        return sudokuboard[row][column];
    }

    public void setCell(int cellValue, int row, int column){
        sudokuboard[row][column] = cellValue;
    }


    //code to read in the file that contains the info to put into the grid.
    public void readInputFile() {
        //Steps:
        //read in the file
        //check if file can be opened (check errors)
        //parse the integers into the grid
        //close the file (check errors)

        FileReader fileReader = null;
        String inputLine;
        int x;

        try {
            fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            try {
                x = 0;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    String[] sudokuVariables = inputLine.split(" ");

                    for (int y = 0; y < sudokuVariables.length; y++) {
                        sudokuboard[x][y] = Integer.parseInt(sudokuVariables[y]);
                    }
                    x++;
                }
            } catch (IOException e) {
                System.out.println("Cannot read file lines from file:" + inputFile.getName());
            }
        } catch (IOException ex) {
            System.out.println("Cannot open file: " + inputFile.getName());
        } finally {
            try {
                if (null != fileReader) {
                    fileReader.close();
                }
            } catch (Exception exc) {
                System.out.println("Cannot close file: " + inputFile.getName());
            }
        }
    }


}



