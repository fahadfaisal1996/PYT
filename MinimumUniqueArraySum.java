import java.io.*;
import java.util.Arrays;

public class MinimumUniqueArraySum {

    /*
     * Sample Output:
     * 
     * Enter size of the array : 5 Enter the numbers : 5 1 1 4 3 Minimum unique array sum : 15
     */

    public static void main(String[] args) {
        int arraySize = 0;
        int[] array = new int[2000];
        int counter = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter size of the array : ");
            arraySize = Integer.parseInt(reader.readLine());

            if (arraySize < 1 || arraySize > 2000) {
                throw new RuntimeException("Array size must be between 1 and 2000");
            }

            System.out.println("Enter the numbers : ");

            while (counter < arraySize) {
                array[counter] = Integer.parseInt(reader.readLine());
                if (array[counter] < 1 || array[counter] > 3000) {
                    throw new RuntimeException("Array value must be between 1 and 3000");
                }
                counter++;
            }

            sort(array, arraySize);

            System.out.println("Minimum unique array sum : " + getMinimumUniqueSum(array, arraySize));

        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }

    private static int getMinimumUniqueSum(int[] array, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] == array[j]) {
                    array[j]++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static void sort(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int temp = 0;
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
