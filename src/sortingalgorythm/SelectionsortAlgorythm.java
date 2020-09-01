package sortingalgorythm;

public class SelectionsortAlgorythm extends SortingAlgorythm {

    public SelectionsortAlgorythm(Integer... integers) {
        super(integers);
    }

    @Override
    public void sortArray() {
        startTimer();
        //TODO
        int current = 0;
        do {
            int min = current;
            for (int index = current; index < unsortedArray.length; index++) {
                if (unsortedArray[index] < unsortedArray[min]) {
                    min = index;
                }
            }
            int temp = unsortedArray[min];
            unsortedArray[min] = unsortedArray[current];
            unsortedArray[current] = temp;
            current++;
        } while (current < unsortedArray.length - 1);
        stopTimer();
    }
}
