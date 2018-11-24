package SudokuSolver;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

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
        time = time*-1;
        return time;

    }

    @Override
    protected double applyChanges() {
        return 1;
    }

}
