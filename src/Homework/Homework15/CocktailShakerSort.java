package Homework15;

public class CocktailShakerSort {
    public static void cocktailShakerSort(int[] array) {
        boolean swapped;
        int start = 0;
        int end = array.length - 1;

        do {
            swapped = false;

            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;

            end--;

            // Прохід вліво
            for (int i = end - 1; i >= start; i--) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }

            start++;
        } while (swapped);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 1, 3, 6, 2, 7, 4};

        System.out.println("Масив до сортування:");
        printArray(array);

        cocktailShakerSort(array);

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
