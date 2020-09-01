package sortingalgorythm;

import java.time.Duration;
import java.time.LocalTime;

public abstract class SortingAlgorythm {

    protected Integer[] unsortedArray;
    private LocalTime startTime, finishTime;

    public SortingAlgorythm(Integer... integers) {
        this.unsortedArray = integers;
    }

    public abstract void sortArray();

    public Integer[] getArray() {
        return unsortedArray;
    }

    protected void startTimer() {
        this.startTime = LocalTime.now();
    }

    protected void stopTimer() {
        this.finishTime = LocalTime.now();
    }

    public Duration getOperationDuration() {
        return Duration.between(startTime, finishTime);
    }
}
