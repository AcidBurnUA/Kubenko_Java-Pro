package Homework15;

public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
           if (array[j] <= pivot) {
                i++;

                // Міняємо місцями елементи з індексами i та j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 1, 3, 6, 2, 7, 4};

        System.out.println("Масив до сортування:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("Масив після сортування:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}