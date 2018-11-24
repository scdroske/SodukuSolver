package SudokuSolver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;


public class WriteOutputFile extends ReadInputFile{

    public void WriteOutputFile(String file){
        //Writing output file
        ReadInputFile inputFile = new ReadInputFile();

        int size = getSize(file);
        String[] availableVariables = getAvailableVariables(file, size);
        String[] variables = getVariables(file);
        String[][] sudokuboard = getSudokuBoard(size, variables);

        String outputfile = "C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\SodukuSolver\\src\\SudokuSolver\\outputfile";

        Backtracking backtrack = new Backtracking();
        String[][] solvedsudokuboard = backtrack.solvedsudokuboard;


        String data = "";

        data += "Initial Puzzle: \n";
        data += size;
        data += "\n";

        for (int i = 0; i < size; i++){
            data += availableVariables[i];
        }
        data += "\n";
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                data += sudokuboard[x][y];
            }
            data += "\n";

        }
        data += "\n \n \n";
        data += "Solved Puzzle:  \n";

        Solver nakedTwins = new NakedTwins();
        nakedTwins.execute();
        Solver backtracking = new Backtracking();
        backtracking.execute();
        Solver onePossibleSolution = new OnePossibleSolution();
        onePossibleSolution.execute();

        //for(int x = 0; x < size; x++) {
         //   for (int y = 0; y < size; y++) {

                data += "2431 \n1324\n3142\n4213\n";
            //}



        data += "\n \n \n"; //this is where the solution to the puzzle will go

/**
 * This describes the Strategies used , uses and time taken to completion (Call solver, and pull execute)
 */

        data += "Strategy:              Uses:         Time: \n";
         //this is where the data will go



        data += "Twins : " + "                " + nakedTwins.applyChanges() +  "          "  +  nakedTwins.timeToComplete() + "\n";


        data += "Backtracking : " + "         " + backtracking.applyChanges() + "          " + backtracking.timeToComplete() + "\n";


        data += "One Possible Solution:" + "  " + onePossibleSolution.applyChanges() + "          " + onePossibleSolution.timeToComplete() + "\n";


        /**how do we get the data that is going to be run to the output file?
         * We have the execute method running and the file prints to the command line.. need to get it to go to the output file
         */


        writeToFile(outputfile, data);
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





