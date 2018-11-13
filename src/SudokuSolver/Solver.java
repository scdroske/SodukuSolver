package SudokuSolver;

import static SudokuSolver.ReadInputFile.*;

public abstract class Solver {

    /** timer will start when execute method is called, will end after
     * classes run and puzzle is solved.
     */
    public final void execute() {
        Timer time = new Timer();
        time.startTimer();
        findApplicableCells();
        applyChanges();
        time.stopTimer();
        time.TotalTime();
    }

    /**
     * Template methods to be overridden/used for each method
     */



    protected abstract void findApplicableCells();

    protected abstract void applyChanges();


}

