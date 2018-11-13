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



        data += "Strategy:              Uses:             Time: \n";


        data += "input strategy" + "            " + 0 + "                " + "0:0"; //this is where the data will go


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





