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
        System.out.println("  0.Выход");
        System.out.println("  1.Пузырьковая");
        System.out.println("  2.Вставками");
        System.out.println("  3.Шелла");
        System.out.println("  4.Быстрая");
        System.out.println("  5.Выбором");
        System.out.println("  6.Подсчетом");
        System.out.println("  7.Время работы каждой сортировки");
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
    }

    public static void chooseSort(int[] array, Scanner scanner) {
        showMenu();
        boolean showSortProcess = true;
        long startTime, runTime;
        int key = scanner.nextInt();

        while (key != 0) {
            printArray(array);
            startTime = System.currentTimeMillis();

            switch (key) {
                case 1:
                    Sort.bubbleSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("  Пузырьковая: " + runTime + " мс.");
                    break;
                case 2:
                    Sort.insertionSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Вставками: " + runTime + " мс.");
                    break;
                case 3:
                    Sort.shellSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Шелла: " + runTime + " мс.");
                    break;
                case 4:
                    int[] arr = array.clone();
                    Sort.quickSort(arr, 0, arr.length, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Быстрая: " + runTime + " мс.");
                    break;
                case 5:
                    Sort.selectionSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Выбором: " + runTime + " мс.");
                    break;
                case 6:
                    Sort.countingSort(array, showSortProcess);
                    runTime = System.currentTimeMillis() - startTime;
                    System.out.println("Подсчетом: " + runTime + " мс.");
                    break;
                case 7:
                    countSortsRuntime(array);
                    break;
            }
            chooseSort(array, scanner);
            key = scanner.nextInt();
        }
    }
}
