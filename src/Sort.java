public class Sort {

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

    public static void bubbleSort(int[] sourceArray, boolean showSortProcess) {
        int[] array = sourceArray.clone();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                    if (showSortProcess)  Main.printArray(array);
                }
            }
        }
    }

    public static void insertionSort(int[] sourceArray, boolean showSortProcess) {
        int[] array = sourceArray.clone();

        int k, temp;
        for (int i = 1; i < array.length; i++) {
            k = i;
            while (k > 0 && array[k-1] > array[k]) {
                temp = array[k-1];
                array[k-1] = array[k];
                array[k] = temp;
                k--;

                if (showSortProcess)  Main.printArray(array);
            }
        }
    }

    public static void shellSort(int[] sourceArray, boolean showSortProcess) {
        int[] array = sourceArray.clone();

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

                    if (showSortProcess)  Main.printArray(array);
                }
            }
            gap /= 2;
        }
    }

    public static void quickSort(int[] array, int first, int last, boolean showSortProcess) {

        if (first < last) {
            int lIndex = first;
            int rIndex = last - 1;
            int pivot = array[(lIndex + rIndex) / 2];
            do {
                while (array[lIndex] < pivot)
                    lIndex++;
                while (pivot < array[rIndex])
                    rIndex--;
                if (lIndex <= rIndex) {
                    int temp = array[lIndex];
                    array[lIndex] = array[rIndex];
                    array[rIndex] = temp;
                    lIndex++;
                    rIndex--;

                    if (showSortProcess) Main.printArray(array);
                }
            } while (lIndex < rIndex);

            quickSort(array, first, rIndex + 1, showSortProcess);
            quickSort(array, lIndex, last, showSortProcess);
        }
    }

    public static void selectionSort(int[] sourceArray, boolean showSortProcess) {
        int[] array = sourceArray.clone();

        for (int i = 0; i < array.length; i++) {
            int index = minIndex(array, i);

            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;

            if (showSortProcess) Main.printArray(array);
        }
    }

    public static void countingSort(int[] sourceArray, boolean showSortProcess) {
        int[] array = sourceArray.clone();

        int[] count = new int[max(array) + 1];
        for (int item : array) {
            count[item]++;
        }

        int arrayIndex = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[arrayIndex] = i;
                arrayIndex++;

                if (showSortProcess) Main.printArray(array);
            }
        }
    }
}

