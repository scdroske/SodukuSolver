package SudokuSolver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class WriteOutputFile extends ReadInputFile{

    public void WriteOutputFile(String file){
        //Writing output file
        int size = getSize(file);
        String[] availableVariables = getAvailableVariables(file, size);
        String[] variables = getVariables(file);
        String[][] sudokuboard = getSudokuBoard(file,size,variables);


        String outputfile = "C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\SodukuSolver\\src\\SudokuSolver\\outputfile";
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



        data += "\n \n \n"; //this is where the solution to the puzzle will go

/**
 * This describes the Strategies used , uses and time taken to completion (Call solver, and pull execute)
 */

        data += "Strategy:              Uses:         Time: \n";
         //this is where the data will go

        Solver nakedTwins = new NakedTwins();
        nakedTwins.execute();
        data += "Twins : " + "                " + nakedTwins.applyChanges() +  "          "  +  nakedTwins.timeToComplete() + "\n";

        Solver backtracking = new Backtracking();
        backtracking.execute();
        data += "Backtracking : " + "         " + backtracking.applyChanges() + "          " + backtracking.timeToComplete() + "\n";

        Solver onePossibleSolution = new OnePossibleSolution();
        onePossibleSolution.execute();
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





