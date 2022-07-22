import java.util.Arrays;

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

    public static void mergeSort(int[] array, int n, boolean showSortProcess) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, n - mid);

        mergeSort(left, mid, showSortProcess);
        mergeSort(right, n - mid, showSortProcess);

        merge(array, left, right, mid, n - mid, showSortProcess);
    }

    public static void merge(int[] array, int[] left, int[] right, int leftLen, int rightLen, boolean showSortProcess) {
        int i = 0, j = 0, k = 0;
        while (i < leftLen && j < rightLen) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < leftLen) {
            array[k++] = left[i++];
        }
        while (j < rightLen) {
            array[k++] = right[j++];
        }
        if (showSortProcess)  Main.printArray(array);
    }

    public static void cocktailSort(int[] sourceArray, boolean showSortProcess) {
        int[] array = sourceArray.clone();
        int temp;
        int left = 0;
        int right = array.length - 1;

        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    if (showSortProcess)  Main.printArray(array);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i - 1] > array[i]) {
                    temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;

                    if (showSortProcess)  Main.printArray(array);
                }
            }
            left++;

        } while (left < right);
    }

    public static void combSort(int[] sourceArray, boolean showSortProcess) {
        int[] array = sourceArray.clone();
        int gap = array.length;
        while (gap != 1) {

            if (gap > 1) {
                gap = gap * 10 / 13;
            } else {
                gap = 1;
            }

            for (int i = 0; i < array.length - gap; i++) {
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;

                    if (showSortProcess)  Main.printArray(array);
                }
            }
        }
    }
}

