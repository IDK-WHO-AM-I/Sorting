package sortingalgorythm;

public class BubblesortAlgorythm extends SortingAlgorythm {

    public BubblesortAlgorythm(Integer... array) {
        super(array);
    }

    @Override
    public void sortArray() {
        startTimer();
        for (int outdex = 0; outdex < unsortedArray.length; outdex++) {
            for (int index = 1; index < unsortedArray.length; index++) {
                int temp = 0;
                if (unsortedArray[index - 1] > unsortedArray[index]) {
                    temp = unsortedArray[index - 1];
                    unsortedArray[index - 1] = unsortedArray[index];
                    unsortedArray[index] = temp;
                }
            }
        }
        stopTimer();
    }

}
