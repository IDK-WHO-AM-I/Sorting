package sortingalgorythm;

public class QuicksortAlgorythm extends SortingAlgorythm {

    public QuicksortAlgorythm(Integer... integers) {
        super(integers);
    }

    @Override
    public void sortArray() {
        startTimer();
        quicksort(0, unsortedArray.length - 1);
        stopTimer();
    }

    private void quicksort(int left, int right) {
        if (left < right) {
            int divider = divide(left, right);
            quicksort(left, divider - 1);
            quicksort(divider + 1, right);
        }
    }

    private int divide(int left, int right) {
        int x = left;
        int y = right - 1;
        int pivot = unsortedArray[right];
        do {
            while (x < right - 1 && unsortedArray[x] < pivot) {
                x++;
            }
            while (y > left && unsortedArray[y] >= pivot) {
                y--;
            }
            if (x < y) {
                int temp = unsortedArray[x];
                unsortedArray[x] = unsortedArray[y];
                unsortedArray[y] = temp;
            }
        } while (x < y);

        if (unsortedArray[x] > pivot) {
            int temp = unsortedArray[x];
            unsortedArray[x] = pivot;
            unsortedArray[right] = temp;

        }
        return x;
    }

}
