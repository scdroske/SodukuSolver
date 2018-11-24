package SudokuSolver;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

public class NakedTwins extends Solver {
    @Override
    protected long timeToComplete() {
        long time = this.stopTimer() - this.startTimer();
        Timer timer = new Timer();
        time = time*-1;
        return time;

    }

    @Override
    protected void findApplicableCells() {
        try {
            ReadInputFile inputFile = new ReadInputFile();
            int size = inputFile.size;
            String[][] sudokuboard = inputFile.sudokuboard;

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if (sudokuboard[i][j] == "-"){
                        sudokuboard[i][j] = "0";
                    }
                    else
                        continue;
                }

            }


            System.out.println("solving puzzle");
            //backtracking(sudokuboard);
            //this is where we will implement the code to backtrack
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Cannot Sleep");
        }
    }

    @Override
    protected double applyChanges() {
        System.out.println("Applying changes via Naked Twins");
        return 2;
    }
}
