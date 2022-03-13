// Сортировки по возрастанию

public class Sort {

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        int[] items = array;
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[i] > items[j]) {
                    int temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
//                    printArray(array);
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        int m = 1;
        int k;
        int temp;
        while (m != array.length) {
            k = m;
            for (int i = m - 1; i >= 0; i--) {
                if (array[i] > array[k]) {
                    temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                    k--;
                }
//                printArray(array);
            }
            m++;
        }
    }

    public static void shellSort(int[] array) {
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
    }

    public static void quickSort(int[] array, int first, int last) {
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

            quickSort(array, first, rIndex + 1);
            quickSort(array, lIndex, last);
        }
    }
}
