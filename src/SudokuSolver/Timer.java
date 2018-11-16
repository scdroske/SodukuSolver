package SudokuSolver;


import java.sql.Time;
import java.time.Duration;
import java.time.Instant;

public class Timer {

    public String timeConverter(long time) {
        StringBuilder sb = new StringBuilder();
        long seconds = time / 1000000000;
        long days = seconds / (3600 * 24);

        append(sb, days, "d");

        seconds -= (days * 3600 * 24);
        long hours = seconds / 3600;

        append(sb, hours, "h");

        seconds -= (hours * 3600);
        long minutes = seconds / 60;

        append(sb, minutes, "m");

        seconds -= (minutes * 60);

        append(sb, seconds, "s");

        long nanos = time % 1000000000;

        append(sb, nanos, "ns");

        return sb.toString();
    }

    public void append(StringBuilder sb, long value, String text) {
        if (value > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(value).append(text);
        }
    }
}









/** twin, only option, guessing, apply changes */
