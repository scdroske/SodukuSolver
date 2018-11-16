package SudokuSolver;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class NakedTwins extends Solver {
    @Override
    protected long timeToComplete() {
        long time = this.stopTimer() - this.startTimer();
        Timer timer = new Timer();

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
