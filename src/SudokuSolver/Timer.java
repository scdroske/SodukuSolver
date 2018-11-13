package SudokuSolver;


import java.time.Duration;
import java.time.Instant;

public class Timer{
    Timer timer;

    public Instant startTimer(){
        Instant startTime = Instant.now();
        return startTime;
    }

    public Instant stopTimer(){
        Instant stopTime = Instant.now();
        return stopTime;
    }

    public long TotalTime(){
        long timeEllapsed = Duration.between(startTimer(), stopTimer()).toMillis();
        System.out.println("total time taken: " + timeEllapsed);
        return timeEllapsed;
    }
}

