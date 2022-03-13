import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Количество элементов в массиве: ");
        int n = sc.nextInt();

        int max, min;
        System.out.print("min = ");
        min = sc.nextInt();
        System.out.print("max = ");
        max = sc.nextInt();

        int[] array = randomize(n, min, max);
//        System.out.println("Ваш массив");
//        for (int item : array) {
//            System.out.print(item + " ");
//        }
//        System.out.println('\n');

        choiceSort();
        int key = sc.nextInt();
        showMenu(key, array);
    }

    static int[] randomize(int n, int start, int end) {
        int[] items = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            items[i] = r.nextInt(end - start) + start;
        }
        return items;
    }

    static void choiceSort() {
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

    static void countSortsRuntime(int[] array) {
        System.out.println("Runtime");

        Sort.bubbleSort(array);

        Sort.insertionSort(array);

        Sort.shellSort(array);

        int[] arr = array.clone();
        Sort.quickSort(arr, 0, arr.length, true);

        Sort.selectionSort(array);

        Sort.countingSort(array);
    }

    static void showMenu(int key, int[] array) {
        Scanner sc = new Scanner(System.in);

        while (key != 0) {
            switch (key) {
                case 1:
                    Sort.bubbleSort(array);
                    break;
                case 2:
                    Sort.insertionSort(array);
                    break;
                case 3:
                    Sort.shellSort(array);
                    break;
                case 4:
                    int[] arr = array.clone();
                    Sort.quickSort(arr, 0, arr.length, true);
                    break;
                case 5:
                    Sort.selectionSort(array);
                    break;
                case 6:
                    Sort.countingSort(array);
                    break;
                case 7:
                    countSortsRuntime(array);
                    break;
            }
            choiceSort();
            key = sc.nextInt();
        }
    }
}
