package SudokuSolver;

import java.io.File;

public class Main {




        public static void main(String[] args){
            File directoryIn = new File("C:\\Users\\scdro\\OneDrive\\Desktop\\ExampleSodukuSolvers\\cs5700f18-shared\\hw4b\\SamplePuzzles\\Input");
            File[] listOfFiles = directoryIn.listFiles();
            File oneFile = new File(directoryIn + "Puzzle-4x4-0001.txt");



            File file = new File("puzzle1.txt");
            Grid grid = new Grid();
            grid.setGridSize(4);
            grid.setInputFile(file);

            //System.out.println(grid.size);

/*
            for(File file :listOfFiles)
            {
                if (file.isFile()) {
                    File specificFile = new File(directoryIn + "Puzzle-4x4-0001.txt");
                    System.out.println(specificFile.getName());
                    System.out.println(file.getName());
                }
            }

*/




        }
    }
