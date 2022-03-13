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

        int[] sourceArray = randomize(n, min, max);
//        System.out.println("Ваш массив");
//        for (int item : array) {
//            System.out.print(item + " ");
//        }
        System.out.println('\n');

        showMenu();
        long startTime, runtime;
        int key = sc.nextInt();

        while (key != 0) {
            switch (key) {
                case 1:
                    startTime = System.currentTimeMillis();
                    int[] array1 = sourceArray;
                    Sort.bubbleSort(array1);
                    runtime = System.currentTimeMillis() - startTime;
                    System.out.println("Runtime: " + runtime + " мс.\n");
                    break;
                case 2:
                    startTime = System.currentTimeMillis();
                    int[] array2 = sourceArray;
                    Sort.insertionSort(array2);
                    runtime = System.currentTimeMillis() - startTime;
                    System.out.println("Runtime: " + runtime + " мс.\n");
                    break;
                case 3:
                    startTime = System.currentTimeMillis();
                    int[] array3 = sourceArray;
                    Sort.shellSort(array3);
                    runtime = System.currentTimeMillis() - startTime;
                    System.out.println("Runtime: " + runtime + " мс.\n");
                    break;
                case 4:
                    startTime = System.currentTimeMillis();
                    int[] array4 = sourceArray;
                    Sort.quickSort(array4, 0, array4.length);
                    runtime = System.currentTimeMillis() - startTime;
                    System.out.println("Runtime: " + runtime + " мс.\n");
                    break;
            }
            showMenu();
            key = sc.nextInt();
        }
    }

    static int[] randomize(int n, int start, int end) {
        int[] items = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            items[i] = r.nextInt(end - start) + start;
        }
        return items;
    }

    static void showMenu() {
        System.out.println("Выберите сортировку");
        System.out.println("  0. Выход");
        System.out.println("  1. Пузырьковая");
        System.out.println("  2. Вставками");
        System.out.println("  3. Шелла");
        System.out.println("  4. Быстрая");
    }
}
