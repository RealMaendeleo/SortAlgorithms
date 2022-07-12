import java.util.Arrays;

public class Sort {

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static int minIndex(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int max(int[] array) {
        int max = array[0];
        for (int item : array) {
            if (max < item) {
                max = item;
            }
        }
        return max;
    }

    public static void bubbleSort(int[] sourceArray) {
        int[] array = sourceArray.clone();
        long startTime = System.currentTimeMillis();

//        printArray(array);
//        System.out.println("Сортируем...");

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
//                    printArray(array);
                }
            }
        }
        long runtime = System.currentTimeMillis() - startTime;
        System.out.println("  Пузырьковая: " + runtime + " мс.");
    }

    public static void insertionSort(int[] sourceArray) {
        int[] array = sourceArray.clone();
        long startTime = System.currentTimeMillis();

        printArray(array);
        System.out.println("Сортируем...");

        int k, temp;
        for (int i = 1; i < array.length; i++) {
            k = i;
            while (k > 0 && array[k-1] > array[k]) {
                temp = array[k-1];
                array[k-1] = array[k];
                array[k] = temp;
                k--;
                printArray(array);
            }
        }

        long runtime = System.currentTimeMillis() - startTime;
        System.out.println("  Вставками: " + runtime + " мс.");
    }

    public static void shellSort(int[] sourceArray) {
        int[] array = sourceArray.clone();
        long startTime = System.currentTimeMillis();

//        printArray(array);
//        System.out.println("Сортируем...");

        int currentItem;
        int index;
        int gap = array.length / 2;

        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                currentItem = array[i];
                index = i;
                while ((index >= gap) && (array[index-gap] > currentItem)) {
                    array[index] = array[index-gap];
                    index -= gap;
                    array[index] = currentItem;

//                    printArray(array);
                }
            }
            gap /= 2;
        }
        long runtime = System.currentTimeMillis() - startTime;
        System.out.println("  Шелла: " + runtime + " мс.");
    }

    public static void quickSort(int[] array, int first, int last, boolean showRuntime) {
        long startTime = System.currentTimeMillis();

//        printArray(array);
//        System.out.println("Сортируем...");

        if (first < last) {
            int lIndex = first;
            int rIndex = last - 1;
            int middle = array[(lIndex + rIndex) / 2];
            do {
                while (array[lIndex] < middle)
                    lIndex++;
                while (middle < array[rIndex])
                    rIndex--;
                if (lIndex <= rIndex) {
                    int temp = array[lIndex];
                    array[lIndex] = array[rIndex];
                    array[rIndex] = temp;
                    lIndex++;
                    rIndex--;
//                    printArray(array);
                }
            } while (lIndex < rIndex);

            quickSort(array, first, rIndex + 1, false);
            quickSort(array, lIndex, last, false);
        }
        long runtime = System.currentTimeMillis() - startTime;
        if (showRuntime)
            System.out.println("  Быстрая: " + runtime + " мс.");
    }

    public static void selectionSort(int[] sourceArray) {
        int[] array = sourceArray.clone();
        long startTime = System.currentTimeMillis();

//        printArray(array);
//        System.out.println("Сортируем...");

        for (int i = 0; i < array.length; i++) {
            int index = minIndex(array, i);

            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
//            printArray(array);
        }
        long runtime = System.currentTimeMillis() - startTime;
        System.out.println("  Выбором: " + runtime + " мс.");
    }

    public static void countingSort(int[] sourceArray) {
        int[] array = sourceArray.clone();
        long startTime = System.currentTimeMillis();

//        printArray(array);
//        System.out.println("Сортируем...");

        int[] count = new int[max(array) + 1];
        for (int item : array) {
            count[item]++;
        }

        int arrayIndex = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[arrayIndex] = i;
                arrayIndex++;
//                printArray(array);
            }
        }
        long runtime = System.currentTimeMillis() - startTime;
        System.out.println("  Подсчетом: " + runtime + " мс.");
    }
}

