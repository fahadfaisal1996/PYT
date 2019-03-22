import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountingPairs {

    private static int[] array = new int[100];

    private static int k = 0;

    private static int noOfNumbers = 0;

    private static int count = 0;

    public static void main(String[] args) {
        int counter = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the size of array : ");
            noOfNumbers = Integer.parseInt(reader.readLine());
            System.out.println("Enter the value of k : ");
            k = Integer.parseInt(reader.readLine());
            System.out.println("Enter the elements of the array : ");
            while (counter < noOfNumbers) {
                array[counter++] = Integer.parseInt(reader.readLine());
            }
            sort(array, noOfNumbers);
            int noOfUniqueElements = removeDuplicates(array, noOfNumbers);

            System.out.println("No. of unique pairs : " + countPairs(array, k, noOfUniqueElements));
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

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

    private static int countPairs(int[] array, int k, int length) {
        int start = 0;
        int end = 0;
        while (end < length) {
            if (array[end] - array[start] == k) {
                count++;
                start++;
                end++;
            } else if (array[end] - array[start] > k) {
                start++;
            } else {
                end++;
            }
        }
        return count;
    }

    private static int removeDuplicates(int array[], int length) {
        int i = 0;
        int j = 0;
        for (i = 0; i < length - 1; i++) {
            if (array[i] != array[i + 1]) {
                array[j++] = array[i];
            }
        }
        array[j++] = array[i];
        return j;
    }
}