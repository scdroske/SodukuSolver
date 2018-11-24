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

    }

    @Override
    protected double applyChanges() {
        return 2;
    }
}
