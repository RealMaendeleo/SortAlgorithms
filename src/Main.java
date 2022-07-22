import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество элементов в массиве: ");
        int n = scanner.nextInt();

        int max, min;
        System.out.print("min = ");
        min = scanner.nextInt();
        System.out.print("max = ");
        max = scanner.nextInt();

        int[] array = randomize(n, min, max);
        printArray(array);
        chooseSort(array, scanner);
    }

    public static int[] randomize(int n, int start, int end) {
        int[] items = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            items[i] = r.nextInt(end - start) + start;
        }
        return items;
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void showMenu() {
        System.out.println("Выберите сортировку:");
        System.out.println("  1.Время работы каждой сортировки");
        System.out.println("  2.Пузырьковая");
        System.out.println("  3.Вставками");
        System.out.println("  4.Шелла");
        System.out.println("  5.Быстрая");
        System.out.println("  6.Выбором");
        System.out.println("  7.Подсчетом");
        System.out.println("  8.Слиянием");
        System.out.println("  9.Шейкерная");
        System.out.println("  10.Расческой");
    }

    public static void countSortsRuntime(int[] array) {
        long startTime, runTime;
        System.out.println("Runtime");
        boolean showSortProcess = false;

        startTime = System.currentTimeMillis();
        Sort.bubbleSort(array, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Пузырьковая: " + runTime + " мс.");

        startTime = System.currentTimeMillis();
        Sort.insertionSort(array, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Вставками: " + runTime + " мс.");

        startTime = System.currentTimeMillis();
        Sort.shellSort(array, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Шелла: " + runTime + " мс.");

        int[] arr = array.clone();
        startTime = System.currentTimeMillis();
        Sort.quickSort(arr, 0, arr.length, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Быстрая: " + runTime + " мс.");

        startTime = System.currentTimeMillis();
        Sort.selectionSort(array, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Выбором: " + runTime + " мс.");

        startTime = System.currentTimeMillis();
        Sort.countingSort(array, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Подсчетом: " + runTime + " мс.");

        arr = array.clone();
        startTime = System.currentTimeMillis();
        Sort.mergeSort(arr, arr.length, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Слиянием: " + runTime + " мс.");

        startTime = System.currentTimeMillis();
        Sort.cocktailSort(array, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Шейкерная: " + runTime + " мс.");

        startTime = System.currentTimeMillis();
        Sort.combSort(array, showSortProcess);
        runTime = System.currentTimeMillis() - startTime;
        System.out.println("  Расческой: " + runTime + " мс.");
    }

    public static void chooseSort(int[] array, Scanner scanner) {
        showMenu();
        boolean showSortProcess = true;
        long startTime, runTime;

        if (!scanner.hasNextInt()) {
            return;
        }
        int key = scanner.nextInt();

        while (key > 0 && key < 11) {
            printArray(array);
            startTime = System.currentTimeMillis();

            switch (key) {
                case 1:
                    countSortsRuntime(array);
                    break;
                case 2:
                    Sort.bubbleSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("  Пузырьковая: " + runTime + " мс.");
                    break;
                case 3:
                    Sort.insertionSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Вставками: " + runTime + " мс.");
                    break;
                case 4:
                    Sort.shellSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Шелла: " + runTime + " мс.");
                    break;
                case 5:
                    int[] arr = array.clone();
                    Sort.quickSort(arr, 0, arr.length, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Быстрая: " + runTime + " мс.");
                    break;
                case 6:
                    Sort.selectionSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Выбором: " + runTime + " мс.");
                    break;
                case 7:
                    Sort.countingSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Подсчетом: " + runTime + " мс.");
                    break;
                case 8:
                    arr = array.clone();
                    Sort.mergeSort(arr, arr.length, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Слиянием: " + runTime + " мс.");
                    break;
                case 9:
                    Sort.cocktailSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Шейкерная: " + runTime + " мс.");
                    break;
                case 10:
                    Sort.combSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Расческой: " + runTime + " мс.");
                    break;
            }
            chooseSort(array, scanner);
            if (!scanner.hasNextInt()) {
                return;
            }
            key = scanner.nextInt();
        }
    }
}
