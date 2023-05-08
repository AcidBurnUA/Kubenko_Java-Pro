package Homework8;
import java.util.Arrays;
import java.util.Arrays;

public class ArrayValueCalculator {

    public static int doCalc(String[][] arr) throws ArraySizeException, ArrayDataException {
        if (arr.length != 4 || Arrays.stream(arr).anyMatch(a -> a.length != 4)) {
            throw new ArraySizeException("The array must be of size 4x4");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in cell (" + i + "," + j + ")");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = doCalc(arr);
            System.out.println("Result: " + result);
        } catch (ArraySizeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}