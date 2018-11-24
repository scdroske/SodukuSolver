package SudokuSolver;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class OnePossibleSolution extends Solver {



    @Override
    protected void findApplicableCells() {
        //if there is only one cell number left, fill cell 
    }

    @Override
    protected long timeToComplete() {
        long time = this.stopTimer() - this.startTimer();
        Timer timer = new Timer();
        String timeTaken = timer.timeConverter(time);

        return time;

    }

    @Override
    protected double applyChanges() {
        return 1;
    }

}
