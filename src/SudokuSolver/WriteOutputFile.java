package SudokuSolver;

import static SudokuSolver.Main.writeToFile;

public class WriteOutputFile extends ReadInputFile{

    public void WriteOutputFile(String file){
        //Writing output file
        int size = getSize(file);
        String[] availableVariables = getAvailableVariables(file, size);
        String[] variables = getVariables(file);
        String[][] sudokuboard = getSudokuBoard(file,size,variables);

        String outputfile = "C:\\Users\\scdro\\OneDrive\\Desktop\\CS5700\\SodukuSolver\\src\\SudokuSolver\\outputfile";
        String data = "";
        data += size;
        data += "\n";

        for (int i = 0; i < size; i++){
            data += availableVariables[i];
        }
        data += "\n";
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                data += sudokuboard[x][y];
                writeToFile(outputfile, data);
            }
            data += "\n";
            writeToFile(outputfile, data);
        }

        data += "\n";

    }



    //writeToFile(outputfile, data);

}

