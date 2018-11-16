package SudokuSolver;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import static SudokuSolver.ReadInputFile.*;

public abstract class Solver {

    /** timer will start when execute method is called, will end after
     * classes run and puzzle is solved.
     */
    public final void execute() {
        startTimer();
        findApplicableCells();
        applyChanges();
        stopTimer();
        //time.TotalTime(time.startTimer(), time.stopTimer());
        timeToComplete();
    }

    /**
     * Template methods to be overridden/used for each method
     */

    protected abstract void findApplicableCells();

    protected abstract double applyChanges();

    protected abstract long timeToComplete();

    private boolean deleteValue(ArrayList<Integer> values, int number) {
        for (int value : values) {
            if (value != number) {
                return false;
            }
        }

        return true;
    }
    public long startTimer(){
        long startTime = System.nanoTime();
        return startTime;
    }

    public long stopTimer(){
        long stopTime = System.nanoTime();
        return stopTime;
    }


}

