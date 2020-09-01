package sortingalgorythm;

public class InsertionsortAlgorythm extends SortingAlgorythm {

    public InsertionsortAlgorythm(Integer... integers) {
        super(integers);
    }

    @Override
    public void sortArray() {
        startTimer();
        int n = unsortedArray.length;
        for (int i = 1; i < n; ++i) {
            int key = unsortedArray[i];
            int j = i - 1;

            while (j >= 0 && unsortedArray[j] > key) {
                unsortedArray[j + 1] = unsortedArray[j];
                j = j - 1;
            }
            unsortedArray[j + 1] = key;
        }
        stopTimer();
    }
}