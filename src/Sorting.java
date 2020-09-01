import sortingalgorythm.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class Sorting {

    private SortingAlgorythm algorythm = null;

    public Sorting() {
        Object[] arrayOptions = {"Unsorted Array", "Unsorted Array (Duplicates)", "Ascending Array", "Descending Array", "Generated Array"};
        int arrayResult = JOptionPane.showOptionDialog(JOptionPane.getRootFrame(),
                "Please select which array to use",
                "Array Selection",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                arrayOptions,
                null);

        arrayResult++;

        Object[] options = {"Bubblesort", "Insertionsort", "Selectionsort", "Quicksort"};

        int result = JOptionPane.showOptionDialog(JOptionPane.getRootFrame(),
                "Please choose the Algorythm used for sorting",
                "Sorting Algorythm",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);

        result++;

        chooseAlgorythm(result, loadData(arrayResult));

        if (algorythm != null) {
            System.out.println(printToConsole(algorythm.getArray()));
        }
    }

    public Integer[] loadData(int arrayNr) {
        switch (arrayNr) {
            case 1:
                //unsorted array
                return new Integer[]{100, 30, 42, 48, 97, 72, 84, 27, 77, 59, 94, 65, 34, 43, 25, 14, 85, 62, 29};
            case 2:
                //unsorted dublette array
                return new Integer[]{100, 30, 42, 48, 97, 72, 84, 27, 77, 59, 94, 65, 34, 43, 25, 14, 85, 65, 25};
            case 3:
                //sorted ascending
                return new Integer[]{14, 25, 27, 29, 30, 34, 42, 43, 48, 59, 62, 65, 72, 77, 84, 85, 94, 97, 100};
            case 4:
                //sorted descending
                return new Integer[]{100, 97, 94, 85, 84, 77, 72, 65, 62, 59, 48, 43, 42, 34, 30, 29, 27, 25, 14};
            case 5:
                String input = JOptionPane.showInputDialog("How many entries should be generated?");
                int amount = (Pattern.matches("[a-z]+", input) || input.length() < 1) ? 1000 : Integer.parseInt(input);
                return generateArray(amount);
        }
        return new Integer[20];
    }

    private Integer[] generateArray(int size) {
        Integer[] array = new Integer[size];
        for (int x = 0; x < size; x++) {
            array[x] = ThreadLocalRandom.current().nextInt(size);
        }
        return array;
    }

    public void chooseAlgorythm(int algorythmCode, Integer[] array) {
        //System.out.println(array);
        switch (algorythmCode) {
            case 1:
                algorythm = new BubblesortAlgorythm(array);
                break;
            case 2:
                algorythm = new InsertionsortAlgorythm(array);
                break;
            case 3:
                algorythm = new SelectionsortAlgorythm(array);
                break;
            case 4:
                algorythm = new QuicksortAlgorythm(array);
                break;
        }
        algorythm.sortArray();
        System.out.println(String.format("The sorting operation took %s", algorythm.getOperationDuration().toMillis() + " ms"));
    }

    public String printToConsole(Integer[] array) {
        return String.join(" ", Arrays.stream(array).map(String::valueOf).toArray(String[]::new));
    }

}
